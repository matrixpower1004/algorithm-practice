package fastcampus.part1.chapter04.brute_force_simulation.bj2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * author         : Jisang Lee
 * date           : 2023-12-11
 * description    : 백준 2309 일곱 난쟁이
 * https://www.acmicpc.net/problem/2309
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] height = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            int value = Integer.valueOf(br.readLine());
            height[i] = value;
            sum += value;
        }

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - height[i] - height[j] == 100) {
                    height[i] = height[j] = -1;
                    Arrays.sort(height);
                    answerReport(height);
                    return;
                }
            }
        }
    }

    private static void answerReport(int[] height) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < 9; i++) { // index 0, 1에 저장된 키는 출력할 필요가 없다.
            sb.append(height[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
