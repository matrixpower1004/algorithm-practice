package fastcampus.part1.chapter03.arrays.bj15552;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * author         : Jisang Lee
 * date           : 2023-12-21
 * description    : 백준 15552 빠른 A+B
 * https://www.acmicpc.net/problem/15552
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.valueOf(st.nextToken());
            int B = Integer.valueOf(st.nextToken());
            sb.append(A + B).append("\n");
        }
        System.out.println(sb);
    }
}
