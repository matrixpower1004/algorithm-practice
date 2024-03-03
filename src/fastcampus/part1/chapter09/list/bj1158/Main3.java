package fastcampus.part1.chapter09.list.bj1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * 백준 1158 요세푸스 문제: https://www.acmicpc.net/problem/1158
 */
class MyLinkedList {

    private int size = 0;
    private Node firstNode = null;
    private Node lastNode = null;

    public static class Node {
        int item;
        Node next;

        Node(int element, Node next) {
            this.item = element;
            this.next = next;
        }
    }

    // 문제 풀이에 필요한 add와 remove만 구현한다.
    public void add(int element) {
        // 마지막 노드에 추가하므로 next = null
        Node newNode = new Node(element, null);
        if (size == 0) { // firstNode가 null 일 때(최초 삽입)
            firstNode = newNode;
        } else { // firstNode가 null이 아닐 때만 lastNode의 next를 새로 만든 노드에 연결한다.
            lastNode.next = newNode;
        }
        lastNode = newNode;
        size++;
    }

    public int remove(int idx) {
        // 인덱스의 앞에 위차한 노드를 찾아야 해당 노드를 삭제하고 이후의 노드를 연겷할 수 있다.
        Node prevNode = null;
        Node targetNode = firstNode; // prevNode의 다음일 테니까 firstNode에서 출발한다.
        for (int i = 0; i < idx; i++) {
            prevNode = targetNode;
            targetNode = targetNode.next;
        }
        if (idx == 0) { // 제일 앞에 있는 노드를 삭제할 때
            firstNode = firstNode.next;
        } else {
            prevNode.next = targetNode.next;
            if (prevNode.next == null) { // 제일 마지막 노드가 삭제되는 경우
                lastNode = prevNode;
            }
        }
        size--;
        return targetNode.item;
    }

    public int size() {
        return size;
    }
}

public class Main3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        MyLinkedList survivors = new MyLinkedList();
        for (int i = 1; i <= N; i++) {
            survivors.add(i);
        }
        int[] ans = new int[N];
        // K번재 사람이 누군이지 계산헤서 그 사람을 제거하고 다음 인덱스 계산에 사용할 수 있도록 index를 유지한다.
        int currentIndex = 0;
        for (int i = 0; i < N; i++) {
            currentIndex = (currentIndex + K - 1) % survivors.size();
            ans[i] = survivors.remove(currentIndex);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(Arrays.stream(ans)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(", ")));
        sb.append(">");
        System.out.println(sb);
    }
}
