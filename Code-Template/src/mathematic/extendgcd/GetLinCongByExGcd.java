package mathematic.extendgcd;

import java.io.*;

/**
 * @author LBS59
 * @description 使用扩展的欧几里得算法求解线性同余方程
 */
public class GetLinCongByExGcd {
    private static int x, y;

    public static int exGcd(int a, int b) {
        if (b == 0) {
            x = 1;
            y = 0;
            return a;
        }
        int d = exGcd(b, a % b);
        int temp = x;
        x = y;
        y = temp - a / b * y;
        return d;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            String[] row = in.readLine().split(" ");
            int a = Integer.parseInt(row[0]), b = Integer.parseInt(row[1]), m = Integer.parseInt(row[2]);
            int d = exGcd(a, m);
            if (b % d > 0) {
                out.write("impossible\n");
            } else {
                out.write(((long) x * (b / d)) % m + "\n");
            }
        }

        out.flush();
        in.close();
        out.close();
    }
}
