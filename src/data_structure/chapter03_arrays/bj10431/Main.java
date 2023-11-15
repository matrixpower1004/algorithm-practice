package data_structure.chapter03_arrays.bj10431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * author         : Jisang Lee
 * date           : 2023-11-15
 * description    : 백준 10431 줄세우기
 * https://www.acmicpc.net/problem/10431
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = 20;
        
        int P = Integer.valueOf(br.readLine());
        while (P-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.valueOf(st.nextToken());
            int[] height = new int[N];
            for (int i = 0; i < N; i++) {
                height[i] = Integer.valueOf(st.nextToken());
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < i; j++) {
                    if (height[j] > height[i]) {
                        int myHeight = height[i];
                        for (int k = i; k > j; k--) {
                            height[k] = height[k - 1];
                            count++;
                        }
                        height[j] = myHeight;
                        break;
                    }
                }
            }
            sb.append(T).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }
}
