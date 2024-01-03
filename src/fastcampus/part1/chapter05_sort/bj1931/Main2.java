package fastcampus.part1.chapter05_sort.bj1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1931 회의실 배정
 * https://www.acmicpc.net/problem/1931
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        // 0 = start / 1  = end
        int[][] meeting = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.valueOf(st.nextToken());
            meeting[i][1] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(meeting, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int count = 0;
        int ended = 0;
        for (int i = 0; i <N ; i++) {
            if (ended <= meeting[i][0]) {
                ended = meeting[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
