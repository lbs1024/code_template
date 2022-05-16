package searchandgraph.shortestroad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LBS59
 * @description 对Bellman-ford优化的SPFA算法
 */
public class SPFA {
    private static final int N = 100010, INF = 0x3f3f3f3f;

    private static int[] h, e, ne, w;
    private static int[] dist;
    private static boolean[] vis;
    private static int idx;

    static {
        h = new int[N];
        Arrays.fill(h, -1);
        e = new int[N];
        ne = new int[N];
        w = new int[N];
        dist = new int[N];
        Arrays.fill(dist, INF);
        vis = new boolean[N];
        idx = 0;
    }

    public static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static int spfa(int n) {
        Queue<Integer> q = new LinkedList<>();
        dist[1] = 0;
        vis[1] = true;
        q.offer(1);
        while (!q.isEmpty()) {
            int t = q.poll();
            vis[t] = false;
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[t] + w[i]) {
                    dist[j] = dist[t] + w[i];
                    if (!vis[j]) {
                        q.offer(j);
                        vis[j] = true;
                    }
                }
            }
        }
        return dist[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
        while (m-- > 0) {
            String[] row = in.readLine().split(" ");
            int a = Integer.parseInt(row[0]), b = Integer.parseInt(row[1]), c = Integer.parseInt(row[2]);
            add(a, b, c);
        }
        int t = spfa(n);
        if (t == INF) {
            System.out.println("impossible");
        } else {
            System.out.println(t);
        }

        in.close();
    }
}
