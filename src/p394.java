import java.util.Stack;

/**
 * Created by Larry Liu on 11/18/2017.
 * 394. Decode String
 */
public class p394 {
    public String decodeString(String s) {
        String res = "";
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int count = 0;
                while (Character.isDigit(s.charAt(i))) {
                    count = 10 * count + (s.charAt(i)-'0');
                    i++;
                }
                numStack.push(count);
            } else if (Character.isAlphabetic(s.charAt(i))) {
                res += s.charAt(i++);
            } else if (s.charAt(i) == '[') {
                strStack.push(res);
                res = "";
                i++;
            } else if (s.charAt(i) == ']') {
                StringBuilder temp = new StringBuilder(strStack.pop());
                int count = numStack.pop();
                for (int j = 0; j < count; j++) temp.append(res);
                res = temp.toString();
                i++;
            }
        }

        return res;
    }
}
