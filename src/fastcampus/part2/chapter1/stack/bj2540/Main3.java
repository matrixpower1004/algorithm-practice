package fastcampus.part2.chapter1.stack.bj2540;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2504 괄호의 값: https://www.acmicpc.net/problem/2504
 */
public class Main3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();
        int size = input.length;
        int[] stack = new int[size];
        int topIndex = -1;
        int multiple = 1;
        int ans = 0;

        for (int i = 0; i < size; i++) {
            int delimiterValue = delimiterToValue(input[i]);
            if (input[i] == '(' || input[i] == '[') {
                stack[++topIndex] = delimiterValue;
                multiple *= delimiterValue;
            } else {
                if (topIndex < 0 || stack[topIndex--] != delimiterValue) {
                    ans = 0;
                    break;
                }
                if (input[i - 1] == '(' || input[i - 1] == '[') {
                    ans += multiple;
                }
                multiple /= delimiterValue;
            }
        }
        System.out.println(topIndex < 0 ? ans : 0);
    }

    private static int delimiterToValue(char delimiter) {
        if (delimiter == '(' || delimiter == ')') {
            return 2;
        } else if (delimiter == '[' || delimiter == ']') {
            return 3;
        }
        return -1;
    }
}
