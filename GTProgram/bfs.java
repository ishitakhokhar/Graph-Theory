import java.util.LinkedList;
import java.util.Queue;

public class bfs {
    public static void main(String[] args) {
        int v = 5;
        int[][] graph = new int[v][v];

        graph[0][1] = 1;
        graph[1][0] = 1;
        graph[0][3] = 1;
        graph[3][0] = 1;
        graph[1][2] = 1;
        graph[2][1] = 1;
        graph[1][3] = 1;
        graph[3][1] = 1;
        graph[3][2] = 1;
        graph[2][4] = 1;
        graph[4][2] = 1;

        bfs(graph, 0, v);
    }

    public static void bfs(int[][] graph, int start, int v) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int i = 0; i < v; i++) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}