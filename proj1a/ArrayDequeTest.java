public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(10);
        deque.addFirst(20);
        deque.printDeque();
        deque.addLast(30);
        deque.addLast(40);
        deque.printDeque();
        deque.addLast(30);
        deque.addLast(30);
        deque.addLast(40);
        deque.addLast(40);
        deque.printDeque();
        deque.addLast(40);
        deque.addLast(40);
        deque.printDeque();
        deque.removeLast();
        deque.removeFirst();
        deque.printDeque();
    }
}
