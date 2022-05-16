package datastruction.hashmap;

import java.io.*;


/**
 * @author LBS59
 * @description 字符串哈希处理
 */
public class Main3 {
    private static final int P = 131;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
        String str = in.readLine();
        long[] h = new long[n + 10];
        long[] p = new long[n + 10];
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] * P;
            h[i] = h[i - 1] * P + str.charAt(i - 1);
        }
        while (m-- > 0) {
            s = in.readLine().split(" ");
            int l1 = Integer.parseInt(s[0]), r1 = Integer.parseInt(s[1]);
            int l2 = Integer.parseInt(s[2]), r2 = Integer.parseInt(s[3]);
            boolean flag = h[r1] - h[l1 - 1] * p[r1 - l1 + 1] == h[r2] - h[l2 - 1] * p[r2 - l2 + 1];
            out.write(flag ? "Yes" : "No");
        }

        out.flush();
        in.close();
        out.close();
    }
}
