package fastcampus.part1.chapter07.binary_search.bj2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2470 두 용액
 * https://www.acmicpc.net/problem/2470
 */
public class Main3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        // 1. 첫 번째 용액에 대해 최적쌍이 되는 두 번째 용액을 찾는다.
        int previousDiff = Integer.MAX_VALUE;
        int pairLeft = -1;
        int pairRight = -1;
        int leftIndex = 0;
        int rightIndex = N - 1;
        while (leftIndex < rightIndex) {
            int sum = arr[leftIndex] + arr[rightIndex];
            int diff = Math.abs(sum);
            if (diff < previousDiff) {
                previousDiff = diff;
                pairLeft = arr[leftIndex];
                pairRight = arr[rightIndex];
            }
            if (sum > 0) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }

        // 2. 두 용액의 합이 0에 가장 가까운 쌍을 출력한다.
        System.out.println(pairLeft + " " + pairRight);
    }
}
