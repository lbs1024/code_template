package datastruction.doublelinkedlist;

import java.io.*;

/**
 * 双向链表定义
 */
class DeListNode {
    private static final int N = 100010;

    int[] e, l, r;
    int idx;

    public DeListNode() {
        // 0表示左端点，1表示右端点
        e = new int[N];
        l = new int[N];
        r = new int[N];
        r[0] = 1;
        l[1] = 0;
        idx = 2;
    }

    /**
     * 在第k个点的右边插入节点x
     * @param k 下标
     * @param x 插入节点
     */
    public void add(int k, int x) {
        e[idx] = x;
        r[idx] = r[k];
        l[idx] = k;
        l[r[k]] = idx;
        r[k] = idx;
        idx++;
    }

    /**
     * 删除第k个节点
     * @param k 待删节点
     */
    public void remove(int k) {
        r[l[k]] = r[k];
        l[r[k]] = l[k];
    }
}

/**
* @Author LBS59
* @Description 双链表示例
* @Date 0:14 2022/4/11
**/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(in.readLine());
        DeListNode deListNode = new DeListNode();
        while (m-- > 0) {
            String[] ops = in.readLine().split(" ");
            if ("L".equals(ops[0])) {
                // 在链表最左端插入数x
                int x = Integer.parseInt(ops[1]);
                deListNode.add(0, x);
            } else if ("R".equals(ops[0])) {
                // 在链表的最右端插入数x
                int x = Integer.parseInt(ops[1]);
                deListNode.add(deListNode.l[1], x);
            } else if ("D".equals(ops[0])) {
                // 将第k个插入的数删除
                int k = Integer.parseInt(ops[1]);
                deListNode.remove(k);
            } else if ("IL".equals(ops[0])) {
                // 在第k个插入的数左侧插入一个数
                int k = Integer.parseInt(ops[1]), x = Integer.parseInt(ops[2]);
                deListNode.add(deListNode.l[k], x);
            } else {
                // 在第k个插入的数右侧插入一个数
                int k = Integer.parseInt(ops[1]), x = Integer.parseInt(ops[2]);
                deListNode.add(k, x);
            }
        }
        for (int i = deListNode.r[0]; i != 1; i = deListNode.r[i]) {
            out.write(deListNode.e[i] + " ");
        }

        out.flush();
        in.close();
        out.close();
    }
}
