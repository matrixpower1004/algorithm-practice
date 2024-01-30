package fastcampus.part1.chapter03.arrays.bj1236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * author         : Jisang Lee
 * date           : 2023-11-13
 * description    : 백준 1236 성 지키기
 * https://www.acmicpc.net/problem/1236
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rowSize = Integer.valueOf(st.nextToken());
        int columnSize = Integer.valueOf(st.nextToken());

        char[][] map = new char[rowSize][columnSize];
        for (int i = 0; i < rowSize; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
        }

        // 1. 각 행과 열에 대해 경비원이 있는지 확인한다.
        boolean[] existRow = new boolean[rowSize];
        boolean[] existColumn = new boolean[columnSize];
        for (int r = 0; r < rowSize ; r++) {
            for (int c = 0; c < columnSize ; c++) {
                if (map[r][c] == 'X') {
                    existRow[r] = true;
                    existColumn[c] = true;
                }
            }
        }

        // 2. 보호받지 못하는 행과 열의 갯수를 구한다.
        int needRowCount = rowSize;
        int needColumnCount = columnSize;
        for (int i = 0; i < rowSize; i++) {
            if (existRow[i]) needRowCount--;
        }
        for (int i = 0; i < columnSize; i++) {
            if (existColumn[i]) needColumnCount--;
        }

        // 3. 둘 중 큰 값을 출력한다.
        System.out.println(Math.max(needRowCount, needColumnCount));
    }

}
