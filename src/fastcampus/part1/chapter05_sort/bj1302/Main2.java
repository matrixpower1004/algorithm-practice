package fastcampus.part1.chapter05_sort.bj1302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 백준 1302 베스트셀러
 * https://www.acmicpc.net/problem/1302
 */

public class Main2 {

    public static void main(String[] args) throws IOException {

        // Map<String, Integer>의 value 값을 기준으로 내림차순 정렬, value 값이 같으면 key 오름차순 정렬
        Comparator<Map.Entry<String, Integer>> valueThenKeyComparator = (o1, o2) -> {
            if (o2.getValue().equals(o1.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue().compareTo(o1.getValue());
        };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        Map<String, Integer> titles = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String title = br.readLine();
            titles.put(title, titles.getOrDefault(title, 0) + 1);
        }
        List<Map.Entry<String, Integer>> result = titles.entrySet().stream()
            .sorted(valueThenKeyComparator)
            .collect(Collectors.toList());
        System.out.println(result.get(0).getKey());
    }
}
