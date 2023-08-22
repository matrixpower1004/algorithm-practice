package data_structure.bj1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * author         : matrix
 * date           : 2023-08-23
 * description    : 백준 1253 좋다
 * https://www.acmicpc.net/problem/1253
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수 N을 입력 받고 배열에 저장
        int N = Integer.valueOf(br.readLine());
        long[] numArr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Long.valueOf(st.nextToken());
        }

        // 배열을 정렬
        Arrays.sort(numArr);

        // 좋은 수 판별
        int answer = 0;

        for (int i = 0; i < N; i++) {
            long find = numArr[i];
            int start = 0;
            int end = N - 1;

            while (start < end) {
                if (numArr[start] + numArr[end] == find) {
                    if (start != i && end != i) { // 좋은 수는 서로 다른 두 수의 합이어야 한다.
                        answer++;
                        break;
                    } else if (start == i) {
                        start++;
                    } else if (end == i) {
                        end--;
                    }
                } else if (numArr[start] + numArr[end] < find) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        System.out.println(answer);
        br.close();
    }
}
