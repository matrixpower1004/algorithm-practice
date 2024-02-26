package fastcampus.part1.chapter08.two_pointer.bj10025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 10025 게으른 백곰: https://www.acmicpc.net/problem/10025
 */
public class Main3 {
    private static final int SIZE = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 얼음 양동이의 개수
        int K = Integer.parseInt(st.nextToken()); // 좌우로 양동이까지 닿을 수 있는 거리
        int[] ice = new int[SIZE]; // 좌표는 0 ~ 1,000,000 까지
        int lastCoordinate = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int G = Integer.parseInt(st.nextToken()); // 양동이에 들어갈 얼음의 개수
            int X = Integer.parseInt(st.nextToken()); // 양동이가 위치할 좌표 Xi
            ice[X] = G;
            lastCoordinate = Math.max(lastCoordinate, X);
        }
        // 윈도우의 크기만큼 비교 대상 구간합을 미리 계산한다.
        int start = 0;
        int window = K * 2;
        int end = Math.min(window, 1000000);
        int prefixSum = 0;
        for (int i = start; i <= end; i++) {
            prefixSum += ice[i];
        }

        // 슬라이딩 윈도우를 이동하면서 구간합을 계산한다.
        int ans = prefixSum;
        while (end <= lastCoordinate) {
            ans = Math.max(ans, prefixSum);
            prefixSum -= ice[start++];
            prefixSum += ice[++end];
        }
        System.out.println(ans);
    }
}
