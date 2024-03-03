package fastcampus.part1.chapter09.list.bj1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * 백준 1158 요세푸스 문제: https://www.acmicpc.net/problem/1158
 */
class MyArrayList {

    int[] data;
    int size;

    public MyArrayList(int intCapacity) {
        this.data = new int[intCapacity];
        this.size = 0;
    }

    // 문제 풀이에 필요한 add와 remove만 구현한다.
    public void add(int element) {
        if (size == data.length) { // 배열이 꽉차 있을 때
            growCapacity();
        }
        data[size++] = element;
    }

    private void growCapacity() {
        int newCapacity = data.length << 1; // 2배 사이즈로 눌린다.
        data = Arrays.copyOf(data, newCapacity);
    }

    public int remove(int idx) {
        int deletedElement = data[idx];
        System.arraycopy(data, idx + 1, data , idx, size - idx - 1);
        size--;
        return deletedElement;
    }

    public int size() {
        return size;
    }
}

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        MyArrayList survivors = new MyArrayList(N);
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
