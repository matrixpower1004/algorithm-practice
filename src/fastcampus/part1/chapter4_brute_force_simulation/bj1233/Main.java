package fastcampus.part1.chapter4_brute_force_simulation.bj1233;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * author         : Jisang Lee
 * date           : 2023-12-22
 * description    : 백준 1233 주사위
 * https://www.acmicpc.net/problem/1233
 */
public class Main {

    public static void main(String[] args) throws IOException {
        // 1. 세 주사위의 면수를 입력 받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S1 = Integer.valueOf(st.nextToken());
        int S2 = Integer.valueOf(st.nextToken());
        int S3 = Integer.valueOf(st.nextToken());

        // 2. 세 주사위의 합을 index로 가지는 배열을 생성한다. S1 + S2 + S3 + 1
        int[] answer = new int[S1 + S2 + S3 + 1];

        for (int i = 1; i <= S1; i++) {
            for (int j = 1; j <= S2; j++) {
                for (int k = 1; k <= S3; k++) {
                    int index = i + j + k;
                    answer[index]++;
                }
            }
        }

        // 확인용 코드
        for (int i = 1; i < answer.length; i++) {
            System.out.printf("%d ", i);
        }
        System.out.println();

        for (int i = 1; i < answer.length; i++) {
            System.out.printf("%d ", answer[i]);
        }
        System.out.println();

        // 3. 합에서 가장 큰 숫자를 가진 index를 출력한다. 동일 값이 여러개라면 가장 작은 수를 출력.
        int max = 0;
        int result = 0;
        for (int i = 3; i < answer.length; i++) {
            if (max < answer[i]) {
                max = answer[i];
                result = i;
            }
        }
        System.out.println(result);
    }
}
