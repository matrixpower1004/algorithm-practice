package fastcampus.part1.chapter07.binary_search.bj10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 10816 숫자 카드 2
 * https://www.acmicpc.net/problem/10816
 * binary search를 이용한 풀이
 */
public class Main3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int query = Integer.parseInt(st.nextToken());
            // 1. X 이상의 값이 처음으로 나타나는 위치를 구한다.
            int lowerBoundIndex = findLowerIndex(cards, query);
            // 2. X 초과의 값이 처음으로 나타난 위치를 구한다.
            int upperBoundIndex = findUpperIndex(cards, query);
            // 3. 두 값을 이용해 X의 개수를 센다.
            sb.append(upperBoundIndex - lowerBoundIndex).append(" ");
        }
        sb.append("\n");
        System.out.println(sb);
    }

    private static int findUpperIndex(int[] cards, int query) {
        int upperBoundIndex = cards.length;
        int left = 0;
        int right = cards.length - 1;
        while (left <= right) {
            int m = (left + right) / 2;
            if (cards[m] <= query) {
                left = m + 1;
            } else {
                right = m - 1;
                upperBoundIndex = m;
            }
        }
        return upperBoundIndex;
    }

    private static int findLowerIndex(int[] cards, int query) {
        int lowerBoundIndex = cards.length;
        int left = 0;
        int right = cards.length - 1;
        while (left <= right) {
            int m = (left + right) / 2;
            if (cards[m] < query) {
                left = m + 1;
            } else {
                right = m - 1;
                lowerBoundIndex = m;
            }
        }
        return lowerBoundIndex;
    }
}
