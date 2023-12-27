package fastcampus.part1.chapter04_brute_force_simulation.bj2745;

import java.io.*;
import java.util.StringTokenizer;

/**
 * author         : Jisang Lee
 * date           : 2023-12-22
// * description    : 백준 2745 진법 변환
 * https://www.acmicpc.net/problem/2745
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] N = st.nextToken().toCharArray();
        int B = Integer.valueOf(st.nextToken());

        int sum = 0;
        for (int i = 0; i < N.length; i++) {
            int num = getNumeric(N[i]);
            int power = N.length - i - 1; // B의 승수를 구한다,
            sum += num * (int) Math.pow(B, power) ;
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }

    private static int getNumeric(char c) {
        if (c > '9') {
            return c - 55; // c - 'A' + 10
        }
        return Character.getNumericValue(c);
    }
}

