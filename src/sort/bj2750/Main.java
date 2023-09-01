package sort.bj2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * author         : matrix
 * date           : 2023-09-01
 * description    : 백준 2750 수 정렬하기
 * https://www.acmicpc.net/problem/2750
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 수의 개수 N 입력받기
        int N = Integer.valueOf(br.readLine());

        int[] numArr = new int[N];
        // N개 만큼 수를 입력 받아 배열에 저장한다.
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.valueOf(br.readLine());
        }
        // 성능 좋은 내장 sort() 함수가 있는데 사용하지 않을 이유가 있을까?
        Arrays.sort(numArr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(numArr[i]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
