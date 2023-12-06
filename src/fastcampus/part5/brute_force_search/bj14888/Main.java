package fastcampus.part5.brute_force_search.bj14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * author         : Jisang Lee
 * date           : 2023-12-05
 * description    : 백준 14888 연산자 끼워넣기
 * https://www.acmicpc.net/problem/14888
 */
public class Main {

    private static int N, max, min;
    private static int[] nums, operators;
    private static StringBuilder sb = new StringBuilder();

    /**
     * 피 연신자 두개와 연산자가 주어졌을 때 계산해 주는 함수
     * @param operand1 현재까지 계산된 value 값.
     * @param operator 현재 연산자
     * @param operand2 새로 계산할 값
     * @return
     */
    private static int calculator(int operand1, int operator, int operand2) {
        // value, order[i], num[i+1]
        if (operator == 1) { // + 연산자 처리
            return operand1 + operand2;
        } else if (operator == 2) { // - 연산자 처리
            return operand1 - operand2;
        } else if (operator == 3) { // * 연산자 처리
            return operand1 * operand2;
        } else // / 연산자 처리
            return operand1 / operand2;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.valueOf(br.readLine());
        nums = new int[N + 1];
        operators = new int[5];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) { // 1 ~ N까지의 수열을 입력 받는다
            nums[i] = Integer.valueOf(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 4; i++) { // 각 Operator의 개수를 입력 받는다.
            operators[i] = Integer.valueOf(st.nextToken());
        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    private static void rec_func(int k, int value) {
        if (k == N) { // 모든 연산자들을 전부 나열하는 방법을 찾은 상태
            // 완성된 식에 맞게 계산을 해서 정답을 갱신하는 작업
            // 별도의 계산 절차없이 인자로 받은 value를 바로 정답에 갱신한다.
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else { // k 번째 연산자는 무엇을 선택할 것인가?
            // 4 가지의 연사자들 중에 뭘 쓸것인지 선택하고 재귀 호출하기
            for (int cand = 1; cand <= 4; cand++) {
                if (operators[cand] >= 1) { // operator의 cand번 연산자가 있는지 확인.
                    operators[cand]--; // 1 이상이면 사용할 수 있는 상태이므로 사용했다는 기록을 남기기 위해 연산자의 남은 사용 회수를 감소시킨다.
                    rec_func(k + 1, calculator(value, cand, nums[k + 1]));
                    // 재귀 호출이 완료되면 사용했던 변수들을 초기화 해준다.
                    operators[cand]++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        // 1번째 원소부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 탐색해줘
        rec_func(1, nums[1]); // 첫번재 연산자를 결정하기 전까지의 계산 결과는 첫번째 원소이다.
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
    }

}
