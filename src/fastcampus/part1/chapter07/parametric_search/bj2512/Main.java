package fastcampus.part1.chapter07.parametric_search.bj2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2512 예산: https://www.acmicpc.net/problem/2512
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] budgets = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxBudget = -1;
        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
            maxBudget = Math.max(maxBudget, budgets[i]);
        }
        int M = Integer.parseInt(br.readLine());

        int left = 1;
        int right = maxBudget;
        int ans = -1;
        int calcSum = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            calcSum = calcSum(budgets, mid);
            if (calcSum == M) {
                // 1. 배정 예산으로 계산한 합이 총 예산과 같다면 더 볼 필요가 없다.
                ans = mid;
                break;
            } else if (calcSum > M) {
                // 2. 배정한 예산으로 계산한 합이 총 예산보다 크다면 배정 에산을 더 줄인다.
                right = mid - 1;
            } else {
                // 3. 아니라면 배정 예산을 더 늘려본다.
                ans = mid;
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    private static int calcSum(int[] budgets, int allocation) {
        int sum = 0;
        for (int b : budgets) {
            sum += Math.min(b, allocation);
        }
        return sum;
    }
}
