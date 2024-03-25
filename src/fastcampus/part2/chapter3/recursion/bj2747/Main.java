package fastcampus.part2.chapter3.recursion.bj2747;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2747 피보나치 수: https://www.acmicpc.net/problem/2747
 */
public class Main {

    static int[] cache = new int[50]; // 입력 되는 수는 최대 45까지

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = fibo(N);
        System.out.println(result);
    }

    private static int fibo(int n) {
        // base case
        if (n <= 2) {
            return 1;
        }
        if (cache[n] != 0) {
            return cache[n];
        }
        // recursive case
        cache[n] = fibo(n - 1) + fibo(n - 2);
        return cache[n];
    }
}
