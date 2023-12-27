package fastcampus.part1.chapter04_brute_force_simulation.bj3085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * author         : Jisang Lee
 * date           : 2023-12-15
 * description    : 백준 3085 사탕 게임
 * https://www.acmicpc.net/problem/3085
 */
public class Main {
    private static char[][] map;
    private static int N; // 테스트 케이스의 수
    private static int candyCount; // 찾은 최대 사탕의 수

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(candyCount);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }

    private static void solution() {
        // 1. N만큼 행과 열을 순회하며 사탕을 교환하고 최대값을 찾는다.
        for (int row = 0; checkCondition(row); row++) {
            // 2. 열을 교환하기 전에 현재 행에서 최대 캔디가 있는지 체크한다.
            candyCount = Math.max(candyCount, findCandyToRow(row));
            for (int col = 0; checkCondition(col); col++) {
                // 3. 현재 열에서 최대 캔디가 있는지 체크한다.
                candyCount = Math.max(candyCount, findCandyToColumn(col));
                // 4. 가로 방향으로 사탕을 교환하고 교환한 행들의 행방향 탐색과 열방향 탐색을 한다.
                if (col + 1 < N && map[row][col] != map[row][col + 1]) {
                    swapCandy(row, col, row, col + 1); // 가로 방향 캔디 교환
                    // 가로 방향으로 캔디를 교환 했다면 가로 방향 1번, 세로방향 2번의 탐색을 해야 한다.
                    candyCount = checkAfterSwappedColumn(candyCount, row, col);
                    swapCandy(row, col, row, col + 1); // 교환한 캔디를 원상복구 한다.
                }
                // 5. 세로 방향으로 사탕을 교환하고 마찬가지로 교환한 열들의 행방향 탐색과 열방향 탐색을 해준다.
                if (row + 1 < N && map[row][col] != map[row + 1][col]) {
                    swapCandy(row, col, row + 1, col); // 세로 방향 캔디 교환
                    // 세로 방향으로 캔디를 교환 했다면 가로 방향 2번, 세로방향 1번의 탐색을 해야 한다.
                    candyCount = checkAfterSwappedRow(candyCount, row, col);
                    swapCandy(row, col, row + 1, col); // 교환한 캔디를 원상복구 한다.
                }
            } // end of col
        } // end of row
    }

    private static boolean checkCondition(int x) {
        if (candyCount < N && x < N) { // 최대 사탕 갯수를 찾으면 더 볼 필요가 없다.
            return true;
        }
        return false;
    }
    private static int checkAfterSwappedRow(int findMax, int row, int col) {
        findMax = Math.max(findMax, findCandyToRow(row));
        findMax = Math.max(findMax, findCandyToRow(row + 1));
        findMax = Math.max(findMax, findCandyToColumn(col));
        return findMax;
    }

    private static int checkAfterSwappedColumn(int findMax, int row, int col) {
        findMax = Math.max(findMax, findCandyToRow(row));
        findMax = Math.max(findMax, findCandyToColumn(col));
        findMax = Math.max(findMax, findCandyToColumn(col + 1));
        return findMax;
    }

    private static void swapCandy(int r1, int c1, int r2, int c2) {
        char temp = map[r1][c1];
        map[r1][c1] = map[r2][c2];
        map[r2][c2] = temp;
    }

    // 열방향 탐색은 열은 고정, 행은 1부터 N까지
    private static int findCandyToColumn(int col) { // ↓ 열방향 탐색(세로 방향)
        int max = 0;
        int len = 1;
        for (int i = 1; i < N; i++) {
            if (map[i][col] == map[i - 1][col]) {
                len++; // 이전 행과 현재 행의 캔디 색상이 같다면 연속성을 1 증가시킨다.
            } else {
                // 같은 색상의 캔디가 아닌 경우 max 값과 현재 연속성 값을 비교하여 큰 값을 max에 담는다.
                max = Math.max(max, len);
                len = 1;
            }
        }
        max = Math.max(max, len);
        return max;
    }

    // 행방향 탐색은 행은 고정, 열은 1 부터 N까지 탐색
    private static int findCandyToRow(int row) { // → 행방향 탐색(가로 방향)
        int max = 0;
        int len = 1;
        for (int i = 1; i < N; i++) {
            if (map[row][i] == map[row][i - 1]) {
                len++; // 이전 열과 현재 열의 캔디 색상이 같다면 연속성을 1 증가시킨다.
            } else {
                // 같은 색상의 캔디가 아닌 경우 max 값과 현재 연속성 값을 비교하여 큰 값을 max에 담는다.
                max = Math.max(max, len);
                len = 1;
            }
        }
        max = Math.max(max, len);
        return max;
    }
}
