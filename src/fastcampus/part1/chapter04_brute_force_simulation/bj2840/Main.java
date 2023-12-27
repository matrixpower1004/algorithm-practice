package fastcampus.part1.chapter04_brute_force_simulation.bj2840;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * author         : Jisang Lee
 * date           : 2023-12-19
 * description    : 백준 2840 행운의 바퀴
 * https://www.acmicpc.net/problem/2840
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        int K = Integer.valueOf(st.nextToken());
        char[] wheel = new char[N];
        Arrays.fill(wheel, '?'); // 미리 '?' 채워 넣기

        boolean[] isExist = new boolean[26]; // 중복 문자 체크용
        int curIndex = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.valueOf(st.nextToken());
            char alphabet = st.nextToken().charAt(0);
            // 바퀴의 방향과 화살표의 방향은 반대이므로 curIndex - S를 해주는데
            // 몇 바퀴나 돌았는지 모르니까 (curIndex - S) % N 연산을 해준다. (모듈러 연산)
            // 이 때 주의할 점은 Java의 modular 연산은 (curIndex - S)의 값이 음수면 읍수값을 리턴할 수 있다.
            // 따라서 음수 방지를 위해서 N을 더해서 양수로 만든 후 다시 % N으로 나누어 준다.
            curIndex = (curIndex + N - (S % N)) % N;

            if (wheel[curIndex] == alphabet) continue;

            if (wheel[curIndex] == '?' && !isExist[alphabet - 'A']) {
                wheel[curIndex] = alphabet; // 중복 문자가 아닐때만 저장
                isExist[alphabet - 'A'] = true;
            } else {
                System.out.println("!"); // 올바른 바퀴가 아니라면 프로그램 종료
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(wheel[(curIndex + i) % N]);
        }
        System.out.println(sb);
    }
}
