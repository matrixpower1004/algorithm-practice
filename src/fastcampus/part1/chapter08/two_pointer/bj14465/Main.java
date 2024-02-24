package fastcampus.part1.chapter08.two_pointer.bj14465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 14465: 소가 길을 건너간 이유 5: https://www.acmicpc.net/problem/14465
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 횡단보도의 수
        int K = Integer.parseInt(st.nextToken()); // 연속으로 작동해야 하는 신호등의 수
        int B = Integer.parseInt(st.nextToken()); // 고장난 신호등의 번호

        boolean[] isBroken = new boolean[N + 1]; // index 1부터 다룰 것이므로 N + 1개로 생성
        for (int i = 0; i < B ; i++) {
            int index = Integer.parseInt(br.readLine());
            isBroken[index] = true; // 고장난 신호등은 true로 교체.
        }

        int brokenCount = 0;
        for (int i = 1; i <= K; i++) { // 1 ~ K까지의 고장난 신호등 개수를 미리 계산해 놓는다.
            brokenCount += isBroken[i] ? 1 : 0;
        }

        int ans = brokenCount;
        // 1. 연속해야 작동해야 하는 신호등의 개수 K만큼 슬라이딩 윈도우를 유지하면서 고장난 신호등의 개수를 센다.
        // 2. 고장난 신호등의 개수가 가장 작은 구간합으로 정답을 교체한다.
        for (int i = 2; i <= N - K + 1; i++) {
            if (isBroken[i - 1]) {
                brokenCount--; // 윈도우를 오른쪽으로 이돟했으므로 i-1에 고장난 신호등이 있다면 개수를 빼준다.
            }
            if (isBroken[i + K - 1]) {
                brokenCount++; // 윈도우의 마지막 index에 고장난 신호등이 있다면 개수를 더해준다.
            }
            ans = Math.min(ans, brokenCount);
        }
        System.out.println(ans);
    }

    private static int calculate(boolean[] brokenLight, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += brokenLight[i] ? 1 : 0;
        }
        return sum;
    }
}
