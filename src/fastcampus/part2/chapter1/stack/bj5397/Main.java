package fastcampus.part2.chapter1.stack.bj5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 백준 5397 키로거: https://www.acmicpc.net/problem/5397
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String input = br.readLine();
            Deque<Character> beforeCursor = new ArrayDeque<>();
            Deque<Character> afterCursor = new ArrayDeque<>();
            for (char cmd : input.toCharArray()) {
                switch (cmd) {
                    case '<': // 왼쪽으로 커서 이동
                        if (!beforeCursor.isEmpty()) {
                            afterCursor.offerLast(beforeCursor.pollLast());
                        }
                        break;
                    case '>': // 오른쪽으로 커서 이동
                        if (!afterCursor.isEmpty()) {
                            beforeCursor.offerLast(afterCursor.pollLast());
                        }
                        break;
                    case '-': // 커서 앞 문자 삭제
                        beforeCursor.pollLast();
                        break;
                    default: // 커서 앞에 문자 추가
                        beforeCursor.offerLast(cmd);
                        break;
                }
            }
            int beforeSize = beforeCursor.size();
            int afterSize = afterCursor.size();
            for (int i = 0; i < beforeSize; i++) {
                sb.append(beforeCursor.pollFirst());
            }
            for (int i = 0; i < afterSize; i++) {
                sb.append(afterCursor.pollLast());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
