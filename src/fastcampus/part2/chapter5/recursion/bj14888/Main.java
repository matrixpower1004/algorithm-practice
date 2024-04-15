package fastcampus.part2.chapter5.recursion.bj14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 14888 연산자 끼워넣기: https://www.acmicpc.net/problem/14888
 */
public class Main {

    public static final int PLUS = 0;
    public static final int MINUS = 1;
    public static final int MUL = 2;
    public static final int DIV = 3;

    public static int N;
    public static int[] numbers;
    public static int[] operators = new int[4];

    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }
        solve(1, numbers[0]);
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(min);
        System.out.println(sb);
    }

    static void solve(int index, int sum) {
        // base case: 종료 조건
        if (index == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        // recursive case: 연산자를 하나씩 사용
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--; // 연산 가능 회수 차감
                switch (i) {
                    case PLUS -> solve(index + 1, sum + numbers[index]);
                    case MINUS -> solve(index + 1, sum - numbers[index]);
                    case MUL -> solve(index + 1, sum * numbers[index]);
                    case DIV -> solve(index + 1, sum / numbers[index]);
                }
                operators[i]++; // 연산 가능 회수 복구
            }
        }
    }
}
