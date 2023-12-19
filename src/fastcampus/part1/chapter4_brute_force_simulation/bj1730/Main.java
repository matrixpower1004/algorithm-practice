package fastcampus.part1.chapter4_brute_force_simulation.bj1730;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * author         : Jisang Lee
 * date           : 2023-12-18
// * description    : 백준 1730 판화
 * https://www.acmicpc.net/problem/1730
 */
public class Main {
    private static int x = 0;
    private static int y = 0;
    private static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 목판의 크기 N을 입력받는다. (2 <= N <= 10)
        int N = Integer.valueOf(br.readLine());
        map = new char[N][N];

        // 2. 이동경로 배열에 초기값 할당
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                map[y][x] = 46; // ascii code 46 = '.'
            }
        }

        // 2. 로봇의 움직임 문자열을 입력받는다. (최대 250)
        char[] command = br.readLine().toCharArray();
        for (int i = 0; i < command.length; i++) {
            switch (command[i]) {
                case 'D' :
                    if (y < N - 1) moveDown(); // 이동하려는 Y 좌표가 N-1보다 작을때만 이동
                    break;
                case 'U':
                    if (y > 0) moveUp(); // 이동하려는 Y 좌표가 0보다 클때만 이동
                    break;
                case 'R':
                    if (x < N - 1) moveRight(); // 이동하려는 X 좌표가 N-1보다 작을때만 이동
                    break;
                case 'L':
                    if (x > 0) moveLeft(); // 이동하려는 X 좌표가 0보다 클때만 이동
                    break;
            }
        }

        // 3. 로봇의 이동 흔적 출력
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                sb.append(map[row][col]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void moveLeft() {
        recordHorizontal();
        x--;
        recordHorizontal();
    }

    private static void moveRight() {
        recordHorizontal();
        x++;
        recordHorizontal();
    }

    private static void moveUp() {
        recordVertical();
        y--;
        recordVertical();
    }

    private static void moveDown() {
        recordVertical();
        y++;
        recordVertical();
    }

    private static void recordVertical() {
        if (map[y][x] == 46 || map[y][x] == 124) { // 방문하지 않았거나 수직 방향으로만 움직인 경우
            map[y][x] = 124; // 수직 방향 ascii code = 124
            return;
        }
        map[y][x] = 43; // 수평과 수직방향 모두 움직인 경우 ascii code = 43
    }

    private static void recordHorizontal() {
        if (map[y][x] == 46 || map[y][x] == 45) { // 방문하지 않았거나 수평방향으로만 움직인 경우
            map[y][x] = 45; // 수평방향 ascii code = 45
            return;
        }
        map[y][x] = 43; // 수평과 수직방향 모두 움직인 경우 ascii code = 43
    }
}
