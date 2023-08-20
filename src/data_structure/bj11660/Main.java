package data_structure.bj11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * author         : matrix
 * date           : 2023-08-20
 * description    : 백준 11660 구간 합 구하기 5
 * https://www.acmicpc.net/problem/11660
 */
public class Main {
    public static void main(String[] args) throws IOException {

        // 표의 크기 N과 합을 구해야 하는 횟수 M을 입력 받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arrSize = Integer.valueOf(st.nextToken());
        int sumCount = Integer.valueOf(st.nextToken());

        // 표의 크기만큼 반복하며 배열애 들어갈 수을 입력받는다.
        // 입력 받은 수를 바로 합배열로 계산하여 저장한다.
        int[][] sumArr = new int[arrSize + 1][arrSize + 1]; // idnex 1부터 시작하므로 입력받은 배열의 크기에 +1을 해준다.

        for (int i = 1; i < arrSize + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < arrSize + 1; j++) {
                sumArr[i][j] = sumArr[i][j - 1] + sumArr[i - 1][j] -
                        sumArr[i - 1][j - 1] + Integer.valueOf(st.nextToken());
            }
        }

        // 합배열의 값을 확인하기 위한 출력 -> 정상
//        for (int y = 1; y < arrSize + 1; y++) {
//            for (int x = 1; x < arrSize + 1; x++) {
//                System.out.printf("%d ", sumArr[y][x]);
//            }
//            System.out.println();
//        }

        System.out.println(sumArr[3][2]);

        StringBuffer sb = new StringBuffer();

        // 합을 구할 구간 4개의 정수를 입력 받고 구간합을 계산한다.
        for (int i = 0; i < sumCount; i++) {
            st = new StringTokenizer(br.readLine());
            int beginX = Integer.valueOf(st.nextToken());
            int beginY = Integer.valueOf(st.nextToken());
            int endX = Integer.valueOf(st.nextToken());
            int endY = Integer.valueOf(st.nextToken());

            long intervalSum = sumArr[endX][endY] - sumArr[beginX - 1][endY] -
                    sumArr[endX][beginY - 1] + sumArr[beginX - 1][beginY - 1];
            sb.append(intervalSum).append("\n");
        }

        // 합을 구한 구간을 출력한다.
        System.out.println(sb);
    }
}
