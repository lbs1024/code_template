package searchandgraph.shortestroad;

import java.io.*;
import java.util.Arrays;

/**
 * @author LBS59
 * @description 朴素版迪杰斯特拉算法---解决稠密图的最短路问题(单源最短路问题)
 */
public class Dijkstra1 {
    private static final int N = 510, INF = 0x3f3f3f3f;
    private static int[][] g;
    private static int[] dist;
    private static boolean[] vis;

    static {
        g = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(g[i], INF);
        }
        dist = new int[N];
        Arrays.fill(dist, INF);
        vis = new boolean[N];
    }

    private static int dijkstra(int n) {
        dist[1] = 0;
        // 遍历剩余没有遍历到的点中距离最近者
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!vis[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }
            vis[t] = true;
            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
            }
        }
        if (dist[n] == INF) {
            return -1;
        }
        return dist[n];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
        for (int i = 0; i < m; i++) {
            String[] input = in.readLine().split(" ");
            int a = Integer.parseInt(input[0]), b = Integer.parseInt(input[1]), w = Integer.parseInt(input[2]);
            g[a][b] = Math.min(g[a][b], w);
        }
        out.write(dijkstra(n) + "\n");

        out.flush();
        in.close();
        out.close();
    }
}
