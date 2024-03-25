package fastcampus.part2.chapter2.stack.bj2812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2812 크게 만들기: https://www.acmicpc.net/problem/2812
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N자리 숫자
        int K = Integer.parseInt(st.nextToken()); // 지울 수 K
        String input = br.readLine();

        int ansLength = N - K;
        char[] maxDigits = new char[N];
        int topIndex = -1;
        for (char digit : input.toCharArray()) {
            // 자리값이 큰 수를 삭제하여 그 자리에 더 큰 수가 오도록 내림차순 부분 수열을 만든다.
            while (K > 0 && topIndex >= 0 && maxDigits[topIndex] < digit) {
                topIndex--;
                K--;
            }
            maxDigits[++topIndex] = digit;
        }
        // 스택에 쌓이는 숫자의 개수는 답의 자리수보다 많을 수 있다.
        System.out.println(new String(maxDigits, 0, ansLength));
    }
}
