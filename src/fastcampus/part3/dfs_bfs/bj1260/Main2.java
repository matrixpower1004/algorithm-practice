package fastcampus.part3.dfs_bfs.bj1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 1260 DFS와 BFS: https://www.acmicpc.net/problem/1260
 */
public class Main2 {

    static int N, M, V;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static Queue<Integer> q = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 노드의 수
        M = Integer.parseInt(st.nextToken()); // 간선의 수
        V = Integer.parseInt(st.nextToken()); // 시작 노드

        graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            graph[src].add(dst);
            graph[dst].add(src);
        }

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(graph[i]);
        }

        dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1]; // bfs 수행을 위한 visited 초기화
        bfs(V);
        System.out.println(sb);
    }

    private static void dfs(int node) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        sb.append(node).append(" ");

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int node) {
        q.offer(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" ");

            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}
