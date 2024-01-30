package fastcampus.part1.chapter06.prefixsum.bj16713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 16713 Generic Queries
 * https://www.acmicpc.net/problem/16713
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int Q = Integer.valueOf(st.nextToken());
        int[] arr = new int[N + 1]; // 입력되는 값을 담을 배열
        int[] acc = new int[N + 1]; // 입력된 값의 누적합을 담을 배열

        // for - loop 돌 때마다 I/O 입력이 일어나면 그 만큼 시간이 늦어진다.
        // 미리 배열에 저장해 두고 연산해 보자.
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        // 누적합 배열에 입력되는 수의 xor 연산값을 저장한다.
        for (int i = 1; i <= N; i++) {
            acc[i] ^= acc[i - 1] ^ arr[i];
        }

        int ans = 0;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.valueOf(st.nextToken());
            int e = Integer.valueOf(st.nextToken());
            ans ^= acc[e] ^ acc[s - 1];
        }
        System.out.println(ans);
    }
}
