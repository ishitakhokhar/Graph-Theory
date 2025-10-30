import java.util.ArrayList;
import java.util.List;

public class IsolatedVertices {

    public static void main(String[] args) {
        int v = 5;

        int[][] edges = {
                { 0, 1 },
                { 1, 2 },
                { 0, 2 },
                { 4, 1 }
        };
        List<Integer> isolated = findIsolatedV(edges, v);
        System.out.println("Isolated vertices are: " + isolated);
    }

    public static List<Integer> findIsolatedV(int[][] edges, int v) {

        int[] degree = new int[v];

        for (int[] edge : edges) {
            int u = edge[0];
            int V = edge[1];
            degree[u]++;
            degree[V]++;
        }

        List<Integer> isolatedVertices = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (degree[i] == 0) {
                isolatedVertices.add(i);
            }
        }

        return isolatedVertices;
    }
}