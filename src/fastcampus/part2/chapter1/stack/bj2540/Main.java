package fastcampus.part2.chapter1.stack.bj2540;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2504 괄호의 값: https://www.acmicpc.net/problem/2504
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();
        if (!isValidInput(input)) {
            System.out.println(0);
            return ;
        }

        Element[] stack = new Element[31];
        int topIndex = -1;
        for (char ch : input) {
            if (ch == '(' || ch == '[')
                stack[++topIndex] = new Element(Element.Type.DELIMITER, delimiterToValue(ch));
            else {
                int innerScore = 0;
                while (stack[topIndex].type == Element.Type.SCORE)  // topIndex의 값이 괄호가 되면 loop 종료
                    innerScore += stack[topIndex--].value;
                int score = innerScore * delimiterToValue(ch);
                if (score == 0) score = delimiterToValue(ch); // 바로 닫는 괄호가 나왔을 때 처리.
                stack[topIndex] = new Element(Element.Type.SCORE, score);
            }
        }

        int ans = 0;
        while (topIndex >= 0)
            ans += stack[topIndex--].value;
        System.out.println(ans);
    }

    static int delimiterToValue(char delimiter) {
        if (delimiter == '(' || delimiter == ')') return 2;
        else if (delimiter == '[' || delimiter == ']') return 3;
        return -1;
    }

    static boolean isValidInput(char[] input) {
        char[] stack = new char[input.length];
        int topIndex = -1;
        for (char ch : input) {
            if (ch == '(' || ch == '[')
                stack[++topIndex] = ch;
            else {
                if (topIndex < 0) return false;
                if (delimiterToValue(stack[topIndex]) != delimiterToValue(ch))
                    return false;
                topIndex--;
            }
        }
        return topIndex < 0;
    }
}

class Element {
    enum Type { DELIMITER, SCORE }

    Type type;
    int value;

    public Element(Type type, int value) {
        this.type = type;
        this.value = value;
    }
}
