import java.util.LinkedList;
import java.util.List;

/**
 * Created by Larry Liu on 11/19/2017.
 * 163. Missing Ranges
 */
public class p163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int left = lower;
        List<String> res = new LinkedList<>();
        for (int i = 0; i < nums.length && nums[i] <= upper; i++) {
            if (nums[i] > left ) {
                if (left == nums[i]-1) {
                    res.add(""+left);
                } else {
                    res.add(""+left+"->"+(nums[i]-1));
                }
            }
            if (upper == nums[i]) return res;
            left = nums[i]+1;
        }
        if (upper == left) {
            res.add(""+upper);
        } else if (upper > left) {
            res.add(""+left+"->"+upper);
        }
        return res;
    }
}
