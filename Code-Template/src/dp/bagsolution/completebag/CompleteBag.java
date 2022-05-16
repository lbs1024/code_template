package dp.bagsolution.completebag;

import java.util.Scanner;

/**
 * @author LBS59
 * @description 一维dp解决完全背包问题
 */
public class CompleteBag {
    private static final int N = 1010;

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
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        // f[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = v[i]; j <= m; j++) {
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }
        System.out.println(f[m]);
    }
}
