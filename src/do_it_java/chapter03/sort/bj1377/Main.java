package do_it_java.chapter03.sort.bj1377;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * author         : matrix
 * date           : 2023-09-01
 * description    : 백준 1377 버블 소트
 * https://www.acmicpc.net/problem/1377
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배열의 크기 N을 입력 받는다.
        int N = Integer.valueOf(br.readLine());
        PriorityQueue<Data> pq = new PriorityQueue<>();

        // 숫가 N개를 입력 받아 우선순위큐에 저장한다.
        for (int i = 0; i < N; i++) {
            pq.add(new Data(Integer.valueOf(br.readLine()), i));
            }

        int max = 0;
        //
        for (int i = 0; i < pq.size(); i++) {
            Data data = pq.poll();
            if (max < data.index - i) {
                max = data.index - i;
            }
        }
        // 내부 for문이 몇번째 돌았을 때 sort가 이루어지지 않았는지 표시해야 하므로 max 값에 +1을 해준다.
        System.out.println(max + 1);
    }
}
class Data implements Comparable<Data> {
    protected int value;
    protected int index;

    public Data(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Data o) {
        if (this.value == o.value) {
            return this.index - o.index;
        }
        return this.value - o.value;
    }
}
