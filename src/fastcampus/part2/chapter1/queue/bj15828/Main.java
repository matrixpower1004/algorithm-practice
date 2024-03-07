package fastcampus.part2.chapter1.queue.bj15828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 백준 15828 Router: https://www.acmicpc.net/problem/15828
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> router = new ArrayDeque<>(N);

        while (true) {
            int cmd = Integer.parseInt(br.readLine());
            if (router.size() < N && cmd > 0) {
                router.offer(cmd);
            } else if (cmd == 0) {
                router.poll();
            } else if (cmd == -1) {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (router.isEmpty()) {
            sb.append("empty");
        } else {
            for (Integer i : router) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
}

