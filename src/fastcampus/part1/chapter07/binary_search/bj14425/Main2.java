package fastcampus.part1.chapter07.binary_search.bj14425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 14425 문자열 집합
 * https://www.acmicpc.net/problem/14425
 * 3. Arrays의 binarySearch() 메서드를 이용한 풀이
 */
public class Main2 {
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
        // binary search를 하기 전에 정렬을 먼저해야 하는 것을 잊지 말자.
        Arrays.sort(setS);

        int answer = 0;
        for (int i = 0; i < M; i++) {
            String q = br.readLine();
            if (Arrays.binarySearch(setS, q) >= 0)  {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
