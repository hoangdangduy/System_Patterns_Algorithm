package _10_2_3;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();

        System.out.println("Is queue empty? " + queue.isEmpty());

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        System.out.println("Front element: " + queue.peak());

        System.out.println("Queue size: " + queue.size());

        System.out.println("Is queue empty? " + queue.isEmpty());
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());

        System.out.println("Front element after dequeues: " + queue.peak());

        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}
