package fastcampus.part1.chapter07.binary_search.bj2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * 백준 2470 두 용액
 * https://www.acmicpc.net/problem/2470
 * 1. TreeSet을 이용한 풀이
 */

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int previousDiff = Integer.MAX_VALUE;
        int pairLeft = -1;
        int pairRight = -1;
        TreeSet<Integer> input = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            Integer[] pairValues = {input.floor(-x), input.ceiling(-x)};
            for (Integer pairValue : pairValues) {
                if (pairValue == null) continue;
                int currentDiff = Math.abs(x + pairValue);
                if (previousDiff > currentDiff) {
                    previousDiff = currentDiff;
                    pairLeft = x;
                    pairRight = pairValue;
                }
            }
            input.add(x);
        }
        System.out.println(Math.min(pairLeft, pairRight) + " " + Math.max(pairLeft, pairRight));
    }
}
