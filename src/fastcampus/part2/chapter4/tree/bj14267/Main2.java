package fastcampus.part2.chapter4.tree.bj14267;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 14267 회사 문화 1: https://www.acmicpc.net/problem/14267
 */
public class Main2 {
    static int[] praise; // 칭찬 기록 배열
    static ArrayList<Integer>[] tree; // 직속 상사의 정보를 기록

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 회사 직원의 수
        int M = Integer.parseInt(st.nextToken()); // 칭찬의 횟수
        praise = new int[N + 1];
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken(); // -1 입력은 패스
        for (int i = 2; i <= N; i++) { // 상사 정보 입력 받기
            int parent = Integer.parseInt(st.nextToken());
            tree[parent].add(i);
        }

        for (int i = 0; i < M; i++) { // 칭찬 받은 직원과 칭찬의 정도 입력받기
            st = new StringTokenizer(br.readLine());
            int employee = Integer.parseInt(st.nextToken());
            int point = Integer.parseInt(st.nextToken());
            praise[employee] += point;
        }

        dfs(1); // 사장님 노드부터 탐색 시작

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(praise[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static void dfs(int node) {
        for (int child : tree[node]) {
            praise[child] += praise[node]; // 직속 상사로 부터 받은 칭찬을 계속 누적
            dfs(child); // 내가 받은 칭찬을 부하에게 뿌려준다.
        }
    }
}
