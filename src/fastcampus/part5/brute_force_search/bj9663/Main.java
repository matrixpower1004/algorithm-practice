package fastcampus.part5.brute_force_search.bj9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * author         : Jisang Lee
 * date           : 2023-12-07
 * description    : 백준 9663 N-Queen
 * https://www.acmicpc.net/problem/9663
 */
public class Main {

    private static StringBuilder sb = new StringBuilder();
    private static int N, ans; // ans: 가능한 경우의 수를 셀 변수
    private static int[] col; // col[i] : i번 행의 퀸은 col[i]번 열에 놓았다는 기록

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        col = new int[N + 1];
    }

    private static boolean attackable(int r1, int c1, int r2, int c2) {
        if (c1 == c2) return true; // 두 퀸의 열이 같으면 공격 가능
        if (r1 - c1 == r2 - c2) { // 행-열의 값이 같으면 왼쪽 위 대각선 방향으로 공격 가능
            return true;
        }
        if (r1 + c1 == r2 + c2) { // 행+열의 값이 같으면 오론쪽 위 대각선 방향으로 공격 가능
            return true;
        }
        return false;
    }

    private static boolean validity_check() {
        for (int i = 1; i <= N; i++) {
            // (i, col[i])
            for (int j = 1; j < i; j++) {
                // (j, col[j]
                if (attackable(i, col[i], j, col[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void rec_func(int row) {
        if (row == N + 1) { // 각 행마다 하나씩 잘 놓은 경우
            ans++;
        } else {
            for (int c = 1; c <= N; c++) {
                boolean possible = true;
                // valid check (row, c)
                for (int i = 1; i <= row - 1; i++) {
                    if (attackable(row, c, i, col[i])) {
                        possible = false;
                        break;
                    }
                }
                if (possible) { // 이전에 놓은 퀸들에게 공격받지 않는 위치라면 구 위치에 값을 써주고 재귀 호출을 시작한다.
                    col[row] = c;
                    rec_func(row + 1);
                    col[row] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        // 1번째 원소부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 탐색해줘
        rec_func(1);
        System.out.println(ans);
    }
}
