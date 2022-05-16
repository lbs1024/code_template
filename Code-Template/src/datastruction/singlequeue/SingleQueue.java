package datastruction.singlequeue;

import java.io.*;

/**
 * @author LBS59
 * @description 单调队列模板--- 解决问题：等长滑动窗口中的最值问题
 */
public class SingleQueue {
    static final int N = 1000010;
    static int[] a = new int[N], q = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = in.readLine().split(" ");
        int n = Integer.parseInt(s1[0]), k = Integer.parseInt(s1[1]);
        String[] s2 = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s2[i]);
        }
        int hh = 0, tt = -1;
        for (int i = 0; i < n; i++) {
            // 判断队头是否已经滑出窗口
            if (hh <= tt && i - k + 1 > q[hh]) {
                hh++;
            }
            while (hh <= tt && a[q[tt]] >= a[i]) {
                tt--;
            }
            q[++tt] = i;
            if (i >= k - 1) {
                System.out.printf("%d ", a[q[hh]]);
            }
        }
        System.out.println();

        hh = 0;
        tt = -1;
        for (int i = 0; i < n; i++) {
            // 判断队头是否已经滑出窗口
            if (hh <= tt && i - k + 1 > q[hh]) {
                hh++;
            }
            while (hh <= tt && a[q[tt]] <= a[i]) {
                tt--;
            }
            q[++tt] = i;
            if (i >= k - 1) {
                System.out.printf("%d ", a[q[hh]]);
            }
        }
        System.out.println();

        out.flush();
        in.close();
        out.close();
    }
}
