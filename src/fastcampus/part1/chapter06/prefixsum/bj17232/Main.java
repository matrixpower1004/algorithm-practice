package fastcampus.part1.chapter06.prefixsum.bj17232;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  백준 17232 생명 게임
 *  https://www.acmicpc.net/problem/17232
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        int T = Integer.valueOf(st.nextToken());

        char[][] map = new char[N + 1][M + 1];
        st = new StringTokenizer(br.readLine());
        int K = Integer.valueOf(st.nextToken());
        int a = Integer.valueOf(st.nextToken());
        int b = Integer.valueOf(st.nextToken());

        // 입력을 받아서 바둑판에 생명을 배치한다.
        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            for (int j = 1; j <= M ; j++) {
                map[i][j] = input.charAt(j - 1);
            }
        }

        // T 시간동안 각 칸은 시간마다 아래의 상황을 반복한다.
        // 1. 생존: 현재 칸에 생명이 있고, a ≤ 주위생명 ≤ b라면 해당칸의 생명은 생존한다.
        // 2. 고독: 현재 칸에 생명이 있고, 주위생명 < a 라면 해당 칸의 생명은 외로워서 죽는다.
        // 3. 과밀: 현재 칸에 생명이 있고, b < 주위생명 이라면 해당 칸의 셩명은 과밀로 죽는다.
        // 4. 탄생: 현재 칸에 생명이 없고, a < 주위생명 ≤ b 라면 해당 칸에 생명이 생긴다.

        while (T-- > 0) {
            int[][] acc = getPrefixSum(map); // 누적합 배열 만들기
            for (int row = 1; row <= N; row++) {
                for (int col = 1; col <= M ; col++) {
                    int nearLife = getRangeSum(acc, row, col, K); // 자기 자신을 포함한 생명의 수
                    if (map[row][col] == '*') {
                        nearLife--;
                        if (nearLife < a || b < nearLife) {
                            map[row][col] = '.';
                        }
                    }
                    else if (a < nearLife && nearLife <= b) {
                        map[row][col] = '*';
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int row = 1; row <= N ; row++) {
            for (int col = 1; col <= M; col++) {
                sb.append(map[row][col]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int[][] getPrefixSum(char[][] map) {
        int N = map.length - 1;
        int M = map[0].length - 1;
        int[][] acc = new int[N + 1][M + 1];
        // 2차원 배열 map의 누적합 acc를 구한다.
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int alive = (map[i][j] == '*' ? 1 : 0);
                acc[i][j] = acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1] + alive;
            }
        }
        return acc;
    }

    private static int getRangeSum(int[][] acc, int r, int c, int K) {
        // r1, c1, r2, c2 가 index 범위를 넘어가지 않도록 해야 한다.
        int r1 = Math.max(r - K, 1);
        int c1 = Math.max(c - K, 1);
        int r2 = Math.min(r + K, acc.length - 1);
        int c2 = Math.min(c + K, acc[0].length - 1) ;
        return acc[r2][c2] - acc[r2][c1 - 1] - acc[r1 - 1][c2] + acc[r1 - 1][c1 - 1];
    }

}
