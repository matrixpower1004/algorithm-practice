package fastcampus.part1.chapter04.brute_force_simulation.bj10448;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * author         : Jisang Lee
 * date           : 2023-12-12
 * description    : 백준 10448 유레카 이론
 * https://www.acmicpc.net/problem/10448
 */
public class Main {

    private static boolean[] isEurekaNumber = new boolean[1001];

    private static void preProcess() {
        // 1. 주어진 K 보다 작은 삼각수를 모두 구한다.
        int[] triangleNumbers = new int[50];
        int triangleNumberCount = 0;
        for (int i = 1; ; i++) {
            int triangleNumber = i * (i + 1) / 2;
            if (triangleNumber >= 1000) break;
            triangleNumbers[triangleNumberCount++] = triangleNumber;
        }

        // 2. 구해진 삼각수 세개의 합으로 K를 나타낸 수가 있는지 확인한다.
        for (int i = 0; i < triangleNumberCount; i++)
            for (int j = i; j < triangleNumberCount; j++)
                for (int k = j; k < triangleNumberCount; k++) {
                    int eurekaNumber = triangleNumbers[i] + triangleNumbers[j] + triangleNumbers[k];
                    if (eurekaNumber > 1000) break;
                    isEurekaNumber[eurekaNumber] = true;
                }
    }

    public static void main(String[] args) throws IOException {
        // [3, 1000] 범위의 isEurekaNumber[] 배열을 미리 완성을 해둔다.
        preProcess();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.valueOf(br.readLine());
        while (T-- > 0) {
            int K = Integer.valueOf(br.readLine());
            if (isEurekaNumber[K]) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
