package data_structure.bj11720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * author         : matrix
 * date           : 2023-08-18
 * description    : 백준 11720 숫자의 합 구하기 (https://www.acmicpc.net/problem/11720)
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.valueOf(br.readLine());
        String input = br.readLine();

        int sum = 0;

        for (int i = 0; i < input.length(); i++) {
            sum += Integer.valueOf(
                    Character.getNumericValue(input.charAt(i))
            ) ;
        }

        System.out.println(sum);
    }

}
