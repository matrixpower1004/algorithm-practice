package fastcampus.part1.chapter03.arrays.bj10889;

import java.io.*;

/**
 * author         : Jisang Lee
 * date           : 2023-12-08
 * description    : 백준 10989 수 정렬하기 3
 * https://www.acmicpc.net/problem/10989
 */
public class Main {

    private static final int MAX = 10000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine()); // 입력할 수의 개수
        int count[] = new int[MAX + 1]; // 입력되는 수의 범위는 1 <= 10000. 카운트 배열로 잡아 놓는다.

        for (int i = 0; i < N; i++) { // 입력된 수만큼 반복
            int index = Integer.valueOf(br.readLine());
            count[index]++; // 카운트 배열에서 입력된 값의 개수를 증가시킨다.
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < MAX + 1; i++) {
            while (count[i]-- > 0) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
