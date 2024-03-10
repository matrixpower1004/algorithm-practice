package fastcampus.part2.chapter1.stack.bj10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 10828 스택: https://www.acmicpc.net/problem/10828
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stack = new int[N];
        int topIndex = -1;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "push":
                    stack[++topIndex] = Integer.parseInt(st.nextToken());
                    break;
                case "pop":
                    ans.append(topIndex < 0 ? -1 : stack[topIndex--]).append("\n");
                    break;
                case "size":
                    ans.append(topIndex + 1).append("\n");
                    break;
                case "empty":
                    ans.append(topIndex == -1 ? 1 : 0).append("\n");
                    break;
                case "top":
                    ans.append(topIndex < 0 ? -1 : stack[topIndex]).append("\n");
                    break;
            }
        }
        System.out.println(ans);
    }
}
