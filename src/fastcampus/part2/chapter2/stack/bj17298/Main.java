package fastcampus.part2.chapter2.stack.bj17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 17298 오큰수: https://www.acmicpc.net/problem/17298
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

        int[] ans = new int[N];   // 정답 기록 배열
        int[] stack = new int[N]; // 오큰 후 후보 저장
        int topIndex = -1;
        for (int i = N - 1; i >= 0; i--) {
            // 오큰수 후보를 추출하여 스택에 저장.
            while (topIndex >= 0 && stack[topIndex] <= arr[i]) {
                topIndex--; // 오큰수가 될 수 없으면 스택에 저장된 오큰수 후보를 remove
            }
            // while 종료 후 스택이 비었다면 arr[i]데 대한 오큰수가 없다는 의미
            ans[i] = (topIndex >= 0 ? stack[topIndex] : -1);
            // 현재 스택에는 arr[i]보다 큰 숫자들이 내림차순으로 쌓여있다.
            // arr[i - 1]의 값을 알 수 없기 때문에 arr[i]의 값을 스택에 추가한다.
            stack[++topIndex] = arr[i];
        }
        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            sb.append(i).append(" ");
        }
        sb.append("\n");
        System.out.println(sb);
    }
}
