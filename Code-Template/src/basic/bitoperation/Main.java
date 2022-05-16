package basic.bitoperation;

import java.io.*;

/**
 * @author LBS59
 * @description 二进制模板使用
 */
public class Main {
    /**
     * 返回一个整数二进制表示中第k位是1还是0(这里k从0开始，从二进制表示的个位算起)
     * @return 结果
     */
    public static int getkBit(int x, int k) {
        return x >> k & 1;
    }

    /**
     * 返回整数二进制表示中最低位的1的结果
     * @param x 整数x
     * @return 表达形式为最低位的二进制结果
     */
    public static int lowBit(int x) {
        return x & -x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        String[] split = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(split[i]);
            int res = 0;
            while (x > 0) {
                x -= lowBit(x);
                res++;
            }
            out.write(res + " ");
        }
        out.flush();
        in.close();
        out.close();
    }
}
