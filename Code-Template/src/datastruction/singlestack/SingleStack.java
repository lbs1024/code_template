package datastruction.singlestack;

import java.io.*;

/**
 * @author LBS59
 * @description 单调栈模板 --- 解决问题：针对数组中每一个元素，找到其左/右边距离其最近比其大/小的元素，不存在则用-1表示
 */
public class SingleStack {
    static final int N = 100010;
    static int[] stk;
    static int tt = 0;

    public static void main(String[] args) throws IOException {
        stk = new int[N];
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        String[] s = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(s[i]);
            while (tt > 0 && stk[tt] >= cur) {
                tt--;
            }
            if (tt > 0) {
                out.write(stk[tt] + " ");
            } else {
                out.write(-1 + " ");
            }
            stk[++tt] = cur;
        }

        out.flush();
        in.close();
        out.close();
    }
}
