package mathematic.quickmi;

import java.io.*;

/**
 * @author LBS59
 * @description 使用快速幂求逆元
 */
public class GetInverseElByQmi {
    public static int quickMi(int a, int k, int p) {
        long res = 1;
        while (k > 0) {
            if ((k & 1) > 0) {
                res = res * (long) a % p;
            }
            k >>= 1;
            a = (int) (((long) a * a) % p);
        }
        return (int) res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            String[] q = in.readLine().split(" ");
            int a = Integer.parseInt(q[0]), p = Integer.parseInt(q[1]);
            int res = quickMi(a, p - 2, p);
            if (a % p > 0) {
                out.write(res + "\n");
            }
        }

        out.flush();
        in.close();
        out.close();
    }
}
