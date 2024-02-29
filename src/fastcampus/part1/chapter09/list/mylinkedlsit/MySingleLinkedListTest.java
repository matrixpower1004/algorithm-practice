package fastcampus.part1.chapter09.list.mylinkedlsit;

import fastcampus.part1.chapter09.list.mylinkedlsit.MySingleLinkedList.Node;

public class MySingleLinkedListTest {

    public static void main(String[] args) {
        MySingleLinkedList<Integer> list = new MySingleLinkedList<>();

        // LinkedList의 add: O(1)
        list.add(1);            // [1]
        list.add(2);            // [1, 2]
        list.add(3);            // [1, 2, 3]

        // LinkedList의 특정 위치값에 대한 add: O(N)
        list.insert(0, 4);      // [4, 1, 2, 3]
        list.insert(3, 5);      // [4, 1, 2, 5, 3]

        // LinkedList의 특정 위치값에 대한 set: O(N)
        list.set(2, -1);        // [4, 1, -1, 5, 3]
        System.out.println(list);

        // LinkedList.java는 ListIterator를 사용해 순차 탐색을 지원하지만
        // 이 클래스는 Node 접근자를 제공하여 직접 조작하는 형태로 사용합니다.
        // ListIterator와는 달리 실제 Node를 가리킵니다.
        Node<Integer> currentNode = list.getFirstNode();

        // 2칸 뒤 Node로 이동 후 현재 노드 정보를 출력하는 예제입니다.
        int currentIndex = 0;   // index: 0, value: 4
        for (int i = 0; i < 2; i++) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        // index: 2, value: -1
        System.out.printf("index: %d, value: %d\n", currentIndex, currentNode.item);

        // LinkedList의 특정 위치값에 대한 get: O(N)
        System.out.printf("index: %d, value: %d\n", 4, list.get(4));

        // LinkedList의 순차 접근 중 특정 노드에 대한 remove: O(1)
        list.removeNext(currentNode);
        System.out.println(list);   // [4, 1, -1, 3]

        // LinkedList의 특정 위치값에 대한 remove: O(N)
        list.remove(3);             // [4, 1, -1];
        int size = list.size();     // 3
        System.out.printf("Size: %d, %s", size, list);
    }

}
