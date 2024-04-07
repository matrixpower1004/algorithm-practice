package fastcampus.part2.chapter5.recursion.bj1208;

import static fastcampus.part2.chapter5.recursion.bj1208.STATUS.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 백준 1208 부분수열의 합 2: https://www.acmicpc.net/problem/1208
 */
public class Main {

    static int S;
    static int[] numbers;
    static long answer = 0;
    static Map<Integer, Integer> count = new HashMap<>();
    static STATUS status;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        status = LEFT;
        solve(0, N / 2, 0);

        status = RIGHT;
        solve(N / 2, N, 0);

        if (S == 0) { // S가 0인 경우 중복 카운트 제거
            answer--;
        }
        System.out.println(answer);
    }

    private static void solve(int index, int end, int sum) {
        // base case
        if (index == end) {
            if (status == LEFT) {
                int previous = count.getOrDefault(sum, 0);
                count.put(sum, previous + 1);
            } else if (status == RIGHT) {
                answer += count.getOrDefault(S - sum, 0);
            }
            return;
        }

        // recursive case
        solve(index + 1, end, sum); // index의 수를 뽑지 않는 경우
        solve(index + 1, end, sum + numbers[index]); // index의 수를 뽑는 경우
    }
}

enum STATUS {
    LEFT, RIGHT;
}
