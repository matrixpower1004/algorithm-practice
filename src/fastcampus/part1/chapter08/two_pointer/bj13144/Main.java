package fastcampus.part1.chapter08.two_pointer.bj13144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 13144 List of Unique Numbers: https://www.acmicpc.net/problem/13144
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 입력된 수를 index로 삼아서 수의 사용 여부를 판단한다.
        boolean[] used = new boolean[100001];
        long ans = 0; // 경우의 수가 int 범위를 벗어날 수 있다.
        int nextIndex = 0;
        for (int i = 0; i < N; i++) {
            while (nextIndex < N) {
                if (used[arr[nextIndex]]) {
                    break; // 현재 index의 수가 사용되었다면 loop 종료
                }
                used[arr[nextIndex++]] = true; // 사용되지 않은 수라면 사용으로 바꾸고 nextIndex 증가
                ans += nextIndex - i; // nextIndex와 leftIndex의 차이 만큼 답에 더해준다.
            }
            used[arr[i]] = false; // 다음 경우의 수를 보기 위하여 사용 여부를 초기화
        }
        System.out.println(ans);
    }
}
