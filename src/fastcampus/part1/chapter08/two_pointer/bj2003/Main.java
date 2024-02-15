package fastcampus.part1.chapter08.two_pointer.bj2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2003 수들의 합 2: https://www.acmicpc.net/problem/2003
 */
public class Main {

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

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                // i번째 위치부터 합계가 M과 같거나 클때까지 계속 더해본다.
                sum += arr[j];
                if (sum == M) {
                    ans++; // 합계가 M과 같다면 답 카운트를 1증가 시키고 이후는 볼 필요가 없다.
                    break;
                } else if (sum > M) { // 합계가 M보다 크다면 더 볼 필요가 없다.
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
