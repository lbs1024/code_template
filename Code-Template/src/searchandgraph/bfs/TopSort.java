package searchandgraph.bfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LBS59
 * @description BFS求有向无环图的拓扑序列
 */
public class TopSort {
    private static final int N = 100010;
    /**
     * 散列结构，d数组存储每一个节点的入度
     */
    static int[] h = new int[N], e = new int[N], ne = new int[N], d = new int[N];
    static int idx = 0;

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private static void topSort(int n) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int t = q.poll();
            System.out.printf("%d ", t);
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                d[j]--;
                if (d[j] == 0) {
                    q.offer(j);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out  = new BufferedWriter(new OutputStreamWriter(System.out));

        Arrays.fill(h, -1);
        String[] s1 = in.readLine().split(" ");
        int n = Integer.parseInt(s1[0]), m = Integer.parseInt(s1[1]);
        for (int i = 0; i < m; i++) {
            String[] input = in.readLine().split(" ");
            int a = Integer.parseInt(input[0]), b = Integer.parseInt(input[1]);
            add(a, b);
            d[b]++;
        }
        topSort(n);

        out.flush();
        in.close();
        out.close();
    }
}
