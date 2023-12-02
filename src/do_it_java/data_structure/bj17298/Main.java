package do_it_java.data_structure.bj17298;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * author         : matrix
 * date           : 2023-08-28
 * description    : 백준 17298 오큰수
 * https://www.acmicpc.net/problem/17298
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine()); // 입력 받을 N개의 수를 저장

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N]; // 입력 받은 수열을 저장할 배열
        int[] ansArr = new int[N]; // 오큰수를 저장할 배열

        for (int i = 0; i < N; i++) {
            A[i] = Integer.valueOf(st.nextToken());
        }

        Deque<Integer> myStack = new ArrayDeque(N);
        // 입력받은 배열을 오른쪽에서 왼쪽으로 탐색하며 오큰수를 구한다.
        for (int i = N - 1; i >= 0; i--) {
            // 스택이 비어있지 않고 현재 수열이 스택에 저장된 값보다 큰 경우 스택의 값을 제거
            while (!myStack.isEmpty() && A[i] >= myStack.getLast()) {
                myStack.removeLast();
            }
            // 오큰수 배열에 스택이 비어 있다면 -1, 아니라면 스택의 top에 위치한 값을 넣는다.
            ansArr[i] = myStack.isEmpty() ? -1 : myStack.getLast();
            myStack.addLast(A[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : ansArr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
