package fastcampus.part1.chapter04_brute_force_simulation.bj4673;

import java.util.Arrays;

/**
 * author         : Jisang Lee
 * date           : 2023-12-25
 * description    : 백준 4673 셀프 넘버
 * https://www.acmicpc.net/problem/4673
 */
public class Main {

    private static final int MAX = 10000;

    public static void main(String[] args) {

        boolean[] isSelfNumber = new boolean[MAX + 1]; // 숫자 1만까지의 인데스
        Arrays.fill(isSelfNumber, true);

        for (int i = 1; i <= MAX ; i++) {
            int seed = sumOfEachDigit(i);
            if (seed > MAX) continue;
            isSelfNumber[seed] = false;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= MAX ; i++) {
            if (isSelfNumber[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);

    }

    private static int sumOfEachDigit(int seed) {
        int sum = seed;
        while (seed > 0) {
            sum += seed % 10;
            seed /= 10;
        }
        return sum;
    }
}
