package _10_2_6;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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


    public void traverse() {
        Node current = head;
        if (current == null) {
            System.out.println("Don't nothing");
            return;
        }

        Node nodeBefore = null;
        while (current != null) {
            System.out.println(current.getValue());
            int addressBefore = getAddress(nodeBefore);
            nodeBefore = current;
            current = map.get(current.getNp() ^ addressBefore);
        }
    }

    public void delete(String value) {
        Node current = head;
        Node previous = null;

        while (current != null) {
            Node next = map.get(current.getNp() ^ getAddress(previous));

            if (Objects.equals(current.getValue(), value)) {
                Node nextNext = next == null ? null : map.get(getAddress(current) ^ next.getNp());
                Node previousPrevious = previous == null ? null : map.get(getAddress(current) ^ previous.getNp());

                if (next != null) {
                    next.setNp(getAddress(nextNext) ^ getAddress(previous));
                }
                if (previous != null) {
                    previous.setNp(getAddress(previousPrevious) ^ getAddress(next));
                }

                if (current == head) {
                    head = next;
                }
                if (current == tail) {
                    tail = previous;
                }

                map.remove(getAddress(current));
            } else {
                previous = current;
            }

            current = next;
        }
    }

    public int getNP(Node node) {
        return node == null ? 0 : node.getNp();
    }

    public static void main(String[] args) {
        XORLinkedList xorLinkedList = new XORLinkedList();

        System.out.println("insert: A, B, C, D, A");
        xorLinkedList.insert("A");
        xorLinkedList.insert("B");
        xorLinkedList.insert("C");
        xorLinkedList.insert("D");
        xorLinkedList.insert("A");

        System.out.println();
        System.out.println("traverse: ");
        xorLinkedList.traverse();

        System.out.println();
        System.out.println("delete: B");
        xorLinkedList.delete("B");

        System.out.println();
        System.out.println("traverse: ");
        xorLinkedList.traverse();

        System.out.println();
        System.out.println("delete: D");
        xorLinkedList.delete("D");

        System.out.println();
        System.out.println("traverse: ");
        xorLinkedList.traverse();

        System.out.println();
        System.out.println("delete: A");
        xorLinkedList.delete("A");

        System.out.println();
        System.out.println("traverse: ");
        xorLinkedList.traverse();

        System.out.println();
        System.out.println("delete: C");
        xorLinkedList.delete("C");

        System.out.println();
        System.out.println("traverse: ");
        xorLinkedList.traverse();
    }
}

