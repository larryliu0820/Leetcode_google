import java.util.*;

/**
 * Created by Larry Liu on 11/20/2017.
 * 218. The Skyline Problem
 */
public class p218 {
    class Edge {
        int x;
        boolean isUp;
        int h;
        Edge(int x, int h, boolean isUp) {this.x = x; this.h = h; this.isUp = isUp;}
    }
    public List<int[]> getSkyline(int[][] buildings) {
        Map<Edge, Edge> buildingEdgeMap = new HashMap<>();
        List<Edge> edges = new LinkedList<>();
        for (int[] building: buildings) {
            Edge up = new Edge(building[0], building[2], true);
            Edge down = new Edge(building[1], building[2], false);
            buildingEdgeMap.put(down, up);
            edges.add(up);
            edges.add(down);
        }
        edges.sort((a, b)->{
            if (a.x != b.x) return a.x - b.x;
            else {
                if (a.isUp && !b.isUp) return -1;
                else if (!a.isUp && b.isUp) return 1;
                else if (a.isUp) {
                    return b.h - a.h;
                } else {
                    return a.h - b.h;
                }
            }
        });

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b)->b.h-a.h);

        List<int[]> res = new LinkedList<>();
        for (Edge e: edges) {
            if (e.isUp) {
                if (pq.isEmpty() || pq.peek().h < e.h) {
                    res.add(new int[]{e.x, e.h});
                }
                pq.offer(e);
            } else {
                pq.remove(buildingEdgeMap.get(e));
                int newHeight = pq.isEmpty()? 0: pq.peek().h;
                if (pq.isEmpty() || pq.peek().h < e.h) {
                    res.add(new int[]{e.x, newHeight});
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        p218 sol = new p218();
        sol.getSkyline(new int[][]{
                {2, 9, 10},
                {3, 7, 15},
                {5, 12, 12},
                {15, 20, 10},
                {19, 24, 8}
        });
    }
}
