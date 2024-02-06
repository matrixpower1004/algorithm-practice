package fastcampus.part1.chapter07.binary_search.bj10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 10816 숫자 카드 2
 * https://www.acmicpc.net/problem/10816
 */
public class Main2 {

    private static final int SIZE = 10000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] positive = new int[SIZE];
        int[] negative = new int[SIZE];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (input >= 0) {
                positive[input]++;
            } else {
                negative[-input]++;
            }
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int query = Integer.parseInt(st.nextToken());
            if (query >= 0) {
                sb.append(positive[query]).append(" ");
            } else {
                sb.append(negative[-query]).append(" ");
            }
        }
        sb.append("\n");
        System.out.println(sb);
    }
}
