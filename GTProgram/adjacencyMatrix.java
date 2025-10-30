public class adjacencyMatrix {
    public static void main(String[] args) {
        int v = 4;
        int[][] graph = { { 0, 1 }, { 1, 2 }, { 1, 3 }, { 2, 3 }, { 3, 0 } };
        for (int i = 0; i < v; i++) {
            System.out.print(i + " ->");
            for (int j = 0; j < graph.length; j++) {
                if (i == graph[j][0]) {
                    System.out.print(" " + graph[j][1]);
                }
            }
            System.out.println();
        }
    }
}