package fastcampus.part2.chapter3.recursion.bj15656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 15656 N과 M (7): https://www.acmicpc.net/problem/15656
 */

public class Main {
    static int N, M;
    static int[] numbers, output;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        output = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        perm(0);
        System.out.println(sb);
    }

    static void perm(int depth) {
        // base case
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(output[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        // recursive case
        for (int i = 0; i < N; i++) {
            output[depth] = numbers[i];
            perm(depth + 1); // 중복 포함하여 모든 경우의 조합을 생성
        }
    }
}
