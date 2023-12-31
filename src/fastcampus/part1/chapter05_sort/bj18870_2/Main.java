package fastcampus.part1.chapter05_sort.bj18870_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 백준 18870 좌표 압축
 * https://www.acmicpc.net/problem/18870
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        int[][] position = new int[N][2]; // row들어오는 좌표를 col은 들어온 순서를 저장.

        // 1. 모든 입력을 배열에 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            position[i][0] = Integer.valueOf(st.nextToken());
            position[i][1] = i; // col[1]에는 입력된 순서를 저장.
        }

        // 2. 입력받은 배열을 정렬
        Arrays.sort(position, Comparator.comparingInt(o -> o[0]));

        // 3. 출력 순서르 저장할 배열을 만들어서 출력 순서를 저정한다.
        int[] answer = new int[N];
        int index = 0;
        answer[position[0][1]] = index;
        for (int i = 1; i < N; i++) {
            if (position[i][0] != position[i - 1][0]) {
                index++;
            }
            answer[position[i][1]] = index;
        }

        // 4. 압축된 좌표가 있는 배열을 출력한다.
        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
