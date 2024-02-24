package fastcampus.part1.chapter08.two_pointer.bj14465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 14465: 소가 길을 건너간 이유 5: https://www.acmicpc.net/problem/14465
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 횡단보도의 수
        int K = Integer.parseInt(st.nextToken()); // 연속으로 작동해야 하는 신호등의 수
        int B = Integer.parseInt(st.nextToken()); // 고장난 신호등의 번호

        boolean[] isBroken = new boolean[N + 1]; // index 1부터 다룰 것이므로 N + 1개로 생성
        for (int i = 0; i < B ; i++) {
            int index = Integer.parseInt(br.readLine());
            isBroken[index] = true; // 고장난 신호등은 true로 교체.
        }

        // 구간합을 이용한 풀이
        int[] accBroken = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            accBroken[i] = accBroken[i - 1] + (isBroken[i] ? 1 : 0);
        }

        int ans = K;
        for (int i = 1; i <= N - K + 1; i++) {
            int prefixSum = accBroken[i + K - 1] - accBroken[i - 1];
            ans = Math.min(ans, prefixSum);
        }
        System.out.println(ans);
    }
}
