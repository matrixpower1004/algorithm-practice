package fastcampus.part1.chapter4_brute_force_simulation.bj1120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * author         : Jisang Lee
 * date           : 2023-12-27
 * description    : 백준 1120 문자열
 * https://www.acmicpc.net/problem/1120
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();
        int diffLength = B.length() - A.length();

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= diffLength; i++) {
            int count = checkDifferent(i, A, B);
            answer = (int) Math.min(answer, count);
        }
        System.out.println(answer);
    }

    private static int checkDifferent(int startIndex, String a, String b) {
        int count = 0;
        for (int j = 0; j < a.length(); j++) {
            int currentIndex = startIndex + j;
            if (a.charAt(j) != b.charAt(currentIndex)) {
                count++;
            }
        }
        return count;
    }

}
