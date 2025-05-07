package _10_2_6;

import java.util.HashMap;
import java.util.Map;

public class XORLinkedList {
    private Node head;
    private Node tail;
    private Map<Integer, Node> map = new HashMap<>();

    public void insert(String value) {
        Node newNode = new Node(value);

        newNode.setNp(getAddress(head));

        map.put(getAddress(newNode), newNode);
        if (head == null) {
            tail = newNode;
        } else {
            head.setNp(head.getNp() ^ getAddress(newNode));
        }
        head = newNode;
    }

    private int getAddress(Node node) {
        return node == null ? 0 : System.identityHashCode(node);
    }

}
