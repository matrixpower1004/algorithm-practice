package fastcampus.part1.chapter06.prefixsum.bj11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  백준 11660 구간 합 구하기 5
 *  https://www.acmicpc.net/problem/11660
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int Q = Integer.valueOf(st.nextToken());

        int[][] arr = new int[N + 1][N + 1]; // 입력되는 값을 저잫하는 배열
        for (int row = 1; row <= N ; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 1; col <= N; col++) {
                arr[row][col] = Integer.valueOf(st.nextToken());
            }
        }

        int[][] acc = new int[N + 1][N + 1]; // 구간합을 구하여 저장하는 배열
        for (int row = 1; row <= N ; row++) {
            for (int col = 1; col <= N; col++) {
                acc[row][col] =
                    acc[row - 1][col] + acc[row][col - 1] - acc[row - 1][col - 1] + arr[row][col];
            }
        }

        StringBuilder sb = new StringBuilder();
        // 백준 문제 설명은 x1, y1 이라고 나오지만 2차원 배열은 row 값이 먼저 온다.
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.valueOf(st.nextToken()); // x1
            int c1 = Integer.valueOf(st.nextToken()); // y1
            int r2 = Integer.valueOf(st.nextToken()); // x2
            int c2 = Integer.valueOf(st.nextToken()); // y2
            int ans = acc[r2][c2] - acc[r1 - 1][c2] - acc[r2][c1 - 1] + acc[r1 - 1][c1 - 1];
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
