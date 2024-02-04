package fastcampus.part1.chapter07.binary_search.bj2295;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 백준 2295 세 수의 합: https://www.acmicpc.net/problem/2295
 * 2) set을 이용한 풀이
 */

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        // 식 변형: A+B+C=X -> A+B = X-C
        // 1. A + B의 집합을 만든다.
        Set<Integer> sums = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N ; j++) {
                sums.add(arr[i] + arr[j]);
            }
        }

        // 2. 모든 X - C에 대해서 A + B 집합에 존재하는지 확인한다.
        int ans = -1;
        for (int i = N - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                int target = arr[i] - arr[j];
                if (sums.contains(target)) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }
}
