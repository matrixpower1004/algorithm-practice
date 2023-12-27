package fastcampus.part1.chapter04_brute_force_simulation.bj1110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * author         : Jisang Lee
 * date           : 2023-12-24
 * description    : 백준 1110 더하기 사이클
 * https://www.acmicpc.net/problem/1110
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        int count = getCycle(N);
        System.out.println(count);
    }

    private static int getCycle(int target) {
        int seed = target; // 입력되는 수가 0인 케이스가 있으므로 초기값 -1
        int count = 0;
        int[] arr = new int[2];
        do {
            // 1. N을 1의 자리와 10의 자리로 분해해서 배열의 [0][1]에 나누어 넣고
            arr[1] = seed % 10; // 1의 자리
            arr[0] = seed / 10; // 10의 자리

            // 2. 배열의[0]과 [1]을 더해서 새로운 수 tailNumber 를 만든다.
            // 10을 넘어가는 경우가 있을 수 있으므로 %10을 해서 1의 자리만 취한다.
            int tailNumber = (arr[0] + arr[1]) % 10;

            // 3. 배열의 [1]번지 값과 tailNumber 로 새로운 수를 만든다.
            seed = arr[1] * 10 + tailNumber;

            // 4. count를 1증가 시킨다.
            count++;
        } while (seed != target);
        return count;
    }
}
