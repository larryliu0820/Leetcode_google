/**
 * Created by mengwliu on 11/16/17.
 * 683. K Empty Slots
 */
public class p683 {
    public int kEmptySlots(int[] flowers, int k) {
        int[] days = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++) days[flowers[i]-1] = i+1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < days.length-k-1; i++) {
            int head = i+1, tail = i + k + 1;
            while (head <= tail) {
                if (head == tail) res = Math.min(res, Math.max(days[i], days[tail]));
                if (days[head] <= days[i] || days[head] <= days[tail]) {
                    i = head-1;
                    break;
                }
                head++;
            }
        }
        return res == Integer.MAX_VALUE?-1: res;
    }

    public static void main(String[] args) {
        p683 sol = new p683();
        sol.kEmptySlots(new int[]{3,9,2,8,1,6,10,5,4,7}, 1);
    }
}
