package mathematic.combination.getcombination2;

import java.io.*;

/**
 * @author LBS59
 * @description 求组合数问题
 */
public class GetCombination {
    private static final int N = 100010, MOD = (int) 1e9 + 7;

    /**
     * fact数组存放阶乘结果，infact存放逆元结果
     */
    private static int[] fact;
    private static int[] infact;

    static {
        fact = new int[N];
        infact = new int[N];
        fact[0] = infact[0] = 1;
        for (int i = 1; i < N; i++) {
            fact[i] = (int) (((long) fact[i - 1] * i) % MOD);
            infact[i] = (int) (((long) infact[i - 1] * quickPower(i, MOD - 2, MOD)) % MOD);
        }
    }

    private static int quickPower(int a, int k, int p) {
        long res = 1;
        long t = a;
        while (k > 0) {
            if ((k & 1) != 0) {
                res = res * t % MOD;
            }
            t = t * t % MOD;
            k >>= 1;
        }
        return (int) res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            String[] query = in.readLine().split(" ");
            int a = Integer.parseInt(query[0]), b = Integer.parseInt(query[1]);
            out.write((int) ((((long) fact[a] * infact[a - b] % MOD) * infact[b]) % MOD) + "\n");
        }

        out.flush();
        in.close();
        out.close();
    }
}
