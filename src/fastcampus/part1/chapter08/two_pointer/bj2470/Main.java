package fastcampus.part1.chapter08.two_pointer.bj2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2470 두 용액: https://www.acmicpc.net/problem/2470
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;
        int criteria = Math.abs(arr[left] + arr[right]);
        int[] ans = new int[2];
        ans[0] = arr[left];
        ans[1] = arr[right];
        while (left < right) {
            int sum = arr[left] + arr[right];
            int absSum = Math.abs(sum);
            if (criteria > absSum) {
                criteria = absSum; // 이전 절대 값이 현재 절대 값보다 크면 새로운 값으로 답을 갱신
                ans[0] = arr[left];
                ans[1] = arr[right];
            }
            if (sum > 0) { // 두수를 더해서 양수가 나오면 오른쪽 인텍스를 1 감소시킨다.
                right--;
            } else { // 두 수를 더해서 음수가 나오면 왼쪽 index 를 1 증가 시킨다.
                left++;
            }
        }
        System.out.println(ans[0] + " " + ans[1]);
    }
}
