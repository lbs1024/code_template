package mathematic.cathelin;

import java.util.Scanner;

/**
 * @author LBS59
 * @description 计算卡特兰数
 */
public class GetCathelin {
    private static final int MOD = (int) 1e9 + 7;

    private static int quickPower(int a, int k, int p) {
        long res = 1;
        long t = a;
        while (k > 0) {
            if ((k & 1) != 0) {
                res = res * t % p;
            }
            t = t * t % p;
            k >>= 1;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int res = 1;
        for (int i = n * 2; i > n; i--) {
            res = (int) ((long) res * i % MOD);
        }
        System.out.println(res);
        for (int i = 1; i <= n; i++) {
            res = (int) ((long) res * quickPower(i, MOD - 2, MOD) % MOD);
        }
        System.out.println(res);
        res = (int) ((long) res * quickPower(n + 1, MOD - 2, MOD) % MOD);
        System.out.println(res);
    }
}
