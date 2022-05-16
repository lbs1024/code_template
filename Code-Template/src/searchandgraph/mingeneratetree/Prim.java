package searchandgraph.mingeneratetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author LBS59
 * @description Prim算法求最小生成树
 */
public class Prim {
    private static final int N = 510, INF = 0x3f3f3f3f;

    /**
     * 稠密图使用邻接矩阵来存储
     */
    private static int[][] g;
    /**
     * dist存储距离连通块的最短距离
     */
    private static int[] dist;
    /**
     * 判重
     */
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

    public static int prim(int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!vis[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }
            if (i > 0 && dist[t] == INF) {
                return INF;
            }
            if (i > 0) {
                res += dist[t];
            }
            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], g[t][j]);
            }
            vis[t] = true;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
        while (m-- > 0) {
            String[] row = in.readLine().split(" ");
            int a = Integer.parseInt(row[0]), b = Integer.parseInt(row[1]), c = Integer.parseInt(row[2]);
            g[a][b] = g[b][a] = Math.min(g[a][b], c);
        }
        int t = prim(n);
        if (t == INF) {
            System.out.println("impossible");
        } else {
            System.out.println(t);
        }

        in.close();
    }
}
