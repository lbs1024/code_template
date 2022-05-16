package mathematic.quickmi;

import java.io.*;

/**
 * @author LBS59
 * @description 快速幂模板
 */
public class Qmi {
    public static int qMi(int a, int k, int p) {
        long res = 1;
        long t = a;
        while (k > 0) {
            if ((k & 1) > 0) {
                res = res * t % p;
            }
            k >>= 1;
            t = t * t % p;
        }
        return (int) res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            String[] row = in.readLine().split(" ");
            int a = Integer.parseInt(row[0]), k = Integer.parseInt(row[1]), p = Integer.parseInt(row[2]);
            out.write(qMi(a, k, p) + "\n");
        }

        out.flush();
        in.close();
        out.close();
    }
}
