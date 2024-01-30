package fastcampus.part1.chapter05.sort.bj2910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 백준 2910 빈도 정렬
 * https://www.acmicpc.net/problem/2910
 * LinkedHashMap을 이용한 풀이
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int C = Integer.valueOf(st.nextToken());

        Map<Integer, Integer> map = new LinkedHashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.valueOf(st.nextToken());
            map.put(num, map.getOrDefault(num ,0 ) + 1);
        }

        // 1. 더 많이 입력된 숫자가 먼저
        // 2. 입력된 횟수가 같으면 먼저 입력된 것이 먼저
        Integer[] frequencies = map.keySet().toArray(new Integer[map.size()]);
        // Integer 클래스를 do_it_java.chapter03.sort 했으므로 tim sort로 stable sort가 된다.
        Arrays.sort(frequencies, (o1, o2) -> map.get(o2) - map.get(o1));

        StringBuilder sb = new StringBuilder();
        for (int frequency : frequencies) {
            int count = map.get(frequency);
            while (count-- > 0) {
                sb.append(frequency).append(" ");
            }
        }
        System.out.println(sb);
    }
}
