package fastcampus.part2.chapter2.stack.bj4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 4949 균형잡힌 세상:https://www.acmicpc.net/problem/4949
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.charAt(0) == '.') {
                break;
            }
            ans.append(isBalanceString(input)).append("\n");
        }
        System.out.println(ans);
    }

    private static String isBalanceString(String input) {
        char[] balance = new char[input.length()];
        boolean isValid = true;
        int topIndex = -1;
        for (char c : input.toCharArray()) {
            if (c == '(' || c == '[') {
                balance[++topIndex] = c;
            } else if (c == ')') {
                if (topIndex < 0 || balance[topIndex--] != '(') {
                    isValid = false;
                    break;
                }
            } else if (c == ']') {
                if (topIndex < 0 || balance[topIndex--] != '[') {
                    isValid = false;
                    break;
                }
            }
        }
        if (topIndex >= 0) {
            isValid = false;
        }
        return isValid ? "yes" : "no";
    }
}
