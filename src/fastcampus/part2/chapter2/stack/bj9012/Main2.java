package fastcampus.part2.chapter2.stack.bj9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 *  백준 9012 괄호: https://www.acmicpc.net/problem/9012
 */

public class Main2 {
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
        boolean fairBracket = true;
        Deque<String> dq = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            if (input.charAt(i) == '(') {
                dq.offerFirst("(");
            } else {
                if (dq.isEmpty()) {
                    fairBracket = false;
                    break;
                }
                dq.pollFirst();
            }
        }
        // 입력 문자열 끝까지 순회 후 스택이 비어 있지 않거나 괄호의 짝이 맞지 않으면 NO 반환
        if (!dq.isEmpty() || !fairBracket) {
            return "NO";
        }
        return "YES";
    }
}
