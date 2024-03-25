package fastcampus.part2.chapter2.stack.bj16120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 16120 PPAP: https://www.acmicpc.net/problem/16120
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        char[] transfer = new char[input.length()];
        int index = 0;
        // PPAP 문자열을 P로 치환 후에도 PPAP 문자열이 유지가 되어야 한다.
        for (char ch : input.toCharArray()) {
            transfer[index++] = ch;
            // 4개의 문자열을 검사해서 PPAP -> P로 변환한다.
            if (index >= 4 && isPPAP(transfer, index)) {
                index -= 3; // 맨앞의 문자는 P일 것이므로 4개 문자를 모두 빼지 않고 3개만 remove 한다.
            }
        }
        // PPAP 문자열을 모두 P로 치환한 후에는 P 하나만 남아야 한다.
        // 문자열의 길이가 1을 초과하거나 남아있는 문자가 P가 아니라면 PPAP 문자열이 아니다.
        if (index == 1 && transfer[0] == 'P') {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }

    private static boolean isPPAP(char[] transfer, int index) {
        // 제일 바닥의 글자의 index - 4는 P, -3은 P, -2는 A, -1은 P가 되어야 한다.
        return (transfer[index - 1] == 'P' && transfer[index - 2] == 'A'
               && transfer[index - 3] == 'P' && transfer[index - 4] == 'P');
    }

}
