package searchandgraph.shortestroad;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author LBS59
 * @description 堆优化版的dijkstra算法，解决稀疏图中的最短路问题(单源最短路算法)
 */
public class Dijkstra2 {
    private static final int N = 150010, INF = 0x3f3f3f3f;
    /**
     * 稀疏图(边较点少的图)节点过多，不能用邻接矩阵来存，使用于邻接表，w存储每条边的权重
     */
    private static final int[] h, e, ne, w;
    private static int idx;
    /**
     * dist存储每个点到起点的距离
     */
    private static int[] dist;
    /**
     * vis过滤掉已经确定最短路径的点
     */
    private static boolean[] vis;

    static {
        h = new int[N];
        Arrays.fill(h, -1);
        e = new int[N];
        ne = new int[N];
        w = new int[N];
        idx = 0;
        dist = new int[N];
        Arrays.fill(dist, INF);
        vis = new boolean[N];
    }

    public static void add(int from, int to, int weight) {
        e[idx] = to;
        w[idx] = weight;
        ne[idx] = h[from];
        h[from] = idx++;
    }

    public static int dijkstra(int n) {
        dist[1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.offer(new int[] {0, 1});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int ver = cur[1], dis = cur[0];
            if (vis[ver]) {
                continue;
            }
            if (ver == n) {
                break;
            }
            vis[ver] = true;
            for (int i = h[ver]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dis + w[i]) {
                    dist[j] = dis + w[i];
                    pq.offer(new int[] {dist[j], j});
                }
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
        while (m-- > 0) {
            String[] row = in.readLine().split(" ");
            int a = Integer.parseInt(row[0]), b = Integer.parseInt(row[1]), c = Integer.parseInt(row[2]);
            add(a, b, c);
        }
        out.write(dijkstra(n) + "\n");

        out.flush();
        in.close();
        out.close();
    }
}
