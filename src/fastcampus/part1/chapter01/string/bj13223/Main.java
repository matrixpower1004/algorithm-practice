package fastcampus.part1.chapter01.string.bj13223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * author         : Jisang Lee
 * date           : 2023-10-20
 * description    : 백준 13223 소금 폭탄
 * https://www.acmicpc.net/problem/13223
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] now = br.readLine().split(":");
        String[] bomb = br.readLine().split(":");

        int[] ansTime = new int[3];
        for (int i = 0; i < 3; i++) {
            ansTime[i] = Integer.valueOf(bomb[i]) - Integer.valueOf(now[i]);
        }

        if (ansTime[2] < 0) {
            ansTime[2] += 60;
            ansTime[1]--;
        }

        if (ansTime[1] < 0) {
            ansTime[1] += 60;
            ansTime[0]--;
        }

        if (ansTime[0] < 0) {
            ansTime[0] += 24;
        }

        System.out.printf("%02d:%02d:%02d", ansTime[0], ansTime[1], ansTime[2]);

        /**
         * 단일 단위(초)로 변환 후 계산한 로직.
         */
//        int[] nowTime = new int[3];
//        int[] bombTime = new int[3];
//        for (int i = 0; i < 3; i++) {
//            nowTime[i] = Integer.valueOf(now[i]);
//            bombTime[i] = Integer.valueOf(bomb[i]);
//        }
//
//        int nowTimeAmount = nowTime[0] * 3600 + nowTime[1] * 60 + nowTime[2];
//        int bombTimeAmount = bombTime[0] * 3600 + bombTime[1] * 60 + bombTime[2];
//        int ansTimeAmount = bombTimeAmount - nowTimeAmount;
//        if (ansTimeAmount <= 0) {
//            ansTimeAmount += 24 * 3600; // 음수인 경우 하루(24시간)을 더해준다.
//        }
//
//        int ansHour = ansTimeAmount / 3600;
//        int ansMinute = (ansTimeAmount % 3600) / 60;
//        int ansSecond  = ansTimeAmount % 60;
//
//        System.out.printf("%02d:%02d:%02d", ansHour, ansMinute, ansSecond);
    }

}
