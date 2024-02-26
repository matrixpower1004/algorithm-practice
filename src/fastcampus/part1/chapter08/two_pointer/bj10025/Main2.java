package fastcampus.part1.chapter08.two_pointer.bj10025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 백준 10025 게으른 백곰: https://www.acmicpc.net/problem/10025
 */
public class Main2 {

    static class Bucket {
        int g;
        int x;
        public Bucket(int g, int x) {
            this.g = g;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 얼음 양동이의 개수
        int K = Integer.parseInt(st.nextToken()); // 좌우로 양동이까지 닿을 수 있는 거리
        Bucket[] buckets = new Bucket[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            buckets[i] = new Bucket(g, x);
        }
        Arrays.sort(buckets, Comparator.comparingInt(o -> o.x));

        int nextIndex = 0;
        int ans = 0;
        int prefixSum = 0;
        for (int i = 0; i < N; i++) {
            while (nextIndex < N && buckets[nextIndex].x - buckets[i].x <= 2 * K) {
                prefixSum += buckets[nextIndex++].g;
            }
            ans = Math.max(ans, prefixSum);
            prefixSum -= buckets[i].g;
        }
        System.out.println(ans);
    }
}
