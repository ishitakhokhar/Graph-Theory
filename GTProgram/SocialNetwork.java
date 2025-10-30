public class SocialNetwork {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 0, 1, 0 },
                { 1, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 1 }
        };
        int n = arr.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(arr, visited, i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void dfs(int[][] arr, boolean[] visited, int i) {
        visited[i] = true;
        for (int j = 0; j < arr.length; j++) {
            if ((arr[i][j] == 1 || arr[j][i] == 1) && !visited[j]) {
                dfs(arr, visited, j);
            }
        }
    }
}
