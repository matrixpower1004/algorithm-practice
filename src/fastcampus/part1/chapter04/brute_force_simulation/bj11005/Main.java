package fastcampus.part1.chapter04.brute_force_simulation.bj11005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * author         : Jisang Lee
 * date           : 2023-12-13
 * description    : 백준 11005 진법 변환 2
 * https://www.acmicpc.net/problem/11005
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        int B = Integer.valueOf(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while (N > 0) {
            int remainder = N % B;
            sb.append(numToChar(remainder));
            N /= B;
        }
        System.out.println(sb.reverse().toString());
    }

    private static char numToChar(int digit) {
        return (char) ((digit < 10 ) ? '0' + digit : 'A' - 10 + digit);
    }
}
