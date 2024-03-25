package fastcampus.part2.chapter2.stack.bj2841;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 백준 2841 외계인의 기타 연주: https://www.acmicpc.net/problem/2841
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 음의 수
        int P = Integer.parseInt(st.nextToken()); // 프렛의 수

        Deque<Integer>[] pushed = new ArrayDeque[7];
        for (int i = 1; i <= 6; i++) {
            pushed[i] = new ArrayDeque<>();
        }

        int moveCount = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int fret = Integer.parseInt(st.nextToken());
            while (!pushed[num].isEmpty()) {
                if (pushed[num].peekLast() > fret) {
                    moveCount++;
                    pushed[num].pollLast();
                } else {
                    break;
                }
            }
            if (!pushed[num].isEmpty() && pushed[num].peekLast() == fret) {
                continue;
            }
            pushed[num].offerLast(fret);
            moveCount++;
        }
        System.out.println(moveCount);
    }
}
