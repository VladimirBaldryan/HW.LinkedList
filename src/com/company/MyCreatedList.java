package com.company;

public class MyCreatedList implements MyList {
    Node first;
    Node last;
    int size;

    public MyCreatedList() {
        this.first = null;
    }

    @Override
    public Object get(int index) {
        Node temp = first;
        if (index == 0) {
            return temp.value;
        } else {
            if (index >= size) {
                throw new IllegalArgumentException("Index out of size");
            } else {
                for (int i = 1; i < size; i++) {
                    temp = temp.next;
                    if (i == index) {
                        return temp.value;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void add(Object obj) {
        Node node = new Node((Integer) obj);
        if (first == null) {
            first = node;
            last = node;
            size++;
        } else {
            last.next = node;
            last = last.next;
            size++;
        }
    }

    @Override
    public void remove(int index) {
        Node temp = first;
        if (index == 0) {
            first = temp.next;
            size--;
        } else {
            if (index >= size) {
                throw new IllegalArgumentException("Index out of size");
            } else {
                for (int i = 1; i < size - 1; i++) {
                    if (i == index) {
                        temp.next = temp.next.next;
                    }
                    temp = temp.next;
                }
                size--;
            }
        }
    }

    @Override
    public boolean remove(Object obj) {
        Node temp = first;
        if (obj.equals(first)) {
            first = temp.next;
            size--;
            return true;
        } else {
            for (int i = 1; i < size - 1; i++) {
                if (get(i).equals(obj)) {
                    temp.next = temp.next.next;
                }
                temp = temp.next;
            }
            size--;
            return true;
        }
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object obj) {
        for (int i = 0; i < size - 1; i++) {
            if (get(i).equals(obj)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node current = first;
        for (int i = 0; i < size; i++) {
            result.append(current.value);
            if (i < size - 1) {
                result.append(", ");
            }
            current = current.next;
        }
        result.append("]");
        return result.toString();
    }
}
