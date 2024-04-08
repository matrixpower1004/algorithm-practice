package fastcampus.part2.chapter5.recursion.bj1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1759 암호 만들기: https://www.acmicpc.net/problem/1759
 */
public class Main {

    static int L, C;
    static char[] input; // 입력 저장
    static char[] password; // 생성된 암호 저장
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        input = new char[C];
        password = new char[L];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            input[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(input);
        generate(0, 0, 0);
        System.out.println(sb);
    }

    /**
     * length: 출력과 관계된 매개 변수, inddex: 입력과 관련된 매개 변수
     * @param length : 현재 패스워드의 길이
     * @param index : 입력으로 주어진 문자 중 몇 번째 문자를 사용하고 있는지
     * @param vowelCount : 모음의 개수
     */
    private static void generate(int length, int index, int vowelCount ) {
        // base case
        if (length == L) {
            if (vowelCount >= 1 && L - vowelCount >= 2) {
                sb.append(password).append("\n");
            }
            return;
        }

        // recursive case
        if (index < C) { // 입력에서 더 이상 뽑을 문자가 없는 경우
            // password에 input[index]를 사용하는 경우
            password[length] = input[index];
            int v = isVowel(input[index]) ? 1 : 0;
            generate(length + 1, index + 1, vowelCount + v);

            // password에 input[index]를 사용하지 않는 경우
            password[length] = 0;
            generate(length, index + 1, vowelCount);
        }
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
