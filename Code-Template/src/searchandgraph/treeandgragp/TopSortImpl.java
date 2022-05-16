package searchandgraph.treeandgragp;

import java.io.*;
import java.util.*;

class TopSort {
    private final int N = 100010;

    /**
     * 散列结构四件套
     */
    private int[] h, e, ne;
    private int idx, n, cnt;

    /**
     * d数组存储每一个节点的入度，q用来模拟队列实现
     */
    int[] d, q, res;

    public TopSort(int n) {
        h = new int[N];
        Arrays.fill(h, -1);
        e = new int[N];
        ne = new int[N];
        idx = 0;
        this.n = n;
        cnt = 0;
        d = new int[N];
        q = new int[N];
        res = new int[N];
    }

    /**
     * 存在一条边: a >> b
     * @param a 起始节点
     * @param b 终止节点
     */
    public void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public boolean topSortWithArrayQueue() {
        int hh = 0, tt = -1;
        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) {
                q[++tt] = i;
            }
        }
        while (hh <= tt) {
            int t = q[hh++];
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                d[j]--;
                if (d[j] == 0) {
                    q[++tt] = j;
                }
            }
        }

        return tt == n - 1;
    }

    public boolean topSortWithQueue() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) {
                queue.offer(i);
                res[cnt++] = i;
            }
        }
        while (!queue.isEmpty()) {
            int t = queue.poll();
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                d[j]--;
                if (d[j] == 0) {
                    queue.offer(j);
                    res[cnt++] = j;
                }
            }
        }
        return cnt == n;
    }
}

/**
 * @author LBS59
 * @description 树和图的谱图排序实现
 */
public class TopSortImpl {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
        TopSort topSort = new TopSort(n);
        while (m-- > 0) {
            String[] r = in.readLine().split(" ");
            int a = Integer.parseInt(r[0]), b = Integer.parseInt(r[1]);
            topSort.add(a, b);
            topSort.d[b]++;
        }
        if (topSort.topSortWithArrayQueue()) {
            for (int i = 0; i < n; i++) {
                out.write(topSort.q[i] + " ");
            }
            out.write("\n");
        } else {
            out.write(-1 + "\n");
        }

        if (topSort.topSortWithQueue()) {
            for (int i = 0; i < n; i++) {
                out.write(topSort.res[i] + " ");
            }
            out.write("\n");
        } else {
            out.write(-1 + "\n");
        }

        out.flush();
        in.close();
        out.close();
    }
}
