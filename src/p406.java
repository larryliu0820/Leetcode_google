import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Larry Liu on 11/21/2017.
 * 406. Queue Reconstruction by Height
 */
public class p406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b)->a[0] != b[0] ?b[0]-a[0]:a[1]-b[1]);
        List<int[]> res = new ArrayList<>();
        for (int[] person: people) {
            res.add(person[1], person);
        }
        return res.toArray(new int[people.length][]);
    }
}
