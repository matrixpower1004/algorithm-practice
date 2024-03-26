package fastcampus.part2.chapter3.recursion.bj15654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 15654 N과 M (5): https://www.acmicpc.net/problem/15654
 */
public class Main {

    static int N, M;
    static int[] numbers, output;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        check = new boolean[N];
        output = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        perm(0);
        System.out.println(sb);
    }

    private static void perm(int depth) {
        // base case - M개 만큼의 수를 뽑는다.
        if (depth == M) {
            for (int num: output) {
                sb.append(num).append(' ');
            }
            sb.append('\n');
            return;
        }

        // recursive case
        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                check[i] = true;
                output[depth] = numbers[i];
                perm(depth + 1); // 다음 수를 뽑기 위해서 depth을 하나 증가시켜준다.
                // i번째 수의 사용이 끝나면 다음 재귀 호출을 위해 i번째 수를 재사용 가능하도록 초기화
                check[i] = false;
            }
        }
    }
}
