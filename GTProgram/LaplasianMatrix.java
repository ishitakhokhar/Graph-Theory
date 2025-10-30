public class LaplasianMatrix {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                { 0, 1 },
                { 1, 2 },
                { 2, 3 },
                { 3, 4 },
                { 4, 0 }
        };
        int[][] laplacian = laplacianMatrix(n, edges);
        printMatrix(laplacian);
    }

    public static int[][] laplacianMatrix(int n, int[][] edges) {
        int[][] LaplasianMatrix = new int[n][n];

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            LaplasianMatrix[u][v] = -1;
            LaplasianMatrix[v][u] = -1;

            LaplasianMatrix[u][u]++;
            LaplasianMatrix[v][v]++;
        }
        return LaplasianMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
