package data_structure.bj2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * author         : matrix
 * date           : 2023-08-22
 * description    : 백준 2018 수들의 합 5
 * https://www.acmicpc.net/problem/2018
 */
public class Main {
    public static void main(String[] args) throws IOException {

        // 1. 정수 N을 입력 받는다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.valueOf(br.readLine());

        // 2. 연속된 자연수의 합으로 나타내는 가지수 계산
        int answer = 1; // 가지수. 제일 마지막 케이스 미리 계산
        int start_index = 1;
        int end_index = 1;
        long sum = 1;
        while (end_index != number) {
            if (sum == number) { // 구간합이 N과 같다면 end_index를 1 증가시키고 구간합에 end_index 값을 더한다.
                answer++;
                end_index++;
                sum += end_index;
            } else if (sum < number) { // 구간합이 N보다 작다면 end_index를 1 증가시키고 구간합에 end_index 값을 더한다.
                end_index++;
                sum += end_index;
            } else { // 구간합이 N보다 크다면 구간합에서 start_index 값을 빼고, start_index를 1 증가 시킨다.
                sum -= start_index;
                start_index++;
            }
        }
        System.out.println(answer);
    }
}
