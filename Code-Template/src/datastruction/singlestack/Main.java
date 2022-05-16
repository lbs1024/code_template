package datastruction.singlestack;

import java.io.*;
import java.util.Stack;

/**
 * @author LBS59
 * @description 单调栈应用
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(in.readLine());
        String[] s = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(s[i]);
            while (!stack.isEmpty() && stack.peek() >= x) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                out.write(-1 + " ");
            } else {
                out.write(stack.peek() + " ");
            }
            stack.push(x);
        }

        out.flush();
        in.close();
        out.close();
    }
}
