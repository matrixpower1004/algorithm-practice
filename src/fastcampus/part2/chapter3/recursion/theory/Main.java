package fastcampus.part2.chapter3.recursion.theory;

/**
 * 재귀 함수 이론 #1
 */
public class Main {

    public static void main(String[] args) {
        PrintNumber pn = new PrintNumber();
        System.out.println("1부터 10까지 오름차순 출력");
        pn.asc(10);

        System.out.println();

        System.out.println("1부터 10까지 내림차순 출력");
        pn.desc(10);
    }
}

class PrintNumber {

    public void asc(int n) {
        if (n == 0) {
            return;
        }
        asc(n - 1);
        System.out.printf("%d ", n);
    }

    public void desc(int n) {
        if (n == 0) {
            return;
        }
        System.out.printf("%d ", n);
        desc(n - 1);
    }
}