package fastcampus.part2.chapter1.queue.bj1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * 백준 1158 요세푸스 문제: https://www.acmicpc.net/problem/1158
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < K;j++) {
                deque.add(deque.poll());
            }
            ans[i] = deque.poll();
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(Arrays.stream(ans)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(", ")));
        sb.append(">\n");
        System.out.println(sb);
    }
}
