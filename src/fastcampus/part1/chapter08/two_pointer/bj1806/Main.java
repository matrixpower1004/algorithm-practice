package fastcampus.part1.chapter08.two_pointer.bj1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1806 부분합: https://www.acmicpc.net/problem/1806
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int nextIndex = 0;
        int currentSum = arr[0];
        int ansLength = N + 1; // 답이 없는 경우를 대비하여 나올 수 없는 값으로 초기화를 한다.
        // 1. 0 ~ N-1 위치까지 탐색하면서 부분합을 구한다.
        for (int i = 0; i < N; i++) {
            while (currentSum < S && nextIndex < N - 1) {
                // 2. nextIndex의 부분합을 미리 더했기 때문에 index을 먼저 증가시킨다.
                currentSum += arr[++nextIndex];
            }
            if (currentSum >= S) {
                // 3. 만약 부분합이 S보타 크거나 같다면 지금까지의 더해온 수들의 개수를 비교하여 이전 개수보다 작다면 답을 갱신하다.
                ansLength = Math.min(ansLength, nextIndex - i + 1);
            }
            // 4. i 인덱스에 저장된 수를 부분합에서 빼준다.
            currentSum -= arr[i];
        }
        if (ansLength > N) {
            ansLength = 0; // 답이 없는 경우 0을 출력한다.
        }
        System.out.println(ansLength);
    }
}
