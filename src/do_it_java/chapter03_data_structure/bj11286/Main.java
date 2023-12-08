package do_it_java.chapter03_data_structure.bj11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * author         : matrix
 * date           : 2023-08-29
 * description    : 백준 11286 절댓값 힙
 * https://www.acmicpc.net/problem/11286
 */
public class Main {
    // 우선 수위 큐의 정렬 기준을 정의한다.
    static PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> {
        int absX = Math.abs(x);
        int absY = Math.abs(y);

        if (absX == absY) {
            return (x <= y) ? -1 : 1; // 절대 값이 같으면 음수 우선 정렬
        } else {
            return absX - absY; // 아니라면 절대 값이 작은 순으로 정렬
        }
    });
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 연산의 개수를 입력 받는다.
        int N = Integer.valueOf(br.readLine());

        // 연산의 개수 만큼 정수를 입력 받는다.
        for (int i = 0; i < N; i++) {
            int num = Integer.valueOf(br.readLine());
            if (num == 0) { // 입력된 수가 0이면 배열을 출력하고
                output();
            } else { // 0이 아니면 배열에 넣는다.
                input(num);
            }
        }
        System.out.println(sb);
    }

    static void output() {
        if (queue.isEmpty()) {
            sb.append(0).append("\n");
        } else {
            sb.append(queue.poll()).append("\n");
        }
    }

    static void input(int num) {
        queue.add(num);
    }
}
