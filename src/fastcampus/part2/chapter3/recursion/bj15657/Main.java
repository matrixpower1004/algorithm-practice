package fastcampus.part2.chapter3.recursion.bj15657;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 15657 N과 M (8): https://www.acmicpc.net/problem/15657
 */
public class Main {
    static int N, M;
    static int[] numbers, output;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
        perm(0, 0);
        bw.write(sb.toString());
        bw.flush();
    }

    static void perm(int depth, int start) {
        // base case
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(output[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        // recursive case
        for (int i = start; i < N; i++) {
            output[depth] = numbers[i];
            perm(depth + 1, i);
        }
    }
}
