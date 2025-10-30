import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DominantSet {
    public static void main(String[] args) {
        int N = 4, M = 4;
        int[][] arr = { { 1, 2 }, { 1, 3 }, { 3, 4 }, { 2, 4 } };

        List<Integer>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : arr) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                Set<Integer> covered = new HashSet<>();
                covered.add(i);
                covered.add(j);
                covered.addAll(adj[i]);
                covered.addAll(adj[j]);
                if (covered.size() == N) {
                    System.out.println("Dominant Set: {" + i + ", " + j + "}");
                }
            }
        }
    }
}