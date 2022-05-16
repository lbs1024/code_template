package datastruction.stack;

import java.io.*;

class MyStack {
    private static final int N = 100010;

    int[] stk;
    int tt;

    public MyStack() {
        stk = new int[N];
        tt = -1;
    }

    public void push(int x) {
        if (tt < N) {
            stk[++tt] = x;
        }
    }

    public void pop() {
        if (!isEmpty()) {
            tt--;
        }
    }

    public boolean isEmpty() {
        return tt < 0;
    }

    public int top() {
        if (!isEmpty()) {
            return stk[tt];
        } else {
            return Integer.MAX_VALUE;
        }
    }
}

/**
 * @author LBS59
 * @description 栈示例
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        MyStack stack = new MyStack();
        while (n-- > 0) {
            String[] ops = in.readLine().split(" ");
            if ("push".equals(ops[0])) {
                int x = Integer.parseInt(ops[1]);
                stack.push(x);
            } else if ("pop".equals(ops[0])) {
                stack.pop();
            } else if ("empty".equals(ops[0])) {
                boolean flag = stack.isEmpty();
                if (flag) {
                    out.write("YES\n");
                } else {
                    out.write("NO\n");
                }
            } else {
                out.write(stack.top() + "\n");
            }
        }

        out.flush();
        in.close();
        out.close();
    }
}
