package do_it_java.data_structure.bj11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * author         : matrix
 * date           : 2023-08-19
 * description    : 백준 11659 구간 합 구하기 4
 * https://www.acmicpc.net/problem/11659
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        // 수의 개수 N 과 합을 구해야 하는 횟수 M 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int countsNo = Integer.valueOf(st.nextToken());
        int queriesNo = Integer.valueOf(st.nextToken());

        // 합배열 생성
        int[] sumArrays = new int[countsNo + 1]; // index 1부터 저장을 하므로 수의 개수 + 1을 해준다.
        sumArrays[0] = 0;
        st.hasMoreTokens();
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < countsNo + 1; i++) {
            sumArrays[i] = sumArrays[i - 1] + Integer.valueOf(st.nextToken());
        }

        // 구간 합 구하기
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < queriesNo; i++) {
            st = new StringTokenizer(br.readLine());
            int fromIndex = Integer.valueOf(st.nextToken());
            int toIndex = Integer.valueOf(st.nextToken());
            sb.append(sumArrays[toIndex] - sumArrays[fromIndex - 1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
