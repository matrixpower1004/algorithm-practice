package fastcampus.part1.chapter08.two_pointer.bj17609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 17609 회문: https://www.acmicpc.net/problem/17609
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            int left = 0;
            int right = input.length() - 1;
            int count = 0;
            int ans = checkPalindrome(input, left, right, count);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static int checkPalindrome(String input, int left, int right, int count) {
        if (count >= 2) {
            return 2;
        }
        while (left < right) {
            if (isPalindrome(input, left, right)) {
                left++;
                right--;
            } else {
                // abbab 와 같은 반례가 있을 수 있으므로 왼쪽 문자를 제거했을 때, 오른쪽 문자를 제거했을 때 두가지 케이스를 모두 봐야 한다.
                int check1 = checkPalindrome(input, left + 1, right, count + 1);
                int check2 = checkPalindrome(input, left, right - 1, count + 1);
                return Math.min(check1, check2);
            }
        }
        return count;
    }

    private static boolean isPalindrome(String input, int left, int right) {
        return input.charAt(left) == input.charAt(right);
    }
}
