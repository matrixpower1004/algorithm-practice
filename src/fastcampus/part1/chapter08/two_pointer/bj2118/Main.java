package fastcampus.part1.chapter08.two_pointer.bj2118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2118 두 개의 탑: https://www.acmicpc.net/problem/2118
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] distance = new int[N];
        int distanceSum = 0;
        for (int i = 0; i < N; i++) {
            distance[i] = Integer.parseInt(br.readLine());
            distanceSum += distance[i];
        }

        // 모든 기준 지점 i에서
        // 반시계방향거리 <= 시계방향거리가 되는 경계를 확인한다.
        int pairIndex = 0;
        int distForward = 0;
        int distReverse = distanceSum;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            while (distForward < distReverse) {
                distForward += distance[pairIndex];
                distReverse -= distance[pairIndex];
                pairIndex = (pairIndex + 1) % N;
            }
            ans = Math.max(ans, distReverse);
            distForward -= distance[i];
            distReverse += distance[i];
        }
        System.out.println(ans);
    }
}
