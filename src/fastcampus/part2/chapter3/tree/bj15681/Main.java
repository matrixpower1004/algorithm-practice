package fastcampus.part2.chapter3.tree.bj15681;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 15681 트리와 쿼리: https://www.acmicpc.net/problem/15681
 */
public class Main {

    static List<Integer>[] tree;
    static boolean[] check;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 트리의 정점의 수
        int R = Integer.parseInt(st.nextToken()); // 루트의 번호
        int Q = Integer.parseInt(st.nextToken()); // 쿼리의 수
        check = new boolean[N + 1]; // 노드 번호를 1부터 사용하므로 N + 1을 해준다.
        sum = new int[N + 1];
        tree = new ArrayList[N + 1];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        // 트리 정보를 입력 받는다.
        for (int i = 0; i < N - 1; i++) { // 트리에서 간선의 수는 정점의 수 -1
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            tree[U].add(V);
            tree[V].add(U);
        }

        sum[R] = getSum(R); // 루트 노드에 대해서 전체 자식의 수를 구하고 저장한다.

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int query = Integer.parseInt(br.readLine());
            sb.append(sum[query]).append("\n");
        }
        System.out.println(sb);
    }

    // 한번 구했던 답은 다시 계산하지 않도록 저장
    private static int getSum(int node) {
        if (sum[node] != 0) {
            return sum[node];
        }
        check[node] = true;
        int result = 1; // 자기 자신이 포함되므로 1로 초기화
        for (int child : tree[node]) {
            if (!check[child]) { // 처음 만나는 노드 체크
                result += getSum(child);
            }
        }
        return sum[node] = result;
    }
}
