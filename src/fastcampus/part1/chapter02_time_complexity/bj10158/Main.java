package fastcampus.part1.chapter02_time_complexity.bj10158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * author         : Jisang Lee
 * date           : 2023-10-21
 * description    : 백준 10158 개미
 * https://www.acmicpc.net/problem/10158
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.valueOf(st.nextToken());
        int h = Integer.valueOf(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x = Integer.valueOf(st.nextToken());
        int y = Integer.valueOf(st.nextToken());
        int t = Integer.valueOf(br.readLine());

        int ansX = (t + x) % (2 * w);
        int ansY = (t + y) % (2 * h);
        if (ansX > w) {
            ansX = (2 * w) - ansX;
        }
        if (ansY > h) {
            ansY = (2 * h) - ansY;
        }
        StringBuilder answer = new StringBuilder();
        answer.append(ansX).append(" ").append(ansY);
        System.out.println(answer);
    }

}
