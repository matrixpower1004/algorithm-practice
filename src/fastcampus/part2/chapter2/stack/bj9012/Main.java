package fastcampus.part2.chapter2.stack.bj9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  백준 9012 괄호: https://www.acmicpc.net/problem/9012
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0){
            String input = br.readLine();
            sb.append(isRightBracket(input)).append("\n");
        }
        System.out.println(sb);
    }

    private static String isRightBracket(String input) {
        int size = input.length();
        int bracketCount = 0;

        for (int i = 0; i < size; i++) {
            if (input.charAt(i) == '(') {
                bracketCount++;
            } else {
                bracketCount--;
                if (bracketCount < 0) {
                    break;
                }
            }
        }
        // 입력 문자열 끝까지 순회 후 괄호 카운트가 0이 아니라면 짝이 맞는 않는 괄호
        return bracketCount == 0 ? "YES" : "NO";
    }
}
