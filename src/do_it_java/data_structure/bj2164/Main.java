package do_it_java.data_structure.bj2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * author         : matrix
 * date           : 2023-08-29
 * description    : 백준 2164 카드 2
 * https://www.acmicpc.net/problem/2164
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 카드의 개수를 입력 받는다.
        int N = Integer.valueOf(br.readLine());
        Queue<Integer> myQueue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            myQueue.add(i + 1); // 큐에 카드를 넣는다.
        }

        while (myQueue.size() > 1) { // 큐에 카드가 1장 남을 때까지 반복
            myQueue.poll();            // 맨 위의 카드를 버린다.
            myQueue.add(myQueue.poll()); // 맨 위의 카드를 가장 아래의 카드 밑으로 이동시킨다.
        }
        System.out.println(myQueue.poll());
    }
}
