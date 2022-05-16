package dp.lineardp.lus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author LBS59
 * @description 预处理优化版最长上升子序列
 */
public class LongestUpSequence2 {
    private static final int N = 1010;

    private static int[] a, q;

    static {
        a = new int[N];
        q = new int[N];
        q[0] = Integer.MIN_VALUE;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        String[] row = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(row[i]);
        }
        int len = 0;
        for (int i = 0; i < n; i++) {
            int l = 0, r = len;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (q[mid] < a[i]) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            len = Math.max(len, r + 1);
            q[r + 1] = a[i];
        }
        System.out.println(len);

        in.close();
    }
}
