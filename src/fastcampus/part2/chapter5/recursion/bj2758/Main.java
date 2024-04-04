package fastcampus.part2.chapter5.recursion.bj2758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2758 로또: https://www.acmicpc.net/problem/2758
 */
public class Main {

    static long[][] mem;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            mem = new long[n + 1][m + 1];

            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    mem[i][j] = -1;
                }
            }
            sb.append(solve(n, m)).append("\n");
        }
        System.out.println(sb);
    }

    private static long solve(int i, int last) {
        // base case
        if (last <= 0) {
            return 0; // 재귀함수 종료
        }
        // i== 1. 수가 하나밖에 없는데 마지막 값이 1보다 작은 수열
        // 2보다 작은 수열: {1}, {2}
        // 3보다 작은 수열: {1}, {2, {3}
        // last 보다 작은 수열: {1}, ... {last}
        if (i == 1) {
            return last;
        }

        // recursive case
        if (mem[i][last] == -1) {
            mem[i][last] = solve(i - 1, last / 2) + solve(i, last - 1);
        }
        return mem[i][last];
    }
}
