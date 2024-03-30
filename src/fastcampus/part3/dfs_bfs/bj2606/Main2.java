package fastcampus.part3.dfs_bfs.bj2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 2606 바이러스: https://www.acmicpc.net/problem/2606
 */
public class Main2 {

    static int N, M;
    static int[][] graph; // 인접 행렬로 구현
    static boolean[] visited;
    static int count = 0;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 정점의 수
        M = Integer.parseInt(br.readLine()); // 간선의 수
        graph = new int[N + 1][N + 1]; // 정점의 번호를 1번부터 사용
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            graph[src][dst] = 1;
            graph[dst][src] = 1;
        }
        bfs(1);
        System.out.println(count);
    }

    // Queue를 이용한 BFS 탐색
    static void bfs(int node) {
        q.offer(node);
        visited[node] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 1; i <= N; i++) {
                if (graph[now][i] == 1 && !visited[i]) {
                    q.offer(i);
                    count++;
                    visited[i] = true;
                }
            }
        }
    }
}
