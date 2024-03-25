package fastcampus.part2.chapter2.stack.bj10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 10799 쇠막대기: https://www.acmicpc.net/problem/10799
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int N = input.length();
        char[] arr = new char[N + 1];
        // 원본 배열, 원본 시작 위치, 대상 배열, 대상 시작 위치, 크기
        System.arraycopy(input.toCharArray(), 0, arr, 1, N);

        int[] accLaser = new int[N + 1]; // 레이저의 누적합을 저장
        for (int i = 1; i <= N ; i++) {
            accLaser[i] = accLaser[i - 1];
            if (arr[i] == '(' && arr[i + 1] == ')') {
                accLaser[i]++;
            }
        }

        int ans = 0;
        int[] stick = new int[N + 1];
        int topIndex = -1;
        for (int i = 1; i <= N; i++) {
            // 여는 괄호일 때 레이저가 아니라면 쇠막대기의 시작 위치를 저장
            if (arr[i] == '(' && arr[i + 1] != ')') {
                stick[++topIndex] = i;
            } else if (arr[i] == ')' && arr[i - 1] != '(') {
                // 닫는 괄호일 때 레이저가 아니라면 정답에 레이저의 구간합 + 1만큼 더해준다.
                int openIndex = stick[topIndex--];
                ans += accLaser[i] - accLaser[openIndex - 1] + 1;
            }
        }
        System.out.println(ans);
    }
}
