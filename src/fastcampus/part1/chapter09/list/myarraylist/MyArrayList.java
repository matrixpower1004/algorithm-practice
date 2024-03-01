package fastcampus.part1.chapter09.list.myarraylist;

import java.util.Arrays;

public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object[] data;

    public MyArrayList(int initCapacity) {
        data = new Object[initCapacity];
    }

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public void add(E element) {
        // 데이터를 삽입하기 전에 현재 사이즈가 capacity와 같은지 체크한다.
        if (size == data.length) {
            growCapacity();
        }
        data[size++] = element;
    }

    // 현재 capacity의 1.5배 만큼 크기를 늘려준다
    private void growCapacity() {
        int newCapacity = data.length + (data.length >> 1);
        data = Arrays.copyOf(data, newCapacity);
    }

    public E get(int idx) {
        // index의 범위가 0보다 작거나 size보다 큰지 확인한다.
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Index: " + idx + ", Size: " + size);
        }
        return (E) data[idx];
    }

    public void set(int idx, E element) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Index: " + idx + ", Size: " + size);
        }
        data[idx] = element;
    }

    public void insert(int idx, E element) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Index: " + idx + ", Size: " + size);
        }
        if (size == data.length) {
            growCapacity();
        }
        int copyLength = size - idx;
        //  원본 배열, 원보 배열의 시작 index, 대상 배열, 대상 배열의 시작 인덱스, 길이
        System.arraycopy(data, idx, data, idx + 1, copyLength);
        data[idx] = element;
        size++;
    }

    public void remove(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Index: " + idx + ", Size: " + size);
        }
        int copyLength = data.length - idx - 1;
        System.arraycopy(data, idx + 1, data, idx, copyLength);
        size--;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(data[i]);
        }
        sb.append("]");
        return sb.toString();
    }

}
