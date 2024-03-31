package fastcampus.part3.dfs_bfs.bj1941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 백준 1941 소문난 칠공주: https://www.acmicpc.net/problem/1941
 */
public class Main {

    static int[] students = new int[25]; // 학생들을 0~24까지 번호를 할당
    static boolean[] check = new boolean[25];
    static List<Integer> pick = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            for (var ch : input.toCharArray()) {
                if (ch == 'S') {
                    students[count] = 1; // 이다솜파를 1로 치환
                } else {
                    students[count] = 0; // 임도연파를 0으로 치환
                }
                count++;
            }
        }
        int ans = nextCombination(0);
        System.out.println(ans);
    }

    static int nextCombination(int studentNum) { // 순열 생성
        // base case
        if (pick.size() == 7) {
            // 이다솜파의 인원이 4명 이상인지?
            int cnt = 0;
            for (int i = 0; i < 7; i++) {
                if (students[pick.get(i)] == 1) {
                    cnt++;
                }
            }
            if (cnt < 4) {
                return 0; // 이다솜파가 4명 미만이라면 조합으로 사용하지 않는다.
            }
            // 7명이 모두 인접해 있는지 여부 판단
            for (int i = 0; i < 7; i++) {
                check[i] = false;
            }
            if (dfs(0) == 7) {
                return 1; // 이다솜파의 조합인 경우
            }
            return 0;
        }

        // 25명의 학생을 다 순열 생성에 사용해봤는데, 7명이 모이지 않은 경우 종료
        if (studentNum >= 25) {
            return 0;
        }

        // recursive case
        // 조합의 개수
        int ret = 0;
        // studentNum 번째 학생을 포함하지 않는 경우
        ret += nextCombination(studentNum + 1);
        // studentNum 번째 학생을 포함하는 경우
        pick.add(studentNum);
        ret += nextCombination(studentNum + 1);
        // 탐색이 끝나면 포함했던 학생을 제거하고 다음번 탐색에 활용될 수 있도록 해준다
        pick.remove(pick.size() - 1);
        return ret; // 최종적으로 나온 조합의 개수를 return
    }

    static int dfs(int studentNum) {
        int count = 1;
        check[studentNum] = true;
        int me = pick.get(studentNum);
        for (int i = 0; i < 7; i++) {
            int you = pick.get(i);
            if (!check[i] && isFriend(me, you)) {
                count += dfs(i);
            }
        }
        return count;
    }

    /*
    * 가로줄은 1씩 차이나고 세로줄은 5씩 차이난다.
    * 단, 큰수를 5로 나누어 떨어지면 학생들이 경계에 걸쳐 있는 케이스가 된다.
     */
    static boolean isFriend(int a, int b) { // 인접한 학생들 여부 판단
        int diff = Math.abs(a - b);
        int max = Math.max(a, b);
        // 두 숫자가 차가 1인데 큰수가 5로 나누어 떨어지지 않는다면 가로줄에 위치한 케이스
        if (diff == 1 && max % 5 != 0) {
            return true;
        }
        if (diff == 5) { // 두 숫자의 차가 5라면 세로줄에 위치한 케이스
            return true;
        }
        return false;
    }
}
