package fastcampus.part1.chapter04.brute_force_simulation.bj1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * author         : Jisang Lee
 * date           : 2023-12-26
 * description    : 백준 1018 체스판 다시 칠하기
 * https://www.acmicpc.net/problem/1018
 */
public class Main {

    // 1. 정답은 정해져 있다. 첫번째 줄이 "WBWBWBWB" 이라면 두번째 줄은 "BWBWBWBW"이 나오는 패턴이 되어야 한다.
    private static final String[] CHESS = {"WBWBWBWB", "BWBWBWBW"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.valueOf(st.nextToken()); // row 수
        int col = Integer.valueOf(st.nextToken()); // column 수

        // 2. row의 수만큼 문자열을 입력 받는다.
        String[] board = new String[row];
        for (int i = 0; i < row; i++) {
            board[i] = br.readLine();
        }

        // 3. 체스판을 8x8 크기로 자르고 다시 칠해야 하는 수를 구한다.
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= row - 8; i++) {
            for (int j = 0; j <= col - 8; j++) {
                // 4. 현재 체스판의 최소 비용을 구한다.
                int paintCount = getPaintCount(i, j, board);
                // 5. 전체의 최소값과 비교하여 최소값을 갱신한다.
                answer = Math.min(answer, paintCount);
            }
        }
        System.out.println(answer);
    }

    private static int getPaintCount(int startRow, int startCol, String[] board) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int row = startRow + i;
            for (int j = 0; j < 8; j++) {
                int col = startCol + j;
                // 첫번재 row에서 "WBWBWBWB"을 비교했다면 두번째 row에서는 "BWBWBWBW"로 비교해야 한다.
                if (board[row].charAt(col) != CHESS[row % 2].charAt(j)) {
                    count++;
                }
            }
        }
        return (int) Math.min(count, (64 - count)); // 8x8 체스판의 크기는 64
    }
}
