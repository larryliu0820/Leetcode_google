import java.util.LinkedList;
import java.util.List;

/**
 * Created by Larry Liu on 11/21/2017.
 * 56. Merge Intervals
 */
public class p056 {
    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort((a, b)->a.start-b.start);
        List<Interval> res = new LinkedList<>();
        if (intervals.size() == 0) return res;
        Interval itr = intervals.get(0);
        for (Interval i: intervals) {
            if (i.start <= itr.end) {
                itr.end = Math.max(i.end, itr.end);
            } else {
                res.add(itr);
                itr = i;
            }
        }
        res.add(itr);
        return res;
    }
}
