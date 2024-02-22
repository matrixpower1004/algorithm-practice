package fastcampus.part1.chapter08.two_pointer.bj15831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 15831 준표의 조약돌: https://www.acmicpc.net/problem/15831
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        String stone = br.readLine();

        // 1. 검은 조약돌이 B개 이하이면서
        // 2. 흰 조약돌이 W개 이상되는 부분문자열의 최대 길이를 구한다.
        int[] stoneCount = new int[2]; // 0 = blackCount, 1 = whiteCount
        int nextIndex = 0;
        int startIndex = 0;
        int answer = 0;
        while (nextIndex < N) {
            // 검은돌의 개수가 B개를 초과하면 시작인덱스의 조약돌 색상을 하나 빼주고 시작 인덱스를 1 증가 시킨다.
            if (stoneCount[0] > B) {
                updateStoneCount(stone.charAt(startIndex), stoneCount, -1);
                startIndex++;
            } else {
                // 각 색상의 돌 개수를 1증가 시킨다.
                updateStoneCount(stone.charAt(nextIndex), stoneCount, 1);
                nextIndex++;
            }
            // 현재 구간이 정답의 조건을 만족하면 길이를 갱신한다.
            if (stoneCount[0] <= B && stoneCount[1] >= W) {
                answer = Math.max(answer, nextIndex - startIndex);
            }
        }
        System.out.println(answer);
    }

    private static void updateStoneCount(char stone, int[] count, int value) {
        // 0 = blackCount, 1 = whiteCount
        if (stone == 'W') {
            count[1] += value;
        } else {
            count[0] += value;
        }
    }
}
