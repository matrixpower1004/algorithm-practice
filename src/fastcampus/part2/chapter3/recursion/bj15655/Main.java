package fastcampus.part2.chapter3.recursion.bj15655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 15655 N과 M (6): https://www.acmicpc.net/problem/15655
 */
public class Main {

    static int N, M;
    static int[] numbers, output;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        output = new int[M];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        perm(0, 0);
        System.out.println(sb);
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
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = numbers[i];
                perm(depth + 1, i + 1); // 다음 재귀에서는 i+ 1부터 수열을 생성
                visited[i] = false;
            }
        }
    }
}
