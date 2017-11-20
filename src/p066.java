import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Larry Liu on 11/19/2017.
 * 66. Plus One
 */
public class p066 {
    public int[] plusOne(int[] digits) {
        List<Integer> res = new LinkedList<>();
        int carry = 1;
        for (int i = digits.length-1; i >= 0; i--) {
            int sum = digits[i] + carry;
            carry = sum / 10;
            res.add(0, sum % 10);
        }
        if (carry > 0) res.add(0, carry);
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) arr[i] = res.get(i);
        return arr;
    }
}
