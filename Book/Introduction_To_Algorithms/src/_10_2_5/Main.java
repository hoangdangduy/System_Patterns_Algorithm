package _10_2_5;

public class Main {
    public static void main(String[] args) {
        LinkedList node = new LinkedList("A", null);
        LinkedList node1 = new LinkedList("B", node);
        LinkedList node2 = new LinkedList("C", node1);

        LinkedList r = null;
        LinkedList c = node2;
        LinkedList c1;

        while (c != null) {
            c1 = c;
            c = c.getNext();
            c1.setNext(r);
            r = c1;
        }

        while (r != null) {
            System.out.println(r.getKey());
            r = r.getNext();
        }

    }
}
