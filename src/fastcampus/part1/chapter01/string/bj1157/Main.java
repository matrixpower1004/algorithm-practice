package fastcampus.part1.chapter01.string.bj1157;

import java.io.*;

/**
 * author         : Jisang Lee
 * date           : 2023-10-19
 * description    : 백준 1157 단어 공부
 * https://www.acmicpc.net/problem/1157
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine().toUpperCase(); // 입력 받은 문자를 대문자로 변환

        int[] count = new int[26]; // 알파벳 갯수 만큼
        for (int i = 0; i < input.length(); i++) {
            count[input.charAt(i) - 'A']++;
        }

        char maxAlphabet = '?'; // 가장 많이 사용된 알파멧을 저장
        int maxCount = -1;      // 가장 많이 사용된 알파벳의 사용 갯수. 사용되지 않은 알파벳을 고려하여 초기값을 -1로 설정.
        for (int i = 0; i < 26; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                maxAlphabet = (char) ('A' + i); // 가장 많이 사용된 알파벳을 저장
            } else if (count[i] == maxCount) {
                maxAlphabet = '?';
            }
        }
        br.close();
        bw.write(maxAlphabet);
        bw.flush();
        bw.close();
    }

}
