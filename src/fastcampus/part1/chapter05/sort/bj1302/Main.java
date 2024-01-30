package fastcampus.part1.chapter05.sort.bj1302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 1302 베스트셀러
 * https://www.acmicpc.net/problem/1302
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        String[] books = new String[N];

        for (int i = 0; i < N; i++) {
            books[i] = br.readLine();
        }

        Arrays.sort(books);

        String maxTitle = books[0];
        int maxCount = 1;
        int currentCount = 1;
        for (int i = 1; i < N; i++) {
            if (!books[i].equals(books[i - 1])) { // 현재 인덱스의 문자와 바로 앞 인덱스 문자가 다르면 현재 카운트 초기화
                currentCount = 0;
            }
            currentCount++;
            if (maxCount < currentCount ||
                (maxCount == currentCount && books[i].compareTo(maxTitle) < 0)) {
                maxCount = currentCount;
                maxTitle = books[i];
            }
        }
        System.out.println(maxTitle);
    }
}
