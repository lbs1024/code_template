package searchandgraph.treeandgragp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class SaveAndTraverse {
    private static final int N = 100010, M = N * 2;
    /**
     * 这里h存储每一个节点，e表示单链表中的节点的值域，ne表示单链表中的节点的next域
     */
    int[] h, e, ne;
    /**
     * 在遍历时起标记作用
     */
    boolean[] st;
    /**
     * idx表示当前单链表中元素的个数，也是下一个节点插入的下标
     */
    int idx;
    /**
     * 这里d表示任意一点到起点的距离，q模拟队列
     */
    int[] d, q;

    public SaveAndTraverse() {
        h = new int[N];
        Arrays.fill(h, -1);
        e = new int[M];
        ne = new int[M];
        st = new boolean[N];
        idx = 0;
        d = new int[N];
        Arrays.fill(d, -1);
        q = new int[N];
    }

    /**
     * 存储一条从a指向b的边
     * @param a 起点
     * @param b 终点
     */
    public void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    /**
     * dfs遍历图和树
     * @param u 当前遍历位置
     */
    public void dfs(int u) {
        st[u] = true;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!st[j]) {
                dfs(j);
            }
        }
    }

    public void bfsWithArrayQueue() {
        int hh = 0, tt = 0;
        q[0] = 1;
        d[1] = 0;
        while (hh <= tt) {
            int t = q[hh++];
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (d[j] == -1) {
                    d[j] = d[t] + 1;
                    q[++tt] = j;
                }
            }
        }
    }

    public void bfsWithQueue() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        d[1] = 0;
        while (!queue.isEmpty()) {
            int t = queue.poll();
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (d[j] == -1) {
                    d[j] = d[t] + 1;
                    queue.offer(j);
                }
            }
        }
    }
}

public class Main {
}
