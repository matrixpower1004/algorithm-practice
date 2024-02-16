package fastcampus.part1.chapter08.two_pointer.bj1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1806 부분합: https://www.acmicpc.net/problem/1806
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 누적합과 Binary search 를 이용한 풀이
        long[] acc = new long[N + 1];
        for (int i = 1; i <= N ; i++) {
            acc[i] = acc[i - 1] + arr[i];
        }

        int ansLength = N + 1;
        for (int i = 1; i <= N; i++) {
            int left = i;
            int right = N;
            while (left <= right) {
                int mid = (left + right) / 2;
                long sum = acc[mid] - acc[i - 1];
                if (sum >= S) {
                    ansLength = Math.min(ansLength, mid - i + 1);
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        if (ansLength > N) {
            ansLength = 0;
        }
        System.out.println(ansLength);
    }
}
