package fastcampus.part2.chapter2.stack.bj4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 백준 4949 균형잡힌 세상:https://www.acmicpc.net/problem/4949
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        while (true) {
            char[] input = br.readLine().toCharArray();
            if (input[0] == '.') {
                break;
            }
            ans.append(isBalanceString(input)).append("\n");
        }
        System.out.println(ans);
    }

    private static String isBalanceString(char[] input) {
        Deque<Character> balance = new ArrayDeque<>();
        boolean isValid = true;
        for (char c : input) {
            if (c == '(') {
                balance.offerFirst(c);
            } else if (c == ')') {
                if (balance.isEmpty() || balance.peekFirst() != '(') {
                    isValid = false;
                    break;
                }
                balance.pollFirst();
            } else if (c == '[') {
                balance.offerFirst(c);
            } else if (c == ']') {
                if (balance.isEmpty() || balance.peekFirst() != '[') {
                    isValid = false;
                    break;
                }
                balance.pollFirst();
            }
        }
        if (isValid && balance.isEmpty()) {
            return "yes";
        }
        return "no";
    }
}
