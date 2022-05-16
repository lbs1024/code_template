package searchandgraph.binarygraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author LBS59
 * @description 匈牙利算法寻找二分图最大匹配
 */
public class XYL {
    private static final int N = 510, M = 100010;

    private static int[] h, e, ne;
    private static int idx;
    private static int[] match;
    private static boolean[] vis;

    static {
        h = new int[N];
        Arrays.fill(h, -1);
        e = new int[M];
        ne = new int[M];
        idx = 0;
        match = new int[N];
        vis = new boolean[N];
    }

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static boolean find(int x) {
        for (int i = h[x]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!vis[j]) {
                vis[j] = true;
                if (match[j] == 0 || find(match[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] s = in.readLine().split(" ");
        int n1 = Integer.parseInt(s[0]), n2 = Integer.parseInt(s[1]), m = Integer.parseInt(s[2]);
        while (m-- > 0) {
            String[] row = in.readLine().split(" ");
            int a = Integer.parseInt(row[0]), b = Integer.parseInt(row[1]);
            add(a, b);
        }
        int res = 0;
        for (int i = 1; i <= n1; i++) {
            Arrays.fill(vis, false);
            if (find(i)) {
                res++;
            }
        }
        System.out.println(res);

        in.close();
    }
}
