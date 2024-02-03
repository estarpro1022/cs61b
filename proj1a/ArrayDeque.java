public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = items.length - 1;
        nextLast = 0;
    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(2 * size);
        }
        items[nextFirst] = item;
        nextFirst = decrement(nextFirst);
        size++;
    }

    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize(2 * size);
        }
        items[nextLast] = item;
        nextLast = increment(nextLast);
        size++;
    }

    @Override
    public T removeFirst() {
        // boundary case
        if (size == 0) {
            return null;
        }
        if (16 <= items.length && size <= 0.25 * items.length) {
            resize((int) (0.5 * items.length));
        }
        int removeIndex = increment(nextFirst);
        T removeItem = items[removeIndex];
        items[removeIndex] = null;
        nextFirst = increment(nextFirst);
        size--;
        return removeItem;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (16 <= items.length && size <= 0.25 * items.length) {
            resize((int) (0.5 * items.length));
        }
        int removeIndex = decrement(nextLast);
        T removeItem = items[removeIndex];
        items[removeIndex] = null;
        nextLast = decrement(nextLast);
        size--;
        return removeItem;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T get(int index) {
        int itemIndex = increment(nextFirst);
        int resIndex = itemIndex + index;
        if (resIndex >= items.length) {
            return items[resIndex - items.length];
        }
        return items[resIndex];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        if (size == 0) {
            return;
        }
        int begin = increment(nextFirst);
        int end = decrement(nextLast);
        if (begin < end) {
            for (int i = begin; i <= end; i++) {
                System.out.print(items[i] + " ");
            }
        } else {
            for (int i = begin; i <= items.length - 1; i++) {
                System.out.print(items[i] + " ");
            }
            for (int i = 0; i <= end; i++) {
                System.out.print(items[i] + " ");
            }
        }
        System.out.println();
    }

    private void resize(int newSize) {
        T[] res = (T[]) new Object[newSize];
        int begin = increment(nextFirst);
        int end = decrement(nextLast);
        if (begin < end) {
            for (int i = begin; i <= end; i++) {
                res[i - begin] = items[i];
            }
        } else {
            for (int i = begin; i <= items.length - 1; i++) {
                res[i - begin] = items[i];
            }
            for (int i = 0; i <= end; i++) {
                res[i + (items.length - begin)] = items[i];
            }
        }
        nextFirst = res.length - 1;
        nextLast = size;
        items = res;
    }

    private int decrement(int cur) {
        if (cur == 0) {
            cur = items.length;
        }
        return cur - 1;
    }

    private int increment(int cur) {
        if (cur == items.length - 1) {
            cur = -1;
        }
        return cur + 1;
    }
}
