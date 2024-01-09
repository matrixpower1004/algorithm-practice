package fastcampus.part1.chapter01.string.bj2744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * author         : Jisang Lee
 * date           : 2023-10-17
 * description    : 백준 2744: 대소문자 바꾸기
 * https://www.acmicpc.net/problem/2744
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);

            if (Character.isLowerCase(temp)) {
                answer.append(Character.toUpperCase(temp));
            } else {
                answer.append(Character.toLowerCase(temp));
            }
        }

        System.out.println(answer);
    }

}
