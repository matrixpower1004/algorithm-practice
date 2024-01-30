package fastcampus.part1.chapter05.sort.bj2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 백준 2751 수 정렬하기 2
 * https://www.acmicpc.net/problem/2751
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nums.add(Integer.valueOf(br.readLine()));
        }

        Collections.sort(nums);

        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }
}
