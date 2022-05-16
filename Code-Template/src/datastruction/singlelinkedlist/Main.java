package datastruction.singlelinkedlist;

import java.io.*;

class ListNode {
    private static final int N = 100010;
    /**
     * head表示头节点的下标，e[i]表示节点i的值，ne[i]表示节点i的next指针是多少，这里指下标，idx存储当前可以用到哪个点
     */
    int head, idx;
    int[] e, ne;

    public ListNode() {
        head = -1;
        idx = 0;
        e = new int[N];
        ne = new int[N];
    }

    /**
     * 头插法
     */
    public void add2Head(int x) {
        e[idx] = x;
        ne[idx] = head;
        head = idx++;
    }

    /**
     * 将x值插入到下标为k后面
     * @param k 下标
     * @param x 值
     */
    public void add(int k, int x) {
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx++;
    }

    /**
     * 删除下标为k的节点
     * @param k 下标
     */
    public void remove(int k) {
        ne[k] = ne[ne[k]];
    }
}

/**
 * @author LBS59
 * @description 使用数组来模拟单链表
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(in.readLine());
        ListNode ln = new ListNode();
        while (m-- > 0) {
            String[] ops = in.readLine().split(" ");
            if ("H".equals(ops[0])) {
                int x = Integer.parseInt(ops[1]);
                ln.add2Head(x);
            } else if ("D".equals(ops[0])) {
                int k = Integer.parseInt(ops[1]);
                if (k == 0) {
                    ln.head = ln.ne[ln.head];
                } else {
                    ln.remove(k - 1);
                }
            } else {
                int k = Integer.parseInt(ops[1]), x = Integer.parseInt(ops[2]);
                ln.add(k - 1, x);
            }
        }
        for (int i = ln.head; i != -1; i = ln.ne[i]) {
            System.out.printf("%d ", ln.e[i]);
        }

        out.flush();
        in.close();
        out.close();
    }
}
