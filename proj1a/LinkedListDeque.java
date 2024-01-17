public class LinkedListDeque<T> {
    private class ListNode {
        private T item;
        private ListNode prev;
        private ListNode next;

        public ListNode(T item) {
            this(item, null, null);
        }

        public ListNode(T item, ListNode prev, ListNode next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private ListNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new ListNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        ListNode node = new ListNode(item, sentinel, sentinel.next);
        sentinel.next.prev = node;
        sentinel.next = node;
        size++;
    }

    public void addLast(T item) {
        ListNode node = new ListNode(item, sentinel.prev, sentinel);
        sentinel.prev.next = node;
        sentinel.prev = node;
        size++;
    }

    public T removeFirst() {
        ListNode removeItem = sentinel.next;
        removeItem.next.prev = sentinel;
        sentinel.next = removeItem.next;
        if (size > 0) {
            size--;
        }
        return removeItem.item;
    }

    public T removeLast() {
        ListNode removeItem = sentinel.prev;
        removeItem.prev.next = sentinel;
        sentinel.prev = removeItem.prev;
        if (size > 0) {
            size--;
        }
        return removeItem.item;
    }

    /**
     * Check whether the deque is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of items in the deque.
     */
    public int size() {
        return size;
    }

    /**
     * Returns the ith item in the deque. if no such item exists, returns null.
     */
    public T get(int index) {
        ListNode p = sentinel.next;
        int k = 0;
        while (k < index) {
            p = p.next;
            if (p == sentinel) {
                return null;
            }
            k++;
        }
        return p.item;
    }

    private T getRecursiveHelper(int index, ListNode node) {
        if (index == 0) {
            return node.item;
        }
        if (node.next == sentinel) {
            return null;
        }
        return getRecursiveHelper(index - 1, node.next);
    }

    public T getRecursive(int index) {
        return getRecursiveHelper(index, sentinel.next);
    }

    public void printDeque() {
        ListNode p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }
}
