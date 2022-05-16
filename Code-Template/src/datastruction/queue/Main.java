package datastruction.queue;

/**
 * 数组模拟队列，在队尾插入元素，在队头弹出元素
 */
class MyQueue {
    private static final int N = 100010;

    int[] q;
    int hh, tt;

    public MyQueue() {
        q = new int[N];
        hh = 0;
        tt = -1;
    }

    public void push(int x) {
        if (tt < N) {
            q[++tt] = x;
        }
    }

    public void poll() {
        if (!isEmpty()) {
            hh++;
        }
    }

    public boolean isEmpty() {
        return hh > tt;
    }

    public int peekHead() {
        if (!isEmpty()) {
            return q[hh];
        }
        return Integer.MAX_VALUE;
    }

    public int peekTail() {
        if (!isEmpty()) {
            return q[tt];
        }
        return Integer.MAX_VALUE;
    }
}

/**
 * @author LBS59
 * @description 队列示例
 */
public class Main {
    public static void main(String[] args) {

    }
}
