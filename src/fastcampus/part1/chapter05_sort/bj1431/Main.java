package fastcampus.part1.chapter05_sort.bj1431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 1431 시리얼 번호
 * https://www.acmicpc.net/problem/1431
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        String[] serialNum = new String[N];

        for (int i = 0; i < N; i++) {
            serialNum[i] = br.readLine();
        }

        Arrays.sort(serialNum, (o1, o2) -> {
            int len1 = o1.length();
            int len2 = o2.length();
            if (len1 == len2) { // 길이를 비교하여 같으면
                int sum1 = checkSum(o1);
                int sum2 = checkSum(o2);
                if (sum1 == sum2) { // 문자열에 포함된 숫자의 합을 비교
                    return o1.compareTo(o2); // 같으면 사전순
                }
                return sum1 - sum2; // 아니면 숫자의 합이 작은 것이 먼저
            }
            return len1 - len2; // 문자열의 길이가 작은 순서로.
        });

        StringBuilder sb = new StringBuilder();
        for (String s : serialNum) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }

    private static int checkSum(String serial) {
        int sum = 0;
        int len = serial.length();
        for (int i = 0; i < len ; i++) {
            char x = serial.charAt(i);
            if (x >= '0' && x <= '9') {
                sum += Character.getNumericValue(x);
            }
        }
        return sum;
    }
}
