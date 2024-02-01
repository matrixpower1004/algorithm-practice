package fastcampus.part1.chapter06.prefixsum.bj19951;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 19951 태상이의 훈련소 생활
 * https://www.acmicpc.net/problem/19951
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken()); // 연병장의 크기
        int M = Integer.valueOf(st.nextToken()); // 조교의 수

        st = new StringTokenizer(br.readLine());
        int[] input = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            input[i] = Integer.valueOf(st.nextToken());
        }

        // b + 1에 변화량의 역을 저장하고, index 1부터 사용하므로 배열의 크기를 +2 크게 만들어준다.
        int[] delta = new int[N + 2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int k = Integer.valueOf(st.nextToken());
            // 1. 각 지시에 따른 변화량 delta를 기록한다.
            // delta[i]: [i:N]까지 적용되는 변화량
            delta[a] += k;
            delta[b + 1] -= k;
        }

        // 2. 각 칸부터의 변화량을 각 칸에 적용한다.
        int[] accDelta = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            accDelta[i] = accDelta[i - 1] + delta[i];
        }

        // 3. 변화량이 적용된 각 칸의 높이를 출력한다.
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int ans = input[i] + accDelta[i];
            sb.append(ans).append(" ");
        }
        sb.append("\n");
        System.out.println(sb);
    }
}
