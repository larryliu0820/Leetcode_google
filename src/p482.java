/**
 * Created by mengwliu on 11/16/17.
 * 482. License Key Formatting
 */
public class p482 {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = S.length()-1; i >= 0; i--) {
            char curr = S.charAt(i);
            if (Character.isAlphabetic(curr) || Character.isDigit(curr)) {
                sb.insert(0, Character.toUpperCase(curr));
                count++;
                if (count % K == 0 && i != 0) sb.insert(0, '-');
            }
        }
        if (sb.length() > 0 && sb.charAt(0) == '-') sb.delete(0,1);
        return sb.toString();
    }
}
