package fastcampus.part1.chapter07.binary_search.bj2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2470 두 용액
 * https://www.acmicpc.net/problem/2470
 * 1. Binary search를 이용한 풀이
 */

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        // 1. 첫 번째 용액에 대해 최적쌍이 되는 두 번째 용액을 찾는다.
        int previousDiff = Integer.MAX_VALUE;
        int pairLeft = -1;
        int pairRight = -1;
        for (int i = 0; i < N - 1 ; i++) {
            int pairValue = findNearestValue(i + 1, N - 1, arr[i]);
            int diff = Math.abs(arr[i] + pairValue);
            if (previousDiff > diff) {
                previousDiff = diff;
                pairLeft = arr[i];
                pairRight = pairValue;
            }
        }

        // 2. 두 용액의 합이 0에 가장 가까운 쌍을 출력한다.
        System.out.println(pairLeft + " " + pairRight);
    }

    private static int findNearestValue(int leftIndex, int rightIndex, int findValue) {
        int previousDiff = Integer.MAX_VALUE;
        int pairValue = 0;
        int left = leftIndex;
        int right = rightIndex;
        while (left <= right) {
            int m = (left + right) / 2;
            int sum = findValue + arr[m];
            int diff = Math.abs(sum);
            if (diff < previousDiff) {
                pairValue = arr[m];
                previousDiff = diff;
            }
            if (sum < 0) {
                left = m + 1;
            } else if (sum > 0) {
                right = m - 1;
            } else {
                return arr[m];
            }
        }
        return pairValue;
    }
}
