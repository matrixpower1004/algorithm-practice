package fastcampus.part2.chapter1.stack.bj10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 백준 10828 스택: https://www.acmicpc.net/problem/10828
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "push":
                    dq.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    ans.append(dq.isEmpty() ? -1 : dq.pollFirst()).append("\n");
                    break;
                case "size":
                    ans.append(dq.size()).append("\n");
                    break;
                case "empty":
                    ans.append(dq.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "top":
                    ans.append(dq.isEmpty() ? -1 : dq.peekFirst()).append("\n");
                    break;
            }
        }
        System.out.println(ans);
    }
}
