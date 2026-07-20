import java.util.*;

public class Dijkstra {
    static final int INF = Integer.MAX_VALUE;

    public static void dijkstra(int graph[][], int src, int dest) {
        int n = graph.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];

        Arrays.fill(dist, INF);
        Arrays.fill(parent, -1);
        dist[src] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = findMinDistance(dist, visited);
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    parent[v] = u;
                }
            }
        }

        printPath(parent, src, dest, dist[dest]);
    }

    private static int findMinDistance(int[] dist, boolean[] visited) {
        int min = INF, minIndex = -1;
        for (int v = 0; v < dist.length; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private static void printPath(int[] parent, int src, int dest, int distance) {
        if (distance == INF) {
            System.out.println("No path exists from " + src + " to " + dest);
            return;
        }

        System.out.println("Shortest distance: " + distance);
        System.out.print("Path: ");
        printRecursivePath(parent, dest);
        System.out.println();
    }

    private static void printRecursivePath(int[] parent, int node) {
        if (node == -1) return;
        printRecursivePath(parent, parent[node]);
        System.out.print(node + " ");
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 150, 230, 90, 0, 0, 0},
                {150, 0, 80, 100, 0, 0, 0},
                {230, 80, 0, 0, 330, 390, 0},
                {90, 100, 0, 0, 330, 390, 0},
                {0, 0, 330, 330, 0, 190, 120},
                {0, 0, 390, 390, 190, 0, 120},
                {0, 0, 0, 0, 120, 120, 0}
        };
        int src = 3;  // Thatta
        int dest = 6; // Jacobabad

        dijkstra(graph, src, dest);
    }
}
