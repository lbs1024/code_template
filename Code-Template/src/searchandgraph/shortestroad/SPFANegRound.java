package searchandgraph.shortestroad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LBS59
 * @description SPFA算法判断有向图中是否存在负权回路
 */
public class SPFANegRound {
    private static final int N = 10010;

    /**
     * 散列表四件套加w权重数组
     */
    private static int[] h, w, e, ne;
    private static int idx;
    /**
     * 记录每一个点到起点的最短距离，cnt表示最短距离经过的变数
     */
    private static int[] dist, cnt;
    /**
     * 判重数组，防止重复访问
     */
    private static boolean[] vis;

    static {
        h = new int[N];
        Arrays.fill(h, -1);
        w = new int[N];
        e = new int[N];
        ne = new int[N];
        idx = 0;
        dist = new int[N];
        cnt = new int[N];
        vis = new boolean[N];
    }

    public static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static boolean spfa(int n) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            vis[i] = true;
            q.offer(i);
        }
        while (!q.isEmpty()) {
            int t = q.poll();
            vis[t] = false;

            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[t] + w[i]) {
                    dist[j] = dist[t] + w[i];
                    cnt[j] = cnt[t] + 1;
                    if (cnt[j] >= n) {
                        return true;
                    }
                    if (!vis[j]) {
                        vis[j] = true;
                        q.offer(j);
                    }
                }
            }
        }
        return false;
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
        if (spfa(n)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        in.close();
    }
}
