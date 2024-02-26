package fastcampus.part1.chapter08.two_pointer.bj10025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 10025 게으른 백곰: https://www.acmicpc.net/problem/10025
 */
public class Main {

    private static final int SIZE = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 얼음 양동이의 개수
        int K = Integer.parseInt(st.nextToken()); // 좌우로 양동이까지 닿을 수 있는 거리
        int[] ice = new int[SIZE]; // 좌표는 0 ~ 1,000,000 까지
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int G = Integer.parseInt(st.nextToken()); // 양동이에 들어갈 얼음의 개수
            int X = Integer.parseInt(st.nextToken()); // 양동이가 위치할 좌표 Xi
            ice[X] = G;
        }
        // 슬라이딩 윈도우를 이동하면서 구간합을 계산한다.
        int window = K * 2 + 1;
        int prefixSum = 0;
        int ans = 0;
        for (int i = 0; i <= 1000000; i++) {
            if (i - window >= 0) { // K는 1 ~ 2,000,000. X보다 클 수 있다.
                prefixSum -= ice[i - window];
            }
            prefixSum += ice[i];
            ans = Math.max(ans, prefixSum); // 이전 구간합과 비교하며 최대값으로 정답을 갱신한다.
        }
        System.out.println(ans);
    }
}