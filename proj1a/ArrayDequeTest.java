import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void testGet() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(10);
        deque.addLast(5);
        deque.addFirst(10);
        assertEquals(10, deque.removeFirst().intValue());
    }

    @Test
    public void testAddFirst() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(5);
        assertEquals(5, deque.removeFirst().intValue());
        assertTrue(deque.isEmpty());
        deque.addFirst(5);
        deque.addFirst(4);
        deque.addFirst(3);
        assertEquals(5, deque.get(2).intValue());
        assertEquals(4, deque.get(1).intValue());
        assertEquals(5, deque.removeLast().intValue());
        assertEquals(2, deque.size());
    }
}
