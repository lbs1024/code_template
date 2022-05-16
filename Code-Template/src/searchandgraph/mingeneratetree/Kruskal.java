package searchandgraph.mingeneratetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author LBS59
 * @description Kruskal算法求最小生成树
 */
public class Kruskal {

    /**
     * 边的定义
     */
    private static class Edge implements Comparable<Edge> {
        /**
         * 起点
         */
        int fr;
        /**
         * 终点
         */
        int to;
        /**
         * 边权
         */
        int weight;

        public Edge(int fr, int to, int weight) {
            this.fr = fr;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(weight, o.weight);
        }
    }
    private static final int N = 200020;

    private static int[] p;
    private static Edge[] edges;

    static {
        p = new int[N];
        edges = new Edge[N];
    }

    public static int find(int x) {
        return p[x] == x ? p[x] : find(p[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
        for (int i = 0; i < m; i++) {
            String[] row = in.readLine().split(" ");
            int a = Integer.parseInt(row[0]), b = Integer.parseInt(row[1]), w = Integer.parseInt(row[2]);
            edges[i] = new Edge(a, b, w);
        }
        Arrays.sort(edges, 0, m);
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        int res = 0, cnt = 0;
        for (int i = 0; i < m; i++) {
            int a = edges[i].fr, b = edges[i].to, w = edges[i].weight;
            a = find(a);
            b = find(b);
            if (a != b) {
                p[a] = b;
                res += w;
                cnt++;
            }
        }
        if (cnt < n - 1) {
            System.out.println("impossible");
        } else {
            System.out.println(res);
        }

        in.close();
    }
}
