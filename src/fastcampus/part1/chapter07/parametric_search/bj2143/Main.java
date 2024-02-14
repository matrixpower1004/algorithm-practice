package fastcampus.part1.chapter07.parametric_search.bj2143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 백준 2143 두 배열의 합: https://www.acmicpc.net/problem/2143
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N ; j++) {
                sum += A[j];
                sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
            }
        }

        long ans = 0;
        for (int i = 0; i < M; i++) {
            int sum = 0;
            for (int j = i; j < M; j++) {
                sum += B[j];
                ans += sumMap.getOrDefault(T - sum, 0);
            }
        }
        System.out.println(ans);
    }
}
