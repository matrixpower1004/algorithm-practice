package fastcampus.part1.chapter08.two_pointer.bj16472;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 16472 고냥이: https://www.acmicpc.net/problem/16472
 */
public class Main {

    static int[] frequency = new int[26];
    static int alphabetCount = 0;

    private static void increaseFrequency(char alp) {
        if (frequency[alp - 'a']++ == 0) {
            alphabetCount++;
        }
    }

    private static void decreaseFrequency(char alp) {
        if (--frequency[alp - 'a'] == 0) {
            alphabetCount--;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] string = br.readLine().toCharArray();
        int L = string.length;

        // 부분문자열의 시작점 각 i에 대해
        // 알파벳 종류가 N개 이하인 가장 긴 j를 찾는다.
        int nextIndex = 0; // 아직 부분 문자열에 포함되지 않은 index
        int ans = 0;
        for (int i = 0; i < L; i++) {
            while (nextIndex < L) {
                increaseFrequency(string[nextIndex++]);
                if (alphabetCount > N) {
                    decreaseFrequency(string[--nextIndex]);
                    break;
                }
            }
            ans = Math.max(ans, nextIndex - i);
            // 다음 알파벳을 보기 위해서 i번째 문자의 개수를 -1 해준다.
            decreaseFrequency(string[i]);
        }
        System.out.println(ans);
    }
}
