package fastcampus.part1.chapter07.binary_search.bj1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1920 수 찾기
 * https://www.acmicpc.net/problem/1920
 */
public class Main {

    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 입력 배열에 수를 입력 받아서 저장한다.
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        // 찾기 원하는 수를 입력 받아서 저장한다.
        int M = Integer.valueOf(br.readLine());
        int[] question = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M ; i++) {
            question[i] =  Integer.valueOf(st.nextToken());

        }

        // 이진 탐색을 위하여 배열을 정렬한다.
        Arrays.sort(arr);

        // 이진 탐색을 하고 결과를 저장한다.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            boolean existNumber = isExist(question[i]);
            sb.append(existNumber ? "1" : "0").append("\n");
        }
        System.out.println(sb);
    }

    // binary search(이진 탐색) 로직
    private static boolean isExist(int X) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int m = (left + right) / 2;
            if (arr[m] < X) {
                left = m + 1;
            } else if (arr[m] > X) {
                right = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
