package fastcampus.part1.chapter05.sort.bj1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 백준 1931 회의실 배정
 * https://www.acmicpc.net/problem/1931
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        Meeting[] meetings = new Meeting[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.valueOf(st.nextToken());
            int end = Integer.valueOf(st.nextToken());
            meetings[i] =  new Meeting(start, end);
        }

        // 회의 종료 시간이 빠른 순서로 정렬
        Arrays.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if (o1.end == o2.end) {
                    return o1.start - o2.start;
                }
                return o1.end - o2.end;
            }
        });
        int count = 0;
        int ended = 0;
        for (int i = 0; i < N; i++) {
            if (ended <= meetings[i].start) {
                ended = meetings[i].end;
                count++;
            }
        }
        System.out.println(count);
    }
}

class Meeting {

    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

