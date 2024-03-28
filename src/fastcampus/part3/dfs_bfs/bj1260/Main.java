package fastcampus.part3.dfs_bfs.bj1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 1260 DFS와 BFS: https://www.acmicpc.net/problem/1260
 */
public class Main {

    static int N, M, V;
    static int[][] graph;
    static boolean[] visited;
    static Queue<Integer> q;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // 정점의 개수가 작으므로 인접 행렬 방식으로 구현.
        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            graph[src][dst] = 1;
            graph[dst][src] = 1; // 무방향 그래프르이므로 역방향 연결관계도 표현을 해준다.
        }
        dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1]; // bfs 수행을 위한 visited 초기화
        bfs(V);
        System.out.println(sb);
    }

    private static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(" ");
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[node][i] == 1) {
                dfs(i);
            }
        }
    }

    private static void bfs(int node) {
        q = new ArrayDeque<>();
        q.add(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" ");
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && graph[now][i] == 1) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
