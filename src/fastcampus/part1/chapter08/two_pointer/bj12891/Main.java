package fastcampus.part1.chapter08.two_pointer.bj12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 12891 DNA 비밀번호: https://www.acmicpc.net/problem/12891
 */
public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] dnaStr = br.readLine().toCharArray();
        int[] reqCount = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            reqCount[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[4];
        // 이전 count가 이미 구해져 있다는 것을 전제로 한다.
        // 제일 첫 윈도우는 이전 상태라고 할 것이 없으므로 해당 부분을 전처리 해준다.
        for (int i = 0; i < P - 1; i++) {
            count[charToIndex(dnaStr[i])]++;
        }
        int ans = 0;
        // 모든 경우의 수 탐색 -> 슬라이드 윈도우 이용

        for (int i = P - 1; i < S; i++) { // 끝을 다루기 쉽다.
            // 이번 윈도우의 끝 값을 추가
            count[charToIndex(dnaStr[i])]++;
            if (isValid(count, reqCount)) {
                ans++;
            }
            // 이번 윈도의의 첫 값을 제거. 지금 제일 앞에 있는 값이 다음 윈도우에서는 빠져야 한다.
            count[charToIndex(dnaStr[i - P + 1])]--;
        }
        System.out.println(ans);
    }

    private static boolean isValid(int[] count, int[] reqCount) {
        for (int i = 0; i < 4; i++) {
            if (count[i] < reqCount[i]) {
                return false; // 하나라도 요구하는 문자열 길이 이하려면 false
            }
        }
        return true;
    }

    private static int charToIndex(char alp) {
        switch (alp) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
            default:
                return -1;
        }
    }
}
