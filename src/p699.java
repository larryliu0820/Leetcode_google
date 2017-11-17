import java.util.LinkedList;
import java.util.List;

/**
 * Created by Larry Liu on 11/17/2017.
 * 699. Falling Squares
 */
public class p699 {
    class Interval {
        int start, end;
        int height;
        Interval(int s, int e, int h) {
            start = s;
            end = e;
            height = h;
        }
    }
    public List<Integer> fallingSquares(int[][] positions) {
        List<Interval> intervals = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        for (int[] pos: positions) {
            Interval newInterval = new Interval(pos[0], pos[0]+pos[1]-1, pos[1]);
            intervals = insertInterval(intervals, res, newInterval);
        }
        return res;
    }

    private List<Interval> insertInterval(List<Interval> intervals, List<Integer> res, Interval newInterval ) {
        List<Interval> temp = new LinkedList<>();
        int ind = 0;
        while (ind < intervals.size() && intervals.get(ind).end < newInterval.start) {
            temp.add(intervals.get(ind));
            ind++;
        }

        while (ind < intervals.size() && intervals.get(ind).start <= newInterval.end) {
            Interval curr = intervals.get(ind);
            if (curr.start < newInterval.start) {
                Interval copyCurr = new Interval(curr.start,newInterval.start - 1, curr.height);
                temp.add(copyCurr);
            }
            if (curr.end > newInterval.end) {
                Interval copyCurr = new Interval(newInterval.end + 1, curr.end, curr.height);
                temp.add(copyCurr);
            }
            newInterval.height = Math.max(newInterval.height, newInterval.end-newInterval.start+1+curr.height);
            ind++;
        }
        if (res.size() == 0) res.add(newInterval.height);
        else res.add(Math.max(res.get(res.size()-1), newInterval.height));

        if (temp.size() > 0 && temp.get(temp.size()-1).end > newInterval.end) temp.add(temp.size()-1, newInterval);
        else temp.add(newInterval);

        while (ind < intervals.size()) temp.add(intervals.get(ind++));

        return temp;
    }
}
