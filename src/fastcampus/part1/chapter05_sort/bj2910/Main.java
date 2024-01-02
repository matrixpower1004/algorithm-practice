package fastcampus.part1.chapter05_sort.bj2910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 백준 2910 빈도 정렬
 * https://www.acmicpc.net/problem/2910
 */
public class Main {

    static class Message {

        int num;
        int sequence;

        public Message(int num, int sequence) {
            this.num = num;
            this.sequence = sequence;
        }
    }

    static class Frequency {

        int num;
        int count;
        int firstIndex;

        public Frequency(int num, int count, int index) {
            this.num = num;
            this.count = count;
            this.firstIndex = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int C = Integer.valueOf(st.nextToken());

        Message[] messages = new Message[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.valueOf(st.nextToken());
            messages[i] = new Message(input, i);
        }

        Arrays.sort(messages, Comparator.comparingInt(o -> o.num));

        Frequency[] frequencies = new Frequency[N];
        int frequencyIndex = 0;
        frequencies[frequencyIndex] = new Frequency(messages[0].num, 1, messages[0].sequence);
        for (int i = 1; i < N; i++) {
            if (messages[i].num != messages[i - 1].num) {
                frequencies[++frequencyIndex] = new Frequency(messages[i].num, 0, messages[i].sequence);
            }
            frequencies[frequencyIndex].count++;
        }

        // frequencies 배열은 N개만큼 생성되지 않을 수 있다.
        // toIndex는 포함되지 않기 때문에 +1을 해줘야 한다.
        // 1. 입력된 횟수가 많은 수가 제일 처음에 와야 한다.
        Arrays.sort(frequencies, 0, frequencyIndex + 1, (o1, o2) -> {
            if (o1.count == o2.count) {
                return o1.firstIndex - o2.firstIndex;
            }
            return o2.count - o1.count;
        });

        // 2. 입력된 횟수가 같다면 입력된 순서대로 정렬한다.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= frequencyIndex; i++ ) {
            while (frequencies[i].count-- > 0) {
                sb.append(frequencies[i].num).append(" ");
            }
        }
        System.out.println(sb);
    }
}
