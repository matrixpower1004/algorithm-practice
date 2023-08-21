package data_structure.bj10986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * author         : matrix
 * date           : 2023-08-21
 * description    : 백준 10986 나머지 합
 * https://www.acmicpc.net/problem/10986
 */
public class Main {
    public static void main(String[] args) throws IOException {

        // 1. N개의 수와 나누어 떨어져야 하는 수 M을 입력 받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numCount = Integer.valueOf(st.nextToken());
        int divider = Integer.valueOf(st.nextToken());

        // 2. N개 만큼 수를 입력 받아 M으로 나누었을 때 나머지 값을 카운트한다.
        int num = 0;
        int prefixSum = 0;
        long[] restArray = new long[divider]; // 나머지 값을 저장할 배열

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= numCount; i++) {
            num = Integer.valueOf(st.nextToken());
            prefixSum = (prefixSum + num) % divider;
            restArray[prefixSum]++; // 같은 나머지를 가진 인덱스의 값을 1 증가 시킨다.
        }

        long answer = restArray[0]; // index[0] == 나머지가 0.
        // 같은 나머지를 가진 인덱스들 중 2개를 뽑는 경우의 수를 더해주기
        for (int i = 0; i < divider; i++) {
                answer += (restArray[i] * (restArray[i] - 1) / 2);
        }
        System.out.println(answer);
    }
}
