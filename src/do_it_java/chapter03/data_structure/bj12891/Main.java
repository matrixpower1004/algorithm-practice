package do_it_java.chapter03.data_structure.bj12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * author         : matrix
 * date           : 2023-08-24
 * description    : 백준 12891번 DNA 비밀번호
 * https://www.acmicpc.net/problem/12891
 */
public class Main {
    static int[] reqPwdCount = new int[4]; // 부분 문자열에 포함되어야 할 A, C, G, T 문자의 최소 갯수를 저장할 배열
    static int[] chkPwdCount = new int[4]; // 입력된 DNA 문자열에서 ACGT의 갯수를 저장할 배열
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // DNA 문자열 길이와 부분 문자열 길이를 입력 받는다.
        int dnaStrLength = Integer.valueOf(st.nextToken());
        int subStrLength = Integer.valueOf(st.nextToken());

        // DNA 문자열을 입력 받는다.
        char[] dnaStr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            reqPwdCount[i] = Integer.valueOf(st.nextToken());
        }

        // 처음 슬라이딩 윈도우에 포함된 ACGT 문자의 개수를 카운트한다.
        for (int i = 0; i < subStrLength; i++) {
            addCount(dnaStr[i]);
        }
        checkMatch();

        // DNA 문자 배열의 마지막까지 윈도우를 이동하며 ACGT 문자의 개수를 카운트한다.
        for (int i = subStrLength; i < dnaStrLength; i++) {
            removeCount(dnaStr[i - subStrLength]);
            addCount(dnaStr[i]);
            checkMatch();
        }

        System.out.println(answer);
    }

    private static void addCount(char target) {
        if (target == 'A') {
            chkPwdCount[0]++;
        } else if (target == 'C') {
            chkPwdCount[1]++;
        } else if (target == 'G') {
            chkPwdCount[2]++;
        } else if (target == 'T') {
            chkPwdCount[3]++;
        }
    }

    private static void removeCount(char target) {
        if (target == 'A') {
            chkPwdCount[0]--;
        } else if (target == 'C') {
            chkPwdCount[1]--;
        } else if (target == 'G') {
            chkPwdCount[2]--;
        } else if (target == 'T') {
            chkPwdCount[3]--;
        }
    }

    private static void checkMatch() {
        for (int i = 0; i < 4; i++) {
            if (chkPwdCount[i] < reqPwdCount[i]) {
                return;
            }
        }
        answer++;
    }
}
