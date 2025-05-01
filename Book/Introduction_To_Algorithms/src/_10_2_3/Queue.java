package _10_2_3;

public class Queue {
    private LinkedList head;
    private LinkedList tail;
    private int size;

    public void enqueue(String key) {
        LinkedList newNode = new LinkedList(key, null);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setLink(newNode);
            tail = newNode;
        }
        size++;
    }

    public String dequeue() {
        if (isEmpty()) {
            return null;
        }
        String key = head.getKey();
        head = head.getLink();
        size--;
        return key;
    }

    public String peak() {
        return isEmpty() ? null : head.getKey();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
