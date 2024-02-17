package fastcampus.part1.chapter08.two_pointer.bj2230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2230 수 고르기: https://www.acmicpc.net/problem/2230
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        // binary search를 이용한 탐색
        int ansDiff = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int left = i;
            int right = N - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                int diff = arr[mid] - arr[i];
                if (diff >= M) {
                    right = mid - 1;
                    ansDiff = Math.min(ansDiff, diff);
                } else {
                    left = mid + 1;
                }
            }
        }
        System.out.println(ansDiff);
    }
}
