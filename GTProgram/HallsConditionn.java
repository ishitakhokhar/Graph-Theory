import java.util.*;

public class HallsConditionn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices in X: ");
        int X = sc.nextInt();
        System.out.print("Enter number of vertices in Y: ");
        int Y = sc.nextInt();

        @SuppressWarnings("unchecked")
        List<Integer>[] adj = new ArrayList[X];
        for (int i = 0; i < X; i++)
            adj[i] = new ArrayList<>();

        // Build adjacency for Y as well
        @SuppressWarnings("unchecked")
        List<Integer>[] adjY = new ArrayList[Y];
        for (int i = 0; i < Y; i++)
            adjY[i] = new ArrayList<>();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();
        System.out.println("Enter edges in format: x y (0-based indices, x in X, y in Y)");
        for (int i = 0; i < E; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj[x].add(y);
            adjY[y].add(x);
        }

        // Degree distribution for X
        System.out.println("\nDegree of vertices in X:");
        for (int i = 0; i < X; i++) {
            System.out.println("X" + i + ": " + adj[i].size());
        }

        // Degree distribution for Y
        System.out.println("\nDegree of vertices in Y:");
        for (int i = 0; i < Y; i++) {
            System.out.println("Y" + i + ": " + adjY[i].size());
        }

        // Eigenvector centrality (simple power iteration)
        int N = X + Y;
        double[] centrality = new double[N];
        Arrays.fill(centrality, 1.0);

        // Build adjacency matrix for the whole bipartite graph
        int[][] matrix = new int[N][N];
        for (int i = 0; i < X; i++) {
            for (int y : adj[i]) {
                matrix[i][X + y] = 1;
                matrix[X + y][i] = 1;
            }
        }

        // Power iteration
        for (int iter = 0; iter < 20; iter++) {
            double[] next = new double[N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    next[i] += matrix[i][j] * centrality[j];
                }
            }
            // Normalize
            double norm = 0;
            for (double v : next)
                norm += v * v;
            norm = Math.sqrt(norm);
            for (int i = 0; i < N; i++)
                next[i] /= norm;
            centrality = next;
        }

        System.out.println("\nEigenvector centrality:");
        for (int i = 0; i < X; i++) {
            System.out.printf("X%d: %.4f\n", i, centrality[i]);
        }
        for (int i = 0; i < Y; i++) {
            System.out.printf("Y%d: %.4f\n", i, centrality[X + i]);
        }

        // (Optional) Output data for plotting elsewhere
        System.out.println("\nCopy these values to plot in Python/Excel if needed.");
    }
}