package fastcampus.part1.chapter05_sort.bj1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * author         : Jisang Lee
 * date           : 2023-12-28
 * description    : 백준 1181 단어 정렬
 * https://www.acmicpc.net/problem/1181
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        // 1. 배열을 선언하고 문자열을 모두 입력 받는다.
        String[] result = new String[N];
        for (int i = 0; i < N; i++) {
            result[i] = br.readLine();
        }

        // 2. 정렬을 먼저 하면 중복을 체크하기 편해진다.
        Arrays.sort(result, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2); // 길이가 같으면 사전순
            }
            return o1.length() - o2.length(); // 길이순으로 정렬
        });

        // 3. 배열의 현재 단어와 뒷 단어가 같으면 중복으로 판정
        StringBuilder sb = new StringBuilder();
        sb.append(result[0]).append("\n");
        for (int i = 1; i < N; i++) {
            if (result[i].equals(result[i - 1])) continue;
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }
}
