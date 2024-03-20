package fastcampus.part2.chapter1.stack.bj1935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1935 후위표기식 2: https://www.acmicpc.net/problem/1935
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int[] value = new int[N];
        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

        double[] calc = new double[input.length()];
        int index = -1;
        for (char ch : input.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                calc[++index] = value[ch - 'A'];
            } else {
                double result = calc[index - 1];
                switch (ch) {
                    case '+':
                        result += calc[index];
                        break;
                    case '-':
                        result -= calc[index];
                        break;
                    case '*':
                        result *= calc[index];
                        break;
                    case '/':
                        result /= calc[index];
                        break;
                }
                calc[--index] = result;
            }
        }
        System.out.printf("%.2f%n", calc[0]);
    }
}
