package fastcampus.part1.chapter05_sort.bj10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 10814 나이순 정렬
 * https://www.acmicpc.net/problem/10814
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        Member[] members = new Member[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.valueOf(st.nextToken());
            String name = st.nextToken();
            members[i] = new Member(age, name, i + 1);
        }

        Arrays.sort(members, (o1, o2) -> {
            if (o1.age == o2.age) {
                return o1.sequence - o2.sequence;
            }
            return o1.age - o2.age;
        });

        StringBuilder sb = new StringBuilder();
        for (Member member : members) {
            sb.append(member.age).append(" ").append(member.name).append("\n");
        }
        System.out.println(sb);
    }
}

class Member {
    int age;
    String name;
    int sequence;

    public Member(int age, String name, int sequence) {
        this.age = age;
        this.name = name;
        this.sequence = sequence;
    }
}
