package fastcampus.part2.chapter2.stack.bj10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 10799 쇠막대기: https://www.acmicpc.net/problem/10799
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int stickCount = 0;
        int ans = 0;
        int N = input.length();
        for (int i = 0; i < N; i++) {
            if (input.charAt(i) == '(') {
                stickCount++;
            } else {
                stickCount--;
                if (input.charAt(i - 1) == '(') {
                    ans += stickCount;
                } else {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
