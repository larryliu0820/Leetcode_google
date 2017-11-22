import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Larry Liu on 11/21/2017.
 * 345. Reverse Vowels of a String
 */
public class p345 {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] arr = s.toCharArray();
        int lo = 0, hi = s.length()-1;
        while (lo < hi) {
            while (lo < hi && !vowels.contains(arr[lo])) lo++;
            while (lo < hi && !vowels.contains(arr[hi])) hi--;
            char temp = arr[hi];
            arr[hi] = arr[lo];
            arr[lo] = temp;
            lo++; hi--;
        }
        return String.valueOf(arr);
    }
}
