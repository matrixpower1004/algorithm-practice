package fastcampus.part1.chapter04_brute_force_simulation.bj2331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * author         : Jisang Lee
 * date           : 2023-12-23
 * description    : 백준 2331 분해합
 * https://www.acmicpc.net/problem/2231
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.valueOf(input);
        int digit = input.length();

        int answer = 0;
        for (int i = N - (digit * 9); i < N; i++) {
            if (getFactor(i) == N) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

    private static int getFactor(int seed) {
        int generateNum = seed;
        while (seed > 0) {
            generateNum += seed % 10;
            seed /= 10;
        }
        return generateNum;
    }
}
