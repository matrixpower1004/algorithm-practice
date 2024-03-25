package fastcampus.part2.chapter2.stack.bj3986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 3986 좋은 단어: https://www.acmicpc.net/problem/3986
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0; // 좋은 단어의 수
        while (N-- > 0) {
            String input = br.readLine();
            int size = input.length();
            if (size % 2 == 1) {
                continue; // 입력된 단어가 홀수라면 짝이 맞지 않으므로 진행할 필요가 없다.
            }
            char[] stack = new char[size];
            int index = -1;
            for (char ch : input.toCharArray()) {
                if (index >= 0 && stack[index] == ch) {
                    index--;
                } else {
                    stack[++index] = ch;
                }
            }

            if (index < 0) { // loop 종료 후 스택이 비었다면 좋은 단어
                count++;
            }
        }
        System.out.println(count);
    }
}
