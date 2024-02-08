package fastcampus.part1.chapter07.parametric_search.bj2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2805 나무 자르기
 * https://www.acmicpc.net/problem/2805
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        long sum = 0;
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }

        // 1. 절단기 높이의 탐색할 범위를 지정한다.
        int left = 0;
        int right = max;
        int ans = -1;
        while (left <= right) {
            // 2. 임의의 절단기 높이에 대해
            int midIndex = (left + right) / 2;
            if (isPossible(tree, midIndex, M)) {
                // 2-1. 원하는 만큼 나무를 가져갈 수 있다면 높이를 높여본다.
                ans = midIndex;
                left = midIndex + 1;
                // 2-2. 원하는 만큼 나무를 가져갈 수 없다면 높이를 낮춰준다.
            } else {
                right = midIndex - 1;
            }
        }
        // 3. 원하는 만큼 가져갈 수 있었던 높이 중 최대값을 출력한다.
        System.out.println(ans);
    }

    private static boolean isPossible(int[] tree, int cutHeight, int needHeight) {
        long sum = 0;
        int size = tree.length;
        for (int h : tree) {
            if (h > cutHeight) {
                sum += h - cutHeight;
            }
        }
        return sum >= needHeight;
    }
}
