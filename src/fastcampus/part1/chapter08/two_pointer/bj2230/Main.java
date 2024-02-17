
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2230 수 고르기: https://www.acmicpc.net/problem/2230
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        // Ai가 증가하는 방향으로 이동하면
        // 차가 M 이상이 되는 쌍이 되는 Aj의 경계도 증가하는 방향으로 이동한다.
        int ansDiff = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        while (right < N) {
            int diff = arr[right] - arr[left];
            if (diff < M) {
                right++;
            } else if (diff == M) {
                ansDiff = diff;
                break;
            } else {
                ansDiff = Math.min(ansDiff, diff);
                left++;
            }
        }
        System.out.println(ansDiff);
    }
}
