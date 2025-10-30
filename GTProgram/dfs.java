import java.util.ArrayList;
import java.util.Stack;

public class dfs {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);

        dfs(adj, 0, 5);
    }

    public static void dfs(ArrayList<ArrayList<Integer>> graph, int start, int v) {
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                System.out.print(node + " ");
                visited[node] = true;
            }
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
    }
}
