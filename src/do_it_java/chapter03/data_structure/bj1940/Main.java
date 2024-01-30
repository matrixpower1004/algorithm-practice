package do_it_java.chapter03.data_structure.bj1940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * author         : matrix
 * date           : 2023-08-22
 * description    : 백준 1940 주몽의 명령
 * https://www.acmicpc.net/problem/1940
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.valueOf(br.readLine()); // 재료의 개수
        int N = Integer.valueOf(br.readLine()); // 갑옷을 만드는데 필요한 수

        int[] materials = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) { // 재료들이 가진 고유한 번호를 입력받아 배열에 저장.
            materials[i] = Integer.valueOf(st.nextToken());
        }

        // 포인터를 이용한 연산을 하기 쉽도록 배열을 정렬한다.
        Arrays.sort(materials);

        int start_index = 0;    // 시작 포인터
        int end_index = M - 1;  // 종료 포인터
        int answer = 0;

        while (start_index < end_index) {
            if (materials[start_index] + materials[end_index] == N) {
                // 두 수의 합이 N과 같은면 갑옷을 만들 수 있는 개수를 1 증가시키고, 시작 인덱스는 1증가, 종료 인덱스틑 1 감소 시킨다.
                answer++;
                start_index++;
                end_index--;
            } else if (materials[start_index] + materials[end_index] < N) {
                // 두 수의 합이 N보다 작으면 시작 인덱스를 1 증가시킨다.
                start_index++;
            } else {
                // 두 수의 합이 N보다 크면 종료 인덱스를 1 감소 시칸다.
                end_index--;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
