import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUpar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUpar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp = findUpar(u);
        int vlp = findUpar(v);

        if (ulp == vlp) {
            return;
        }
        if (rank.get(ulp) < rank.get(vlp)) {
            parent.set(ulp, vlp);
        } else if (rank.get(ulp) > rank.get(vlp)) {
            parent.set(vlp, ulp);
        } else {
            parent.set(vlp, ulp);
            int rankU = rank.get(ulp);
            rank.set(ulp, rankU + 1);
        }
    }
}

class Edge implements Comparable<Edge> {
    int sourece, desti, weight;

    Edge(int sourece, int desti, int weight) {
        this.sourece = sourece;
        this.desti = desti;
        this.weight = weight;
    }

    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class Kruskal {
    public static int spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int adjNode = adj.get(i).get(j).get(0);
                int wt = adj.get(i).get(j).get(1);
                Edge temp = new Edge(i, adjNode, wt);
                edges.add(temp);
            }
        }

        DisjointSet ds = new DisjointSet(v);
        Collections.sort(edges);
        int mstWt = 0;

        for (Edge e : edges) {
            int wt = e.weight;
            int u = e.sourece;
            int vtx = e.desti;

            if (ds.findUpar(u) != ds.findUpar(vtx)) {
                mstWt += wt;
                ds.unionByRank(u, vtx);
            }
        }

        return mstWt;
    }
}

public class KruskalAlgo {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        int[][] edges = {
                { 0, 1, 2 },
                { 0, 2, 1 },
                { 1, 2, 1 },
                { 2, 3, 2 },
                { 3, 4, 1 },
                { 4, 2, 2 }
        };

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> tmp1 = new ArrayList<>();
            ArrayList<Integer> tmp2 = new ArrayList<>();
            tmp1.add(v);
            tmp1.add(w);

            tmp2.add(u);
            tmp2.add(w);

            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);
        }

        int mstWt = Kruskal.spanningTree(V, adj);
        System.out.println("The sum of all the edge weights: " + mstWt);
    }
}
