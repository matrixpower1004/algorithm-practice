package fastcampus.part1.chapter08.two_pointer.bj12891;

import com.sun.security.jgss.GSSUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 12891 DNA 비밀번호: https://www.acmicpc.net/problem/12891
 */
public class Main2 {

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

        // 누적합을 이용하기 위한 전처리
        int[][] accCount = new int[S + 1][4];
        for (int i = 1; i <= S; i++) {
            for (int j = 0; j < 4; j++) {
                accCount[i][j] = accCount[i - 1][j];
            }
            accCount[i][charToIndex(dnaStr[i - 1])]++;
        }

        int ans = 0;
        for (int l = 1; l <= S - P + 1; l++) {
            boolean isValid = true;
            for (int i = 0; i < 4; i++) {
                int count = accCount[l + P - 1][i] - accCount[l - 1][i];
                if (count < reqCount[i]) {
                    isValid = false;
                }
            }
            if (isValid) {
                ans++;
            }
        }
        System.out.println(ans);
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
