public class GraphToMatrix {
    public static void main(String[] args) {
        int N = 5;
        int[][] matrix = new int[N][N];

        int[][] edges = {
                { 0, 1 },
                { 1, 2 },
                { 3, 4 },
                { 0, 4 }
        };

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            setOne(matrix, u, v);
        }

        display(matrix);
    }

    public static void setOne(int[][] matrix, int i, int j) {
        matrix[i][j] = 1;
        matrix[j][i] = 1;
    }

    public static void display(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
