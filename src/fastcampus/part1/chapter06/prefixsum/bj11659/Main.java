package fastcampus.part1.chapter06.prefixsum.bj11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 11659 구간 합 구하기 4
 * https://www.acmicpc.net/problem/11659
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        int[] num = new int[N + 1];
        int[] prefixSum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.valueOf(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + num[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.valueOf(st.nextToken());
            int R = Integer.valueOf(st.nextToken());
            int result = prefixSum[R] - prefixSum[L - 1];
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
