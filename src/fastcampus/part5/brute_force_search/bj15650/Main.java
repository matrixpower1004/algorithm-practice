package fastcampus.part5.brute_force_search.bj15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * author         : Jisang Lee
 * date           : 2023-12-03
 * description    : 백준 15650 N과 M (2)
 * https://www.acmicpc.net/problem/15650
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
        for (int cand = selected[k - 1] + 1; cand <= N; cand++) {
            if (used[cand] == true) continue;
            selected[k] = cand;
            used[cand] = true;

            rec_func(k + 1);

            // 재귀 호출이 끝난 후 사용했던 변수들을 잊지 말고 초기화 하자.
            selected[k] = 0;
            used[cand] = false;
        }
    }
}
