package fastcampus.part1.chapter08.two_pointer.bj11728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 11728 배열 합치기: https://www.acmicpc.net/problem/11728
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 두 배열을 합치기 위한 작업
        int indexA = 0;
        int indexB = 0;
        int start = 0;
        int[] combine = new int[N + M];
        // indexA와 indexB가 각각 N과 M 보다 작을동안 combine 배열에 두 배열의 값을 비교하여 작은 값을 저장한다.
        while (indexA < N && indexB < M) {
            if (A[indexA] <= B[indexB]) {
                combine[start++] = A[indexA++];
            } else {
                combine[start++] = B[indexB++];
            }
        }
        // A배열에 남아 있는 값이 있다면 combine 배열에 넣어준다.
        while (indexA < N) {
            combine[start++] = A[indexA++];
        }
        // 배열에 남아 있는 값이 있다면 combine 배열에 넣어준다.
        while (indexB < M) {
            combine[start++] = B[indexB++];
        }
        StringBuilder sb = new StringBuilder();
        for (int num : combine) {
            sb.append(num).append(" ");
        }
        sb.append("\n");
        System.out.println(sb);
    }
}