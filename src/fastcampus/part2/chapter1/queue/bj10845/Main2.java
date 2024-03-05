package fastcampus.part2.chapter1.queue.bj10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

/**
 * 백준 10845 큐: https://www.acmicpc.net/problem/10845
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        MyQueue<Integer> q = new MyQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] cmd = br.readLine().split(" ");
            switch (cmd[0]) {
                case "push":
                    int num = Integer.parseInt(cmd[1]);
                    q.enqueue(num);
                    break;
                case "pop":
                    sb.append(q.isEmpty() ? -1 : q.dequeue()).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    sb.append(q.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(q.isEmpty() ? -1 : q.getFront()).append("\n");
                    break;
                case "back":
                    sb.append(q.isEmpty() ? -1 : q.getRear()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}

class MyQueue<E> {

    private int size = 0;
    private Node<E> frontNode = null;
    private Node<E> rearNode = null;

    public static class Node<E> {

        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    // 제일 뒤에 원소 추가
    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element, null);
        if (size == 0) {
            frontNode = newNode;
        } else {
            rearNode.next = newNode;
        }
        rearNode = newNode;
        size++;
    }

    public E dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is Empty");
        }
        E item = frontNode.item;
        frontNode = frontNode.next;
        if (frontNode == null) {
            rearNode = null;
        }
        size--;
        return item;
    }

    public E getFront() {
        return frontNode.item;
    }

    public E getRear() {
        return rearNode.item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
