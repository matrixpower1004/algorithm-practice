package fastcampus.part2.chapter2.stack.bj5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 백준 5397 키로거: https://www.acmicpc.net/problem/5397
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String input = br.readLine();
            List<Character> dq = new LinkedList<>();
            ListIterator<Character> it = dq.listIterator();
            for (char cmd : input.toCharArray()) {
                switch (cmd) {
                    case '<': // 왼쪽으로 커서 이동
                        if (it.hasPrevious()) {
                            it.previous();
                        }
                        break;
                    case '>': // 오른쪽으로 커서 이동
                        if (it.hasNext()) {
                            it.next();
                        }
                        break;
                    case '-': // 커서 앞 문자 삭제
                        if (it.hasPrevious()) {
                            it.previous();
                            it.remove();
                        }
                        break;
                    default: // 커서 앞에 문자 추가
                        it.add(cmd);
                        break;
                }
            }

            for (char c : dq) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
