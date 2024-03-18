package fastcampus.part2.chapter1.stack.bj1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1874 스택 수열: https://www.acmicpc.net/problem/1874
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        int[] stack = new int[N];
        int topIndex = -1;
        int lastNumber = 1;
        for (int x : input) {
            // 1. x가 이전에 push했던 제일 큰 수 보다 작면 x까지 push한다.
            while (lastNumber <= x) {
                sb.append("+\n");
                stack[++topIndex] = lastNumber++;
            }
            // 2. top이 x인지 확인한다.
            // 2-1. top이 x라면 pop
            // 2-2. top이 x가 아니라면 불가능
            if (topIndex < 0 || stack[topIndex] != x) {
                System.out.println("NO");
                return;
            }
            sb.append("-\n");
            topIndex--;
        }
        System.out.println(sb);
    }
}
