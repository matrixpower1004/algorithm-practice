package fastcampus.part1.chapter04_brute_force_simulation.bj10250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * author         : Jisang Lee
 * date           : 2023-12-17
 * description    : 백준 10250 ACM 호텔
 * https://www.acmicpc.net/problem/10250
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.valueOf(st.nextToken());
            int W = Integer.valueOf(st.nextToken());
            int N = Integer.valueOf(st.nextToken());

            int floor = (N - 1) % H + 1;  // [1, H]
            int distance = (N - 1) / H + 1; // [1, W]
            int room = floor * 100 + distance;
            sb.append(room).append("\n");
        }
        System.out.println(sb);
    }
}
