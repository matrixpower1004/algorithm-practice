package fastcampus.part2.chapter2.stack.bj2540;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2504 괄호의 값: https://www.acmicpc.net/problem/2504
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();
        Status[] stack = new Status[31];
        int topIndex = -1;
        stack[++topIndex] = new Status(' ');
        for (char ch : input) {
            if (ch == '(' || ch == '[') {
                stack[++topIndex] = new Status(ch);
            } else {
                if (topIndex < 0 || !isMatchedDelimiter(stack[topIndex].openDelimiter, ch)) {
                    stack[0].innerSum = 0;
                    break;
                }
                int score = stack[topIndex].innerSum * delimiterToValue(ch);
                if (score == 0) {
                    score = delimiterToValue(ch);
                }
                stack[--topIndex].innerSum += score;
            }
        }
        System.out.println(topIndex == 0 ? stack[topIndex].innerSum : 0);
    }

    private static int delimiterToValue(char delimiter) {
        if (delimiter == '(' || delimiter == ')') {
            return 2;
        } else if (delimiter == '[' || delimiter == ']') {
            return 3;
        }
        return -1;
    }

    private static boolean isMatchedDelimiter(char openDelimiter, char closeDelimiter) {
        if (openDelimiter == '(' && closeDelimiter == ')') {
            return true;
        } else if (openDelimiter == '[' && closeDelimiter == ']') {
            return true;
        }
        return false;
    }
}

class Status {

    char openDelimiter;
    int innerSum;

    public Status(char openDelimiter) {
        this.openDelimiter = openDelimiter;
        this.innerSum = 0;
    }
}
