package mathematic.extendgcd;

import java.io.*;

/**
 * @author LBS59
 * @description 扩展欧几里得算法求解裴蜀定理
 */
public class ExGcd {
    private static int x, y;

    public static void exGcd(int a, int b) {
        if (b == 0) {
            x = 1;
            y = 0;
            return;
        }
        exGcd(b, a % b);
        int temp = x;
        x = y;
        y = temp - a / b * y;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            String[] row = in.readLine().split(" ");
            int a = Integer.parseInt(row[0]), b = Integer.parseInt(row[1]);
            exGcd(a, b);
            out.write(x + " " + y + "\n");
        }

        out.flush();
        in.close();
        out.close();
    }
}
