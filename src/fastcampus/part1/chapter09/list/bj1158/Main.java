package fastcampus.part1.chapter09.list.bj1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * 백준 1158 요세푸스 문제: https://www.acmicpc.net/problem/1158
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> survivors = new ArrayList<>(N);
        for (int i = 1; i <= N; i++) {
            survivors.add(i);
        }
        int[] ans = new int[N];
        // K번재 사람이 누군이지 계산헤서 그 사람을 제거하고 다음 인덱스 계산에 사용할 수 있도록 index를 유지한다.
        int currentIndex = 0;
        for (int i = 0; i < N; i++) {
            currentIndex = (currentIndex + K - 1) % survivors.size();
            ans[i] = survivors.remove(currentIndex);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(Arrays.stream(ans)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(", ")));
        sb.append(">");
        System.out.println(sb);
    }
}
