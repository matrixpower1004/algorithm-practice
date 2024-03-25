package fastcampus.part2.chapter2.stack.bj2841;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2841 외계인의 기타 연주: https://www.acmicpc.net/problem/2841
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 음의 수
        int P = Integer.parseInt(st.nextToken()); // 프렛의 수

        int[] topIndex = new int[7]; // 줄의 수 1~6까지 fret의 위치를 저장
        Arrays.fill(topIndex, -1);
        int[][] melody = new int[7][P];
        int count = 0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int fret = Integer.parseInt(st.nextToken());
            // TODO: 내일 코드 개선해 보자
            while (topIndex[line] >= 0) {
                // 입력된 플렛이 저장된 플렛 위치보다 작다면 pop을 해주고 손가락 이동 회수를 1증가 시킨다.
                if (melody[line][topIndex[line]] > fret) {
                    topIndex[line]--;
                    count++;
                } else {
                    break;
                }
            }
            if (topIndex[line] >= 0 && melody[line][topIndex[line]] == fret) {
                continue;
            }
            melody[line][++topIndex[line]] = fret;
            count++;
        }
        System.out.println(count);
    }
}
