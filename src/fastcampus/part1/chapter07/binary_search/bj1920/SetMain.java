package fastcampus.part1.chapter07.binary_search.bj1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 백준 1920 수 찾기
 * https://www.acmicpc.net/problem/1920
 */
public class SetMain {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        Set<Integer> input = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수를 입력 받아서 Set에 저장한다.
        for (int i = 0; i < N; i++) {
            input.add(Integer.parseInt(st.nextToken()));
        }

        // 찾기 원하는 수를 입력 받아서 결과룰 저장한다.
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M ; i++) {
            int q = Integer.parseInt(st.nextToken());
            sb.append(input.contains(q) ? "1" : "0").append("\n");
        }

        // 결과 출력
        System.out.println(sb);
    }
}
