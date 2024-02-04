package fastcampus.part1.chapter07.binary_search.bj14425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 14425 문자열 집합
 * https://www.acmicpc.net/problem/14425
 * 1. Binary search를 이용한 풀이
 */
public class Main {
    static String[] setS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        setS = new String[N];
        for (int i = 0; i < N; i++) {
            setS[i] = br.readLine();
        }
        Arrays.sort(setS);

        // setS에서 검사해야 하는 문자열이 있는지 찾는다.
        int answer = 0;
        for (int i = 0; i < M; i++) {
            String q = br.readLine();
            if (isExistStr(q)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean isExistStr(String q) {
        int left = 0;
        int right = setS.length - 1;
        while (left <= right) {
            int m = (left + right) / 2;
            int compareResult = setS[m].compareTo(q);
            if (compareResult < 0) {
                left = m + 1;
            } else if (compareResult > 0) {
                right = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
