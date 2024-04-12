package fastcampus.part2.chapter5.recursion.bj10971;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 10971 외판원 순회 2: https://www.acmicpc.net/problem/10971
 */
public class Main {

    static int N;
    static int[][] W;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        travel(0, 0, 0, 0);
        System.out.println(answer);
    }

    private static void travel(int start, int node, int sum, int cnt) {
        // base case
        if (cnt == N && start == node) {
            answer = Math.min(answer, sum);
            return;
        }

        // recursive case
        for (int i = 0; i < N; i++) {
            if (!visited[i] && W[node][i] != 0) {
                visited[i] = true;
                travel(start, i, sum + W[node][i], cnt + 1);
                visited[i] = false; // 다음 방문을 위한 초기화
            }
        }
    }
}
