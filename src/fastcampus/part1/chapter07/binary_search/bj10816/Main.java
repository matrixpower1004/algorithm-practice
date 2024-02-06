package fastcampus.part1.chapter07.binary_search.bj10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 백준 10816 숫자 카드 2
 * https://www.acmicpc.net/problem/10816
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> card = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            card.put(number, card.getOrDefault(number, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int query = Integer.parseInt(st.nextToken());
            int answer = card.getOrDefault(query, 0);
            sb.append(answer).append(" ");
        }
        sb.append("\n");
        System.out.println(sb);
    }
}
