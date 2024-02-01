import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDequeTest {
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

    @Test
    public void testRemove() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.removeLast();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);
        deque.addLast(6);
        deque.addLast(7);
        deque.addLast(8);
        assertEquals(8, deque.size());
        assertEquals(3, deque.get(2).intValue());
        assertFalse(deque.isEmpty());
        deque.addFirst(9);
        deque.addLast(10);
        deque.addLast(11);
        deque.addLast(12);
        deque.addLast(13);
        deque.addLast(14);
        deque.addLast(15);
        deque.addLast(16);
        assertEquals(16, deque.size());
        assertEquals(16, deque.get(15).intValue());
        assertFalse(deque.isEmpty());
        assertEquals(16, deque.removeLast().intValue());
        for (int i = 0; i < 15; i++) {
            deque.removeLast();
        }
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testRemove1() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.removeLast();
        deque.removeLast();
        assertEquals(0, deque.size());
    }

    @Test
    public void testGet1() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(10);
        deque.addLast(5);
        deque.addFirst(10);
        assertEquals(10, deque.removeFirst().intValue());
    }

    @Test
    public void testGet2() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        deque.get(0);
        deque.addLast(2);
        deque.removeLast();
        deque.addFirst(4);
        deque.removeFirst();
        deque.removeLast();
        deque.addFirst(7);
        deque.addLast(8);
        assertEquals(8, deque.get(1).intValue());
    }

}
