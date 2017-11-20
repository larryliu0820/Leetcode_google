/**
 * Created by Larry Liu on 11/18/2017.
 * 393. UTF-8 Validation
 */
public class p393 {
    public boolean validUtf8(int[] data) {
        int ind = 0;
        while (ind < data.length) {
            int first = data[ind];
            int mask = 1 << 7;
            int count = 0;
            for (int i = 0; i < 7; i++) {
                if ((first & mask) == mask) count++;
                else break;
                mask >>= 1;
            }
            if (count == 1 || count > 4) return false;
            ind++;
            for (int i = 1; i < count; i++) {
                if (ind >= data.length) return false;
                if (data[ind] >= 128 && data[ind] < 192) ind++;
                else return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        p393 sol = new p393();
        sol.validUtf8(new int[]{250,145,145,145,145});
    }
}
