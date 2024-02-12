package fastcampus.part1.chapter07.parametric_search.bj2343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2343 기타 레슨: https://www.acmicpc.net/problem/2343
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] lectures = new int[N];
        int max = -1;
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            max = Math.max(lectures[i], max);
            sum += lectures[i];
        }
        int left = max; // max 길이 이하의 강의는 블루레이에 담을 수 없다
        int right = sum; // 강의의 최대 길이
        int bluRaySize = -1; // 블루레이 사이즈
        while (left <= right) {
            int mid = (left + right) / 2;
            // 1. 현재의 길이로 모든 강의를 다 담을 수 있나?
            if (isPossibleBluRay(lectures, mid, M)) {
                // 2. 담을 수 있다면 길이를 줄여본다.
                bluRaySize = mid;
                right = mid - 1;
            } else {
                // 2. 담을 수 없다면 길이를 늘려본다.
                left = mid + 1;
            }
        }
        System.out.println(bluRaySize);
    }

    private static boolean isPossibleBluRay(int[] lectures, int targetSize, int maxBluRayCount) {
        int count = 1;
        int currentSize = 0;
        for (int lecture : lectures) {
            if (lecture > targetSize) {
                // 강의 하나의 크기가 블루레이의 사이즈보다 크다면 담을 수 없다.
                return false;
            }
            if (currentSize + lecture > targetSize) {
                // 담을 수 있어도 count가 블루레이의 최대 개수보다 크다면 false.
                if (++count > maxBluRayCount) {
                    return false;
                }
                currentSize = 0;
            }
            currentSize += lecture;
        }
        return true;
    }
}
