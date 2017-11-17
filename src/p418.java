/**
 * Created by Larry Liu on 11/16/2017.
 * 418. Sentence Screen Fitting
 */
public class p418 {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int[] nextIndex = new int[sentence.length];
        int[] times = new int[sentence.length];
        for (int i = 0; i < sentence.length; i++) {
            int time = 0;
            int s = i;

            int j = 0;
            while (cols - j >= sentence[s].length()) {
                j += sentence[s++].length() + 1;
                if (s == sentence.length) {
                    time++;
                    s = 0;
                }
            }
            nextIndex[i] = s;
            times[i] = time;
        }
        int res = 0;
        int ind = 0;
        for (int i = 0; i < rows; i++) {
            res += times[ind];
            ind = nextIndex[ind];
        }
        return res;
    }
}
