package _10_2_5;

public class LinkedList {
    private String key;
    private LinkedList next;

    public LinkedList(String key, LinkedList next) {
        this.key = key;
        this.next = next;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public LinkedList getNext() {
        return next;
    }

    public void setNext(LinkedList next) {
        this.next = next;
    }
}
