package fastcampus.part1.chapter07.parametric_search.bj2417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2417 정수 제곱근
 * https://www.acmicpc.net/problem/2417
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long answer = calcSqrt(N);
        System.out.println(answer);
    }

    private static long calcSqrt(long N) {
        if (N == 0) {
            return 0;
        }
        long left = 1L;
        long right = 1L << 32;
        long result = -1;
        while (left <= right) {
            long m = (left + right) / 2;
            if (Math.pow(m, 2) >= N) {
                right = m - 1;
                result = m;
            } else {
                left = m + 1;
            }
        }
        return result;
    }
}
