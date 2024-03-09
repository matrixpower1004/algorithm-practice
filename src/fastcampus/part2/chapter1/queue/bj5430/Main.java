package fastcampus.part2.chapter1.queue.bj5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 백준 2430 AC: https://www.acmicpc.net/problem/5430
 */
public class Main {

    static boolean isFlipped;
    static boolean isError;
    static char[] p;
    static Deque<String> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();

        while (T-- > 0) {
            p = br.readLine().toCharArray();
            int N = Integer.parseInt(br.readLine());
            deque = new ArrayDeque<>(N);
            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
            for (int i = 0; i < N; i++) {
                deque.offer(st.nextToken());
            }

            // 함수에 따라 동작을 실행
            isFlipped = false;
            isError = false;
            command();

            // 함수 수행 결과를 출력한다.
            if (isError) {
                ans.append("error").append("\n");
            } else {
                ans.append("[");
                if (!deque.isEmpty()) {
                    ans.append(makeFormatted());
                }
                ans.append("]").append("\n");
            }
        }
        System.out.println(ans);
    }

    private static void command() {
        for (char cmd : p) {
            if (cmd == 'D') {
                if (deque.isEmpty()) {
                    isError = true;
                    return;
                }
                if (isFlipped) {
                    deque.pollLast();
                } else {
                    deque.pollFirst();
                }
            } else {
                isFlipped = !isFlipped;
            }
        }
    }

    private static String makeFormatted() {
        StringBuilder sb = new StringBuilder();
        if (isFlipped) {
            while (!deque.isEmpty()) {
                sb.append(deque.pollLast()).append(",");
            }
        } else {
            while (!deque.isEmpty()) {
                sb.append(deque.pollFirst()).append(",");
            }
        }
        sb.deleteCharAt(sb.length() - 1); // 마지막 , 문자 지우기
        return sb.toString();
    }
}
