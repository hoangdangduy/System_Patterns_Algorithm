package _10_2_6;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class XORLinkedList {
    private static Node head;
    private static Node tail;
    private static Map<Integer, Node> map = new HashMap<>();

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
        Node nodeBefore = null;
        while (current != null) {
            if (Objects.equals(current.getValue(), value)) {
                Node nodeNext = map.get(current.getNp() ^ getAddress(nodeBefore));
                Node nodeNextNext = nodeNext == null ? null : map.get(getAddress(current) ^ nodeNext.getNp());
                Node nodeBeforeBefore = nodeBefore == null ? null : map.get(getAddress(current) ^ getNP(nodeBefore));
                map.remove(getAddress(current));
                if (nodeNext != null) {
                    nodeNext.setNp(getAddress(nodeNextNext) ^ getAddress(nodeBefore));
                }
                if (nodeBefore != null) {
                    nodeBefore.setNp(getAddress(nodeBeforeBefore) ^ getAddress(nodeNext));
                }

                if (current == head) {
                    head = nodeNext;
                }
                if (current == tail) {
                    tail = nodeBefore;
                }
            }

            if (current == head) {
                nodeBefore = current;
                current = map.get(current.getNp());
            } else {
                int address = getAddress(nodeBefore);
                nodeBefore = current;
                current = map.get(current.getNp() ^ address);
            }
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

