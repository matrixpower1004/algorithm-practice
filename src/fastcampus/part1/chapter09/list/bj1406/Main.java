package fastcampus.part1.chapter09.list.bj1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 백준 1406 에디터: https://www.acmicpc.net/problem/1406
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String origin = br.readLine();
        List<Character> input = new LinkedList<>();
        for (char alp : origin.toCharArray()) {
            input.add(alp);
        }

        int M = Integer.parseInt(br.readLine());
        ListIterator<Character> cursor = input.listIterator(origin.length());
        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            char cmd = command.charAt(0);
            if (cmd == 'P') {
                // 입력 받은 문자를 커서 왼쪽에 추가한다.
                char word = command.charAt(2);
                cursor.add(word);
            } else if (cmd == 'L') {
                // L: 커서를 왼쪽으로 옮긴다. 맨 앞이면 무시된다.
                if (cursor.hasPrevious()) {
                    cursor.previous();
                }
            } else if (cmd == 'D') {
                // D: 커서를 오른쪽으로 옮긴다. 맨 뒤면 무시된다.
                if (cursor.hasNext()) {
                    cursor.next();
                }
            } else if (cmd == 'B') {
                // B: 커서 왼쪽의 문자를 삭제한다. 맨 앞이면 무시된다.
                if (cursor.hasPrevious()) {
                    cursor.previous();
                    cursor.remove();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (var alp: input) {
            sb.append(alp);
        }
        sb.append("\n");
        System.out.println(sb);
    }
}
