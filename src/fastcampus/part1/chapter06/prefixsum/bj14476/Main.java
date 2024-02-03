package fastcampus.part1.chapter06.prefixsum.bj14476;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 14476 최대공약수 하나 빼기
 * https://www.acmicpc.net/problem/14476
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        int[] accLeft = new int[N + 1];
        int[] accRight = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            accLeft[i] = calculateGCD(accLeft[i - 1], arr[i]);
            accRight[N - i + 1] = calculateGCD(accRight[N - i + 2], arr[N - i + 1]);
        }

        int maxGCD = -1;
        int maxK = -1;
        for (int i = 1; i <= N ; i++) {
            int gcd = calculateGCD(accLeft[i - 1], accRight[i + 1]);
            if (arr[i] % gcd != 0 && maxGCD < gcd) {
                maxGCD = gcd;
                maxK = arr[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        System.out.println(maxGCD > 0 ? maxGCD + " " + maxK : "-1");
    }

    private static int calculateGCD(int a, int b) {
        while (b > 0) {
            int tmp = a;
            a = b;
            b = tmp % b; // 유클리드 호제법을 이용
        }
        return a;
    }
}
