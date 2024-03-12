package fastcampus.part2.chapter1.stack.bj10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 10799 쇠막대기: https://www.acmicpc.net/problem/10799
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();
        int size = input.length;
        int stickCount = 0;
        int ans = 0;
        for (int i = 0; i < size ; i++) {
            // 각각의 입력에 대해서 여는 괄호인지 닫는 괄호인지 구분한다.
            if (input[i] == '(') {
                // 여는 괄호가 나왔을 때 쇠막대기의 개수를 더해준다.
                stickCount++;
            } else if (input[i] == ')') {
                // 닫는 괄호가 나왔을 때 쇠막대기의 개수를 빼준다.
                stickCount--;
                if (input[i - 1] == '(') { // 닫는 괄호일 때 레이저인지 체크한다.
                    // 레이저라면 현재 레이저를 기점으로 레이저보다 앞의 여는 괄호가 있고, 레이저보다 뒤에 닫는 괄호가 나오는 쇠막대기의 개수를 답에 더해준다.
                    ans += stickCount;
                } else {
                    // 레이저가 아니라면 각각의 쇠막대기에 대해서 레이저 개수 +1 만큼 더해줘야 한다.
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
