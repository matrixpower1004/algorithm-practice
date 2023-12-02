package do_it_java.data_structure.bj11003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * author         : matrix
 * date           : 2023-08-25
 * description    :
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N 과 L을 입력받는다.
        int N = Integer.valueOf(st.nextToken());
        int L = Integer.valueOf(st.nextToken());

        Node[] arr = new Node[N];
        st = new StringTokenizer(br.readLine());

        // N개의 수를 입력 받아서 배열에 저장한다.
        for (int i = 0; i < N; i++) {
            arr[i] = new Node(i, Integer.valueOf(st.nextToken()));
        }

        Deque<Node> myDeque = new ArrayDeque<>(L);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            Node now = arr[i];

            // 새로운 값이 들어올 때마다 정렬 대신 현재 수보다 큰 값을 덱에서 제거하여 시간 복잡도를 줄인다.
            while (!myDeque.isEmpty() && myDeque.getLast().value > now.value) {
                myDeque.removeLast();
            }

            // 새로운 값을 덱에 삽입한다.
            myDeque.addLast(now); // index, value

            // 윈도우 범위에서 벗어난 값은 덱에서 제거한다.
            if (myDeque.getFirst().index <= i - L) {
                myDeque.removeFirst();
            }
            // 새로운 값보다 큰 값은 모두 덱에서 제거되었으므로 덱의 첫번재 값을 출력하기 위해 버퍼에 넣는다.
            sb.append(myDeque.getFirst().value).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}

class Node {
    int index;
    int value;

    public Node(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
