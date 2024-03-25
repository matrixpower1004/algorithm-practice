package fastcampus.part2.chapter1.stack.bj6198;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 6198 옥상 정원 꾸미기: https://www.acmicpc.net/problem/6198
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] building = new int[N];
        for (int i = 0; i < N; i++) {
            building[i] = Integer.parseInt(br.readLine());
        }

        int[] stack = new int[N];
        int topIndex = -1;
        long ans = 0;
        for (int height: building) {
            // 현재 빌딩보다 낮은 높이의 빌딩 옥상만 볼 수 있다.
            while (topIndex >= 0 && stack[topIndex] <= height) {
                topIndex--;
            }
            stack[++topIndex] = height; // stack에 현재 빌딩의 높이를 기록
            ans += topIndex; // 정답에 현재 stack의 index 만큼 더해준다.
        }
        System.out.println(ans);
    }
}
