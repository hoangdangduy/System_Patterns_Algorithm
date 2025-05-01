package _10_2_2;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();

        System.out.println("Is stack empty? " + stack.isEmpty());

        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println("Top element: " + stack.peak());

        System.out.println("Stack size: " + stack.size());

        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        System.out.println("Top element after pops: " + stack.peak());

        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
