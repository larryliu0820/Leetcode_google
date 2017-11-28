import java.util.*;

/**
 * Created by mengwliu on 11/27/17
 * 380. Insert Delete GetRandom O(1)
 */
public class p380 {
    List<Integer> nums;
    Map<Integer, Integer> locations;
    Random rand;
    /** Initialize your data structure here. */
    public p380() {
        nums = new LinkedList<>();
        locations = new HashMap<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (locations.containsKey(val)) {
            return false;
        } else {
            nums.add(val);
            locations.put(val, nums.size()-1);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (locations.containsKey(val)) {
            int index = locations.get(val);
            if (index != nums.size()-1) {
                int last = nums.get(nums.size()-1);
                nums.set(index, last);
                locations.put(last, index);
            }
            nums.remove(nums.size()-1);
            locations.remove(val);
            return true;
        } else return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
