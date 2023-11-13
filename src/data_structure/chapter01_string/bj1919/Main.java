package data_structure.chapter01_string.bj1919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * author         : Jisang Lee
 * date           : 2023-10-18
 * description    : 백준 1919 애너그램 만들기
 * https://www.acmicpc.net/problem/1919
 */
public class Main {

    public static int[] getCount(String input) {
        int[] count = new int[26]; // 알파벳 갯수만큼
        for (int i = 0; i < input.length(); i++) {
            count[input.charAt(i) - 'a']++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String input2 = br.readLine();

        int[] check1 = getCount(input1);
        int[] check2 = getCount(input2);

        int result = 0;
        for (int i = 0; i < 26; i++) {
            // 알파벳의 갯수가 서로 다르다면 차이만큼 카운트에 합산.
            if (check1[i] != check2[i]) {
                result += Math.abs(check1[i] - check2[i]);
            }
        }
        System.out.println(result);
    }

}
