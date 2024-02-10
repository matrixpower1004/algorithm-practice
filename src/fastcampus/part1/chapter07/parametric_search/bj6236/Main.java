package fastcampus.part1.chapter07.parametric_search.bj6236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 6236 용돈관리: https://www.acmicpc.net/problem/6236
 */
public class Main {

    private static final int K = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N일 동안
        int M = Integer.parseInt(st.nextToken()); // 최대 출금 횟수
        int[] money = new int[N];
        int max = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, money[i]);
            sum += money[i];
        }

        int left = max; // max 금액 이하의 출금은 불가능
        int right = N * K; // K = 최대 10000
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossibleWithdraw(money, mid, M)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean isPossibleWithdraw(int[] money, int drawAmount, int maxDrawCount) {
        int drawCount = 1; // 처음 한번은 무조건 인출해야 함.
        int currentAmount = drawAmount;
        for (int useAmount : money) {
            if (useAmount > drawAmount) { // 사용해야 할 금액이 출금 금액보다 크면 그날 경비 사용 불가능
                return false;
            }
            if (currentAmount < useAmount) {
                if (drawCount == maxDrawCount) { // 출금이 가능하더라도 이미 출금 가능 횟수를 넘겼다면 false
                    return false;
                }
                drawCount++;
                currentAmount = drawAmount;
            }
            currentAmount -= useAmount;
        }
        return true;
    }
}
