/**
 * Created by Larry Liu on 11/20/2017.
 * 280. Wiggle Sort
 */
public class p280 {
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 1) {
                if (nums[i-1] > nums[i]) swap(nums, i, i-1);
            } else {
                if (i != 0 && nums[i-1] < nums[i]) swap(nums, i, i-1);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
