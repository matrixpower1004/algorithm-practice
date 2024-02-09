package fastcampus.part1.chapter07.parametric_search.bj1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1654 랜선 자르기: https://www.acmicpc.net/problem/1654
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lans = new int[K];
        long sum = 0;
        for (int i = 0; i < K; i++) {
            lans[i] = Integer.parseInt(br.readLine());
            sum += lans[i];
        }

        long left = 1; // 랜선의 길이는 2 ^ 31 - 1 보다 작거나 같은 자연수
        long right = sum / K; // sum / K 이상의 길이로 자를 경우는 존재하지 않는다.
        long ans = -1L;
        while (left <= right) {
            long mid = (left + right) / 2;
            // mid의  길이로 잘랐을 때 원하는 개수만큼 랜선을 만들 수 있나?
            if (calcCount(lans, mid) >= N)  {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }

    private static int calcCount(int[] lan, long cutLength) {
        int count = 0;
        for (int l : lan) {
            count += l / cutLength;
        }
        return count;
    }
}
