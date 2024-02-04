package fastcampus.part1.chapter07.binary_search.bj14425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 백준 14425 문자열 집합
 * https://www.acmicpc.net/problem/14425
 * 2. Set을 이용한 풀이
 */
public class SetMain {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set setS = new HashSet();
        for (int i = 0; i < N; i++) {
            setS.add(br.readLine());
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            String q = br.readLine();
            if (setS.contains(q)) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
