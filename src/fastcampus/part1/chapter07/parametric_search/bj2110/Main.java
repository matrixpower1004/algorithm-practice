package fastcampus.part1.chapter07.parametric_search.bj2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2110 공유기 설치: https://www.acmicpc.net/problem/2110
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 집의 갯수
        int C = Integer.parseInt(st.nextToken()); // 공유기의 갯수

        int[] houseLoc = new int[N];
        for (int i = 0; i < N; i++) {
            houseLoc[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houseLoc); // 오름차순 탐색을 위한 정렬

        // 1. 공유기 사아의 거리 탐색 범위를 정한다.
        int left = 1;
        int right = houseLoc[N - 1] - houseLoc[0];
        int ans = -1;
        while (left <= right) {
            // 2. 인접한 공유기 사아의 거리에 대해
            int mid = (left + right) / 2;
            if (calculateCount(houseLoc, mid) >= C) {
                // 2-1. 해당 거리를 지키면서 모든 공유기를 설치할 수 있다면 공유기 사이의 거리를 늘려본다.
                ans = mid;
                left = mid + 1;
            } else {
                // 2-2. 모든 공유기를 설치하는게 불가능하다면 공유기 사이의 거리를 좁힌다.
                right = mid - 1;
            }
        }
        // 3. 가능한 곡유기 사이의 최대 거리를 출력한다.
        System.out.println(ans);
    }

    private static int calculateCount(int[] houseLoc, int distance) {
        int count = 1;
        int previousLoc = houseLoc[0];
        for (int i = 1; i < houseLoc.length; i++) {
            if (houseLoc[i] - previousLoc >= distance) {
                previousLoc = houseLoc[i];
                count++;
            }
        }
        return count;
    }
}

