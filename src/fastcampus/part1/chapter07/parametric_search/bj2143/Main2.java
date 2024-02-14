package fastcampus.part1.chapter07.parametric_search.bj2143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2143 두 배열의 합: https://www.acmicpc.net/problem/2143
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        int[] partSumA = getAllPartSum(A);
        int[] partSumB = getAllPartSum(B);

        Arrays.sort(partSumB);

        long ans = 0;
        for (int sumA : partSumA) {
            int pairSum = T - sumA;
            int lowerBoundIndex = findLowerBoundIndex(partSumB, pairSum);
            int upperBoundIndex = findUpperBoundIndex(partSumB, pairSum);
            ans += upperBoundIndex - lowerBoundIndex;
        }
        System.out.println(ans);
    }

    private static int findLowerBoundIndex(int[] arr, int x) {
        // x 이상의 값 이 처음으로 나타나는 위치
        int lowerBoundIndex = arr.length;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
                lowerBoundIndex = mid;
            }
        }
        return lowerBoundIndex;
    }

    private static int findUpperBoundIndex(int[] arr, int x) {
        // x 초과의 값이 처음으로 나타나는 위치
        int upperBoundIndex = arr.length;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= x) {
                left = mid + 1;
            } else {
                right = mid - 1;
                upperBoundIndex = mid;
            }
        }
        return upperBoundIndex;
    }

    private static int[] getAllPartSum(int[] arr) {
        int n = arr.length;
        int[] partSum = new int[n * (n + 1) / 2];
        int partSumIndex = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                partSum[partSumIndex++] = sum;
            }
        }
        return partSum;
    }
}
