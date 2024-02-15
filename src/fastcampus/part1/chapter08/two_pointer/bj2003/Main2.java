package fastcampus.part1.chapter08.two_pointer.bj2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2003 수들의 합 2: https://www.acmicpc.net/problem/2003
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int nextIndex = 0;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            while (sum < M && nextIndex < N) {
                sum += arr[nextIndex++];
            }
            if (sum == M) {
                count++;
            }
            sum -= arr[i];
        }
        System.out.println(count);
    }
}
