package fastcampus.part1.chapter03_arrays.bj3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * author         : Jisang Lee
 * date           : 2023-12-08
 * description    : 백준 3273 두 수의 합
 * https://www.acmicpc.net/problem/3273
 */
public class Main {

    private static final int MAX = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine()); // 입력될 수의 개수
        int num[] = new int[N];
        boolean exist[] = new boolean[MAX]; // 입력되는 수를 index로 사용
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.valueOf(st.nextToken());
            num[i] = value;
            exist[value] = true;
        }
        int X = Integer.valueOf(br.readLine()); // 요구하는 두 수의 합

        int result = 0; // 정답을 카운트

        // 구현방법 2
//        for (int i = 1; i <= (X - 1) / 2; i++) { // 중복 방지(X-1)/2. 전체를 다 돌면 같은 수 및 같은 숫자에 대해서 중복 카운트 발생
//            if (i <= 1000000 && X - i <= 1000000) {
//                result += (exist[i] && exist[X - i]) ? 1 : 0;
//            }
//        }

        // 구현방법 1
        for (int i = 0; i < N; i++) {
            int pairValue = X - num[i];
            if (num[i] >= pairValue) continue; // 같은 숫자 또는 중복 카운팅 방지
            if (1 <= pairValue && pairValue <= 100000 ) {
                result += exist[pairValue] ? 1 : 0;
            }
        }
        System.out.println(result);
    }
}
