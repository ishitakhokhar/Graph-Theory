import java.util.*;

public class HallsCondition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices in X: ");
        int X = sc.nextInt();
        System.out.print("Enter number of vertices in Y: ");
        int Y = sc.nextInt();

        // Build adjacency list for X
        @SuppressWarnings("unchecked")
        List<Integer>[] adj = new ArrayList[X];
        for (int i = 0; i < X; i++)
            adj[i] = new ArrayList<>();

        // Input number of edges
        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();
        System.out.println("Enter edges in format: x y (0-based indices, x in X, y in Y)");
        for (int i = 0; i < E; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj[x].add(y);
        }

        // Check Hall's condition for all subsets of X
        boolean halls = true;
        int totalSubsets = 1 << X;
        for (int mask = 1; mask < totalSubsets; mask++) {
            Set<Integer> ySet = new HashSet<>();
            int xCount = 0;
            for (int i = 0; i < X; i++) {
                if ((mask & (1 << i)) != 0) {
                    xCount++;
                    ySet.addAll(adj[i]);
                }
            }
            if (ySet.size() < xCount) {
                halls = false;
                System.out.println("Fails for subset of size " + xCount + ": " + ySet);
                break;
            }
        }
        if (halls) {
            System.out.println("Hall's condition holds for this bipartite graph.");
        } else {
            System.out.println("Hall's condition does NOT hold for this bipartite graph.");
        }
    }
}