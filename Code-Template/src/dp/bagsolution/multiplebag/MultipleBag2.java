package dp.bagsolution.multiplebag;

import java.util.Scanner;

/**
 * @author LBS59
 * @description 一维dp解决多重背包问题
 */
public class MultipleBag2 {
    private static final int N = 25000;

    private static int[] v, w;
    private static int[] f;

    static {
        v = new int[N];
        w = new int[N];
        f = new int[N];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), s = sc.nextInt();
            int k = 1;
            while (k <= s) {
                cnt++;
                v[cnt] = a * k;
                w[cnt] = b * k;
                s -= k;
                k <<= 1;
            }
            if (s > 0) {
                cnt++;
                v[cnt] = a * s;
                w[cnt] = b * s;
            }
        }
        n = cnt;
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= v[i]; j--) {
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }
        System.out.println(f[m]);
    }
}
