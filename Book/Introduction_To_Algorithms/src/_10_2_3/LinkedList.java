package _10_2_3;

public class LinkedList {
    private LinkedList link;
    private String key;

    public LinkedList(String key, LinkedList link) {
        this.key = key;
        this.link = link;
    }

    public LinkedList getLink() {
        return link;
    }

    public void setLink(LinkedList link) {
        this.link = link;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
