import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Larry Liu on 11/16/2017.
 * 346. Moving Average from Data Stream
 */
public class p346 {
    /** Initialize your data structure here. */
    int size;
    double total;
    Queue<Integer> q;
    public p346(int size) {
        this.size = size;
        total = 0;
        q = new LinkedList<>();
    }

    public double next(int val) {
        if (q.size() == size) {
            total -= q.poll();
        }
        total += val;
        q.offer(val);
        return total / q.size();
    }
}
