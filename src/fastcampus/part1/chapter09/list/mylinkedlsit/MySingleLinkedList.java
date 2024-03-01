package fastcampus.part1.chapter09.list.mylinkedlsit;

public class MySingleLinkedList<E> {

    private int size = 0;
    private Node<E> firstNode = null;
    private Node<E> lastNode = null;

    public static class Node<E> {

        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element, firstNode);
        if (size == 0) {
            lastNode = newNode;
        }
        firstNode = newNode;
        size++;
    }

    public void add(E element) {
        Node<E> newNode = new Node<>(element, null);
        if (size == 0) {
            firstNode = newNode;
        } else {
            lastNode.next = newNode;
        }
        lastNode = newNode;
        size++;
    }

    public Node<E> getNode(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Index: " + size + ", Szie: " + size);
        }
        Node<E> currentNode = firstNode;
        for (int i = 0; i < idx; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    public E get(int idx) {
        return getNode(idx).item;
    }

    public void set(int idx, E element) {
        Node<E> targetNode = getNode(idx);
        targetNode.item = element;
    }

    public void insert(Node<E> prevNode, E element) {
        Node<E> newNode = new Node<E>(element, prevNode.next);
        prevNode.next = newNode;
        if (newNode.next == null) {
            lastNode = newNode;
        }
        size++;
    }

    public void insert(int idx, E element) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Index: " + size + ", Szie: " + size);
        }
        if (idx == 0) {
            addFirst(element);
        } else if (idx == size) {
            add(element);
        } else {
            insert(getNode(idx - 1), element);
        }
    }

    public void removeFirst() {
        if (firstNode != null) {
            firstNode = firstNode.next;
            if (firstNode == null) { // 삭제 후 데이터가 없는 경우
                lastNode = null;
            }
            size--;
        }
    }

    public void removeNext(Node<E> prevNode) {
        if (prevNode.next != null) {
            prevNode = prevNode.next.next;
            if (prevNode.next == null) { // lastNode인지 체크
                lastNode = prevNode;
            }
            size--;
        }
    }

    public void remove(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Index: " + size + ", Szie: " + size);
        }
        if (idx == 0) {
            removeFirst();
        }
    }

    public Node<E> getFirstNode() {
        return firstNode;
    }

    public Node<E> getLastNode() {
        return lastNode;
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> currentNOde = firstNode;
        sb.append("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(currentNOde.item);
            currentNOde = currentNOde.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
