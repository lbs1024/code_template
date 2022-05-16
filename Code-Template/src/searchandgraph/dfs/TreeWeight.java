package searchandgraph.dfs;

import java.io.*;
import java.util.Arrays;

/**
 * @author LBS59
 * @description DFS模板---解决问题：树的重心
 */
public class TreeWeight {
    private static final int N = 100010, M = N * 2;
    static int[] h = new int[N], e = new int[M], ne = new int[M];
    static boolean[] vis = new boolean[N];
    static int idx = 0, ans = N;

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private static int dfs(int u, int n) {
        // 标记一下，已经被搜索过了
        vis[u] = true;

        int sum = 1, res = 0;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!vis[j]) {
                int s = dfs(j, n);
                res = Math.max(res, s);
                sum += s;
            }
        }
        res = Math.max(res, n - sum);
        ans = Math.min(ans, res);
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        Arrays.fill(h, -1);
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n - 1; i++) {
            String[] input = in.readLine().split(" ");
            int a = Integer.parseInt(input[0]), b = Integer.parseInt(input[1]);
            add(a, b);
            add(b, a);
        }
        dfs(1, n);
        out.write(ans + "");

        out.flush();
        in.close();
        out.close();
    }
}
