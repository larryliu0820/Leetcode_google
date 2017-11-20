/**
 * Created by Larry Liu on 11/20/2017.
 * 686. Repeated String Match
 */
public class p686 {
    public int repeatedStringMatch(String A, String B) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < B.length()) {
            sb.append(A);
            count++;
        }
        if (sb.toString().contains(B)) return count;
        else if (sb.append(A).toString().contains(B)) return count+1;
        else return -1;
    }
}
