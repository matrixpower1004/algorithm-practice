package do_it_java.data_structure.bj1546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * author         : matrix
 * date           : 2023-08-18
 * description    :
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.valueOf(br.readLine());

        String[] nums = br.readLine().split(" ");
        int[] numbers = new int[count];

        int max = 0;
        long sum = 0l;
        // 문자열을 정수배열로 변환하면서 max 값을 저장
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = Integer.valueOf(nums[i]);
            sum += numbers[i];
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        // 변환점수의 평균을 구하는 식(점수를 A, B, C라고 가정)
        // (A / M * 100 + B / M * 100 + C / M * 100) / 3 = (A + B + C) * 100 / M /3
        double avg = (sum * 100.0) / max / numbers.length;

        System.out.println(avg);
    }

}

