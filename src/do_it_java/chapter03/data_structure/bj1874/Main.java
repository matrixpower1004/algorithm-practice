package do_it_java.chapter03.data_structure.bj1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * author         : matrix
 * date           : 2023-08-27
 * description    : 백준 1874 스택 수열
 * https://www.acmicpc.net/problem/1874
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 수열의 개수를 입력받는다.
        int numCount = Integer.valueOf(br.readLine());

        int start = 0; // 스택에 push 되었던 가장 마지막 수
        Deque<Integer> stack = new ArrayDeque<>(numCount);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numCount; i++) {
            // 수열을 이루는 정수를 입력 받는다.
            int value = Integer.valueOf(br.readLine());

            // 입력 받은 값이 스택에 push 한 마지막 수 보다 크다면 스택에 오름차순으로 push한다.
            if (value > start) {
                for (int j = start + 1; j <= value; j++) {
                    stack.addLast(j); // 스택에 오름차순으로 값을 저장하고 "+"를 출력한다.
                    sb.append("+").append("\n");
                }
                start = value; // 스택의 top에 위치한 값을 변수에 저장한다.
            }
            // 스택의 top에서 꺼낸 값이 입력 받은 수열과 다르다면 수열을 구성할 수 없다.
            else if (stack.peekLast() != value) {
                System.out.println("NO");
                return;
            }
            // 그외의 경우라면 스택에 저장된 값을 꺼내고 "-"를 출력한다.
            stack.pollLast();
            sb.append("-").append("\n");
        }
        System.out.println(sb);
    }
}
