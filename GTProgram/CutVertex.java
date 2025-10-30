import java.util.*;

public class CutVertex {

    public static void main(String[] args) {
        Graph g = new Graph(8);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 7);
        g.addEdge(7, 4);
        g.addEdge(0, 4);
        g.addEdge(1, 5);
        g.addEdge(2, 6);
        g.addEdge(3, 7);

        int vc = g.findVertexConnectivity();
        System.out.println("Vertex connectivity of the graph is: " + vc);
    }

    static class Graph {
        int n;
        List<List<Integer>> adj;

        Graph(int n) {
            this.n = n;
            adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        void dfs(int u, boolean[] visited, List<Integer> removed) {
            visited[u] = true;
            for (int v : adj.get(u)) {
                if (!visited[v] && !removed.contains(v)) {
                    dfs(v, visited, removed);
                }
            }
        }

        boolean isConnected(List<Integer> removed) {
            boolean[] visited = new boolean[n];

            int start = -1;
            for (int i = 0; i < n; i++) {
                if (!removed.contains(i)) {
                    start = i;
                    break;
                }
            }
            if (start == -1)
                return false;

            dfs(start, visited, removed);

            for (int i = 0; i < n; i++) {
                if (!removed.contains(i) && !visited[i])
                    return false;
            }
            return true;
        }

        int findVertexConnectivity() {

            for (int u = 0; u < n; u++) {
                List<Integer> removed = new ArrayList<>();
                removed.add(u);
                if (!isConnected(removed))
                    return 1;
            }

            for (int u = 0; u < n; u++) {
                for (int v = u + 1; v < n; v++) {
                    List<Integer> removed = new ArrayList<>();
                    removed.add(u);
                    removed.add(v);
                    if (!isConnected(removed))
                        return 2;
                }
            }
            return 3;
        }
    }
}
