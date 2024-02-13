package fastcampus.part1.chapter07.parametric_search.bj2792;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2792 보석 상자: https://www.acmicpc.net/problem/2792
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 학생의 수
        int M = Integer.parseInt(st.nextToken()); // 보석의 색상 수
        int[] colors = new int[M];
        int max = -1;
        for (int i = 0; i < M; i++) {
            colors[i] = Integer.parseInt(br.readLine());
            max = Math.max(colors[i], max);
        }

        int left = 1;
        int right = max;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            // 보석을 나누어 줄 수 있다면 분배 개수를 줄여본다.
            if (isPossibleDivide(colors, mid, N)) {
                ans = mid;
                right = mid - 1;
            } else {
                // 보석을 나누어 줄 수 없다면 분배 개수를 늘려본다.
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean isPossibleDivide(int[] colors, int divideCount, int studentCount) {
        int receivedCount = 0;
        for (int color : colors) {
            // 나누어 떨어지지 않는 경우 +1을 해주기 위한 로직
            // ex) 보석 개수가 4개이고 분배 개수가 4라면 (4 + 3) / 4 = 1 이 나오고,
            // 보석 개수가 7이고 분배 개수가 4라면(7 + 3) / 4 = 2가 나오게 된다.
            // 이 계산으로 나누어 떨어지는 경우와 나누어 떨어지지 않는 경우를 모두 커버할 수 있다.
            receivedCount += (color + divideCount - 1) / divideCount;
        }
        return receivedCount <= studentCount;
    }
}
