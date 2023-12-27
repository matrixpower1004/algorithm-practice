package fastcampus.part1.chapter04_brute_force_simulation.bj2817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * author         : Jisang Lee
 * date           : 2023-12-20
 * description    : 백준 2817 ALPS식 투표
 * https://www.acmicpc.net/problem/2817
 */
public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.valueOf(br.readLine()); // 참가자들의 수
        int N = Integer.valueOf(br.readLine()); // 스태프의 수

        ArrayList<Staff> staffs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int votes = Integer.valueOf(st.nextToken());
            double ratio = (double)votes / X;
            if (ratio < 0.05) continue; // 5% 미만 정리
            Staff staff = new Staff(name, votes, 0);
            staffs.add(staff);
        }

        // Staff를 이름순으로 정렬한다.
        staffs.sort(Comparator.comparing(o -> o.name));

        // 1~14까지 나누어 준 값을 차곡차곡 저장해준다.
        ArrayList<Score> scores = new ArrayList<>();
        for (int i = 1; i <= 14; i++) {
            for (int j= 0; j < staffs.size(); j++) {
                double num = (double)staffs.get(j).votes / i; // 득표 수를 1~14까지 순서대로 나누어준다.
                Score score = new Score(j, num);
                scores.add(score);
            }
        }
        scores.sort((s1, s2) -> (int) (s2.score - s1.score)); // 점수의 역순으로 정렬

        // 정렬된 점수를 기준으로 1~14위까지 staff에게 칩을 하나씩 지급한다.
        for (int i = 0; i < 14; i++) {
            int index = scores.get(i).staffIndex;
            staffs.get(index).chip++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < staffs.size(); i++) {
            sb.append(staffs.get(i).name).append(" ").append(staffs.get(i).chip).append("\n");
        }
        System.out.println(sb);
    }
}

class Staff {
    String name;
    int votes;
    int chip;

    public Staff(String name, int votes, int chip) {
        this.name = name;
        this.votes = votes;
        this.chip = chip;
    }
}

class Score {

    int staffIndex;
    double score;

    public Score(int staffIndex, double score) {
        this.staffIndex = staffIndex;
        this.score = score;
    }
}
