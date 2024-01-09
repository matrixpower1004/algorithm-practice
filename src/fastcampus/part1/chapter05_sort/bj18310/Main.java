package fastcampus.part1.chapter05_sort.bj18310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 18310 안테나
 * https://www.acmicpc.net/problem/18310
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        int[] house = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            house[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(house);

        int result = house[(N - 1) / 2];
        System.out.println(result);
    }

}
