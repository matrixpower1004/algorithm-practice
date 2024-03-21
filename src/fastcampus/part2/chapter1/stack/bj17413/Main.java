package fastcampus.part2.chapter1.stack.bj17413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 17413 단어 뒤집기 2: https://www.acmicpc.net/problem/17413
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int size = input.length;
        while (index < size) {
            if (input[index] == '<') {
                while (input[index] != '>') {
                    sb.append(input[index++]);
                }
                sb.append(input[index++]);
            } else {
                int nextIndex = index;
                while (nextIndex < size && input[nextIndex] != ' ' && input[nextIndex] != '<') {
                    nextIndex++;
                }
                for (int i = nextIndex - 1; i >= index; i--) {
                    sb.append(input[i]);
                }
                if (nextIndex < size && input[nextIndex] == ' ') {
                    sb.append(" ");
                    nextIndex++;
                }
                index = nextIndex;
            }
        }
        System.out.println(sb);
    }
}
