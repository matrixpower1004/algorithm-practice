package fastcampus.part2.chapter5.recursion.bj1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1182 부분수열의 합: https://www.acmicpc.net/problem/1182
 */
public class Main {

    static int S, N;
    static int[] numbers; // 입력을 저장할 배열
    static int ans = 0; // 정답 카운트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        solve(0, 0);
        System.out.println(ans);
    }

    private static void solve(int index, int sum) {
        // base case
        // 판단을 할 수가 남아 있지 않은 경우 종료
        if (index == N) {
            return;
        }
        if (sum + numbers[index] == S) {
            ans++;
        }

        // recursive case
        solve(index + 1, sum + numbers[index]); // 현재 인덱스의 수를 부분 수열로 뽑는 경우
        solve(index + 1, sum); // 현재 인덱스의 수를 부분 수열로 뽑지 않는 경우
    }
}
