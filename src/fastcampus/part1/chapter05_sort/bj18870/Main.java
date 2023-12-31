package fastcampus.part1.chapter05_sort.bj18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 백준 18870 좌표 압축
 * https://www.acmicpc.net/problem/18870
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        int[] position = new int[N]; // 원본 입력 저장 배열
        int[] sorted = new int[N];   // 정렬 후 인덱스를 구할 배열

        // 1. 모든 입력을 배열에 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            position[i] = sorted[i] = Integer.valueOf(st.nextToken());
        }

        // 2. sorted 배열을 정렬
        Arrays.sort(sorted);

        // 3. Map에 sorted 배열에 저장된 값을 key로 압축된 좌표를 만들어 저장한다.
        Map<Integer, Integer> indexMap = new HashMap<>();
        int index = 0;
        for (int i : sorted) {
            if (!indexMap.containsKey(i)) {
                indexMap.put(i, index++);
            }
        }

        // 4. 원본 입력이 저장된 배열의 처음부터 순회하여 Map에 담긴 key 값과 비교하여 index를 출력한다.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int coordinate = indexMap.get(position[i]);
            sb.append(coordinate).append(" ");
        }
        System.out.println(sb);
    }
}
