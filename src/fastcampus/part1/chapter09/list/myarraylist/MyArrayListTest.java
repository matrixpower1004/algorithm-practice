package fastcampus.part1.chapter09.list.myarraylist;

import java.util.stream.IntStream;

public class MyArrayListTest {

    public static void main(String[] args) {
        // size를 지정하지 않는다면 DEFAULT_CAPACITY 사이즈로 생성된다.
        MyArrayList<Integer> list = new MyArrayList<>(4);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // 처음 지정한 크기를 넘으면 배열의 caoacity가 자동으로 증가되어야 한다.
        list.add(5);
        System.out.println(list);

        // 특정 인덱스의 값을 변경
        list.set(2, -1);
        System.out.println(list);

        // 특정 위치에 데이터를 삽입
        list.insert(3, 99);
        System.out.printf("Size: %d, %s%n", list.size(), list);

        // 특정 위치의 데이터를 삭제
        list.remove(3);
        System.out.printf("Size: %d, %s%n", list.size(), list);

        // 특정 위치의 데이터를 get
        IntStream.range(0, list.size())
            .forEach(i -> System.out.printf("Index: %d, value: %d%n", i, list.get(i)));
    }
}
