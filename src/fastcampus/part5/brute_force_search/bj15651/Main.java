package fastcampus.part5.brute_force_search.bj15651;

import java.io.*;
import java.util.StringTokenizer;

/**
 * author         : Jisang Lee
 * date           : 2023-12-01
 * description    : 백준 15651 N과 M(3)
 * https://www.acmicpc.net/problem/15651
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
        for (int cand = 1; cand <= N; cand++) {
            selected[k] = cand;

            rec_func(k + 1);
            // 재귀 호출이 끝난 후 사용했던 변수들을 잊지 말고 초기화 하자.
            selected[k] = 0;
        }
    }

}
