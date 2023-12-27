package fastcampus.part1.chapter04_brute_force_simulation.bj11068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * author         : Jisang Lee
 * date           : 2023-12-14
 * description    : 백준 11068 회문인 수
 * https://www.acmicpc.net/problem/11068
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine()); // 데스트 데이터 수
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.valueOf(br.readLine());
            boolean answer = false;
            for (int i = 2; i <= 64 ; i++) { // 2~64진법까지
                int[] digit = convertBase(N, i);
                if (isPalindrome(digit)) {
                    answer = true;
                    break;
                }
            }
            sb.append(answer ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isPalindrome(int[] digit) {
        for (int i = 0; i < digit.length / 2; i++) {
            // 센터를 기준으로 대칭되는 숫자가 같은지 확인한다.
            if (digit[i] != digit[digit.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static int[] convertBase(int x, int B) {
        int len = 0; // 진법 변환 했을 때 자리수
        int tempX = x; // 뒤에서 x의 값을 사용해야 하므로 복사해서 자릿수를 구한다.
        while (tempX > 0) {
            tempX /= B;
            len++;
        }

        int[] digit = new int[len]; // 최대 자릿수 만큼만 배열의 길이를 지정
        int index = 0;
        while (x > 0) {
            digit[index++] = x % B;
            x /= B;
        }
        return digit;
    }
}
