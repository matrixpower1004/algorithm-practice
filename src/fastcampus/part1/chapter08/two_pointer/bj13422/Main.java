package fastcampus.part1.chapter08.two_pointer.bj13422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 13422 도둑: https://www.acmicpc.net/problem/13422
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수 (자연수)
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) { // 테스트 케이스의 수만큼 반복
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 집의 개수 (1 ~ 100_000)
            int M = Integer.parseInt(st.nextToken()); // 도둑이 돈을 훔칠 연속된 집의 개수 (1 <= M <= N)
            int K = Integer.parseInt(
                st.nextToken()); // 자동 방범 장치가 작동하는 최소 돈의 양(정수, 1<= K <= 1_000_000_000)
            int[] house = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                house[j] = Integer.parseInt(st.nextToken());
            }
            int ans = calcStealMoney(house, N, M, K); // 돈을 훔치는 방법의 가짓수를 계산
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    // 슬라이딩 윈도우를 이용한 계산
    private static int calcStealMoney(int[] house, int N, int M, int K) {
        int prefixSum = 0;
        for (int i = 0; i < M; i++) {
            prefixSum += house[i];
        }
        int count = (prefixSum < K) ? 1 : 0;
        if (N == M) {
            return count; // N과 M이 같다면 현재 구해진 count를 반환한다.
        }
        for (int i = 1; i < N; i++) {
            int right = (i + M - 1) % N;
            prefixSum -= house[i - 1];
            prefixSum += house[right];
            if (prefixSum < K) {
                count++;
            }
        }
        return count;
    }
}
