package fastcampus.etc.bj3058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * author         : Jisang Lee
 * date           : 2023-12-15
 * description    : 백준 3058 짝수를 찾아라
 * https://www.acmicpc.net/problem/3058
 */
public class Main {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 테스트 케이스 수 T
        int T = Integer.valueOf(br.readLine());

        StringBuilder sb = new StringBuilder();
        // 2. 각 테스트 케이스마다 주어지는 자연수는 7개
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int min = Integer.MAX_VALUE;
            int sum = 0;
            for (int j = 0; j < 7; j++) {
                int num = Integer.valueOf(st.nextToken());
                if (num % 2 == 0) {
                    sum += num;
                    min = Math.min(min, num);
                }
            }
            sb.append(sum).append(" ").append(min).append("\n");

        }
        System.out.println(sb);
    }
}
