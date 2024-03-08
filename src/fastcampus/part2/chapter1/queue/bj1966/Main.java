package fastcampus.part2.chapter1.queue.bj1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 백준 1966 프린터 큐: https://www.acmicpc.net/problem/1966
 */
public class Main {
    static class Job {
        int index;
        int priority;

        public Job(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

        StringBuilder sb = new StringBuilder();
        while (T-- > 0){
            Deque<Job> prtQ = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서의 수
            int M = Integer.parseInt(st.nextToken()); // 몇 번째로 인쇄되었는지 궁금한 문서의 위치

            // primitive type의 sort는 reverseOrder()가 제공되지 않아서 Wrapper Type으로 배열을 생성.
            Integer[] prioritySequence = new Integer[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                prioritySequence[i] = Integer.parseInt(st.nextToken());
                prtQ.offer(new Job(i, prioritySequence[i]));
            }

            Arrays.sort(prioritySequence, Collections.reverseOrder());
            int ans = calcSequence(N, prtQ, prioritySequence, M);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
        int[] temp = new int[10];
        Arrays.sort(temp);
    }

    private static int calcSequence(
        int N, Deque<Job> prtQ, Integer[] prioritySequence, int M
    ) {
        int ans = 0;
        for (int i = 0; i < N; i++) {
            while (prtQ.peek().priority != prioritySequence[i]) {
                prtQ.offer(prtQ.poll());
            }
            if (prtQ.peek().index == M) {
                ans = i + 1;
                break;
            }
            prtQ.poll();
        }
        return ans;
    }
}


