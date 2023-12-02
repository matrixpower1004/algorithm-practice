package fastcampus.part5.brute_force_search.bj15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * author         : Jisang Lee
 * date           : 2023-12-03
 * description    : 백준 15652 N과 M (4)
 * https://www.acmicpc.net/problem/15652
 */
public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static int[] selected;
    private static boolean[] used;

    public static void main(String[] args) throws IOException {
        input();

        rec_func(1);
        System.out.println(sb.toString());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M + 1];
        used = new boolean[N + 1];
    }

    private static void rec_func(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int start = selected[k - 1];
        if (start == 0) start = 1;
        for (int cand = start; cand <= N; cand++) {
            selected[k] = cand;

            rec_func(k + 1);

            selected[k] = 0;
        }
    }
}
