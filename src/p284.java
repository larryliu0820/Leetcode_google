import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Larry Liu on 11/22/2017.
 * 284. Peeking Iterator
 */
public class p284 implements Iterator<Integer> {
    Queue<Integer> buffer;
    Iterator<Integer> iterator;
    public p284(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        buffer = new LinkedList<>();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (buffer.isEmpty()) {
            Integer next = iterator.next();
            if (next == null) return null;
            buffer.offer(next);
        }
        return buffer.peek();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (buffer.isEmpty())
            return iterator.next();
        else
            return buffer.poll();
    }

    @Override
    public boolean hasNext() {
        return !buffer.isEmpty() || iterator.hasNext();
    }
}
