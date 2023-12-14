package fastcampus.part1.chapter01_string.bj1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * author         : Jisang Lee
 * date           : 2023-10-19
 * description    : 백준 1543 문서검색
 * https://www.acmicpc.net/problem/1543
 */
public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = br.readLine();    // 주어진 문자열
//        String findWord = br.readLine(); // 찾을 문자열
//
//        int count = 0;
//        int startIndex = 0;
//        while (true) {
//            int findIndex = input.indexOf(findWord, startIndex);
//            if (findIndex < 0) {
//                break;
//            }
//            count++;
//            startIndex = findIndex + findWord.length();
//        }
//        System.out.println(count);
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();    // 주어진 문자열
        String findWord = br.readLine(); // 찾을 문자열

        String replaced = input.replace(findWord, "");
        int length = input.length() - replaced.length(); // 입력 받은 문자열의 길이에서 남은 문자열의 길이를 빼주고
        int count = length / findWord.length();          // 찾을 문자열의 길이로 나눠준다.
        System.out.println(count);
    }

}
