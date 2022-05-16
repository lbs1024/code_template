package dp.bagsolution.multiplebag;

import java.util.Scanner;

/**
 * @author LBS59
 * @description 二维dp解决多重背包问题
 */
public class MultipleBag1 {
    private static final int N = 110;

    private static int[] v, w, s;
    private static int[][] f;

    static {
        v = new int[N];
        w = new int[N];
        s = new int[N];
        f = new int[N][N];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            s[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= s[i] && k * v[i] <= j; k++) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - v[i] * k] + w[i] * k);
                }
            }
        }
        System.out.println(f[n][m]);
    }
}
