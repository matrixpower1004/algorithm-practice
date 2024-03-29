package fastcampus.part3.dfs_bfs.bj11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 백준 11724 연결 요소의 개수: https://www.acmicpc.net/problem/11724
 */
public class Main2 {

    static int N, M;
    static int[][] graph;
    static boolean[] visited;
    static int count = 0;
    static Deque<Integer> stack = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1]; // 정점의 번호를 1번부터 사용
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            graph[src][dst] = 1;
            graph[dst][src] = 1;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
    }

    // stack을 이용한 dfs
    static void dfs(int node) {
        stack.offerLast(node);
        visited[node] = true;
        while (!stack.isEmpty()) {
            int now = stack.pollLast();
            for (int i = 1; i <= N; i++) {
                if (graph[now][i] == 1 && !visited[i]) {
                    stack.offerLast(i);
                    visited[i] = true;
                }
            }
        }
    }
}
