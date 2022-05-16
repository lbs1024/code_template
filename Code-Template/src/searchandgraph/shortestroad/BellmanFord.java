package searchandgraph.shortestroad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Bellman-ford算法只需要遍历所有边，因此使用Edge类数组存储每一条边，遍历起来比较方便
 */
class Edge {
    int from;
    int to;
    int weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

/**
 * @author LBS59
 * @description 解决单源最短路中存在负权边的问题
 */
public class BellmanFord {
    private static final int N = 510, M = 10010, INF = 0x3f3f3f3f;
    /**
     * dist[i]存储从起点到节点i的最短路径
     */
    private static int[] dist;
    /**
     * 防止串联更新，使用backup每次存储上次的结果
     */
    private static int[] backup;
    /**
     * 使用Edge数组存储图中的每一条边
     */
    private static Edge[] edges;

    static {
        dist = new int[N];
        Arrays.fill(dist, INF);
        backup = new int[N];
        edges = new Edge[M];
    }

    public static int bellmanFord(int n, int m, int k) {
        dist[1] = 0;
        for (int i = 0; i < k; i++) {
            backup = Arrays.copyOf(dist, dist.length);
            for (int j = 0; j < m; j++) {
                int a = edges[j].from, b = edges[j].to, w = edges[j].weight;
                dist[b] = Math.min(dist[b], backup[a] + w);
            }
        }
        return dist[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]), k = Integer.parseInt(s[2]);
        for (int i = 0; i < m; i++) {
            String[] row = in.readLine().split(" ");
            int a = Integer.parseInt(row[0]), b = Integer.parseInt(row[1]), c = Integer.parseInt(row[2]);
            edges[i] = new Edge(a, b, c);
        }
        int t = bellmanFord(n, m, k);
        if (t > INF / 2) {
            System.out.println("impossible");
        } else {
            System.out.println(t);
        }

        in.close();
    }
}
