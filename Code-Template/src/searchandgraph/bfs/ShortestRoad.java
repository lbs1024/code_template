package searchandgraph.bfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LBS59
 * @description BFS模板解决问题--图的最短路问题
 */
public class ShortestRoad {
    private static final int N = 100010;
    /**
     * 散列结构，d数组存储每一个节点的入度
     */
    static int[] h = new int[N], e = new int[N], ne = new int[N], d = new int[N], res = new int[N];
    static int idx = 0, cnt = 0;

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private static boolean topSort(int n) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int t = q.poll();
            // 这里将可能的拓扑排序存储起来，因为不一定存在
            res[cnt++] = t;
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                d[j]--;
                if (d[j] == 0) {
                    q.offer(j);
                }
            }
        }
        // cnt==n表明所有的节点都遍历到了，存在一种有效的拓扑排序方式
        return cnt == n;
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
        if (topSort(n)) {
            for (int i = 0; i < n; i++) {
                out.write(res[i] + " ");
            }
        } else {
            out.write(-1 + "");
        }

        out.flush();
        in.close();
        out.close();
    }
}
