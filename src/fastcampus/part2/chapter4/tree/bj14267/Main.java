package fastcampus.part2.chapter4.tree.bj14267;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 14267 회사 문화 1: https://www.acmicpc.net/problem/14267
 */
public class Main {
    static int[] praise; // 칭찬 기록 배열
    static int[] parents; // 상사의 정보를 기록
    static List<Integer>[] tree; // 부하의 정보를 기록

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 회사 직원의 수
        int M = Integer.parseInt(st.nextToken()); // 칭찬의 횟수
        parents = new int[N + 1];
        praise = new int[N + 1];
        tree = new ArrayList[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) { // 상사 정보 입력받기
            tree[i] = new ArrayList<>();
            parents[i] = Integer.parseInt(st.nextToken());
            if (parents[i] == -1) {
                continue;
            }
            tree[parents[i]].add(i);
        }
        for (int i = 0; i < M; i++) { // 칭찬 받은 직원과 칭찬의 정도 입력받기
            st = new StringTokenizer(br.readLine());
            int employee = Integer.parseInt(st.nextToken());
            int point = Integer.parseInt(st.nextToken());
            praise[employee] += point;
        }

        next(1); // 사장님 노드부터 탐색 시작

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(praise[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static void next(int node) {
        for (int child : tree[node]) {
            praise[child] += praise[node]; // 내 직속 상사가 받은 칭찬을 계속 누적
            next(child); // 칭찬을 부하에게 뿌려준다.
        }
    }
}
