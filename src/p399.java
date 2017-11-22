import java.util.*;

/**
 * Created by Larry Liu on 11/21/2017.
 * 399. Evaluate Division
 */
public class p399 {
    Map<String, List<String>> map;
    Map<String, List<Double>> valueMap;
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        map = new HashMap<>();
        valueMap = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            if (!map.containsKey(equation[0])) {
                map.put(equation[0], new LinkedList<>());
                valueMap.put(equation[0], new LinkedList<>());
            }
            if (!map.containsKey(equation[1])) {
                map.put(equation[1], new LinkedList<>());
                valueMap.put(equation[1], new LinkedList<>());
            }
            map.get(equation[0]).add(equation[1]);
            map.get(equation[1]).add(equation[0]);
            valueMap.get(equation[0]).add(values[i]);
            valueMap.get(equation[1]).add(1/values[i]);
        }

        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            result[i] = dfs(query[0], query[1], new HashSet<>(), 1.0);
            if (result[i] == 0.0) result[i] = -1;
        }
        return result;

    }
    private double dfs(String curr, String end, Set<String> visited, double currVal) {
        if (visited.contains(curr) || !map.containsKey(curr)) return 0.0;
        if (curr.equals(end)) return currVal;
        visited.add(curr);

        List<String> neighbors = map.get(curr);
        List<Double> neighborVals = valueMap.get(curr);
        double res = 0.0;
        for (int i = 0; i < neighbors.size(); i++) {
            res = dfs(neighbors.get(i), end, visited, currVal * neighborVals.get(i));
            if (res != 0.0) break;

        }
        visited.remove(curr);
        return res;

    }
}
