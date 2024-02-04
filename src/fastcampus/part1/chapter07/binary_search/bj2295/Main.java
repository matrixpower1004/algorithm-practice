package fastcampus.part1.chapter07.binary_search.bj2295;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 2295 세 수의 합: https://www.acmicpc.net/problem/2295
 * 1) binary search를 이용한 풀이
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 식 변형: A+B+C=X -> A+B = X-C
        // 1. A + B의 집합을 만든다.
        int[] sums = new int[N * (N + 1) / 2];
        int sumIndex = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N ; j++) {
                sums[sumIndex++] = arr[i] + arr[j];
            }
        }
        Arrays.sort(sums);

        // 2. 모든 X - C에 대해서 A + B 집합에 존재하는지 확인한다.
        int ans = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int target = arr[i] - arr[j];
                if (isExist(sums, target)) {
                    ans = Math.max(ans, arr[i]);
                }
            }
        }

        // 3. A + B = X - C를 만족하는 X중 최대값을 출력한다.
        System.out.println(ans);
    }

    private static boolean isExist(int[] sums, int target) {
        int left = 0;
        int right = sums.length - 1;
        while (left <= right) {
            int m = (left + right) / 2;
            if (sums[m] < target) {
                left = m + 1;
            } else if (sums[m] > target) {
                right = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
