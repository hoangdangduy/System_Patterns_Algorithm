package _10_2_2;

import java.util.Objects;

public class Stack {
    private LinkedList stack;
    private int size = 0;

    public void push(String key) {
        stack = new LinkedList(key, stack);
        size++;
    }

    public String pop() {
        if (isEmpty()) {
            return null;
        }

        String key = stack.getKey();
        stack = stack.getNext();

        size--;
        return key;
    }

    public String peak() {
        return isEmpty() ? null : stack.getKey();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
