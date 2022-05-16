package dp.bagsolution.zeroandonebag;

import java.util.Scanner;

/**
 * @author LBS59
 * @description 动态规划求解0-1背包问题
 * f[i][j]表示从前i个物品中挑选物品，并且总体积不超过j的所有方案中的最大价值
 * f[i][i] = max(f[i - 1][j], f[i - 1][j - v[i]] + w[i])
 * 注意第二项可能不满足条件，只有当前的j大于需要装的第i个物品的体积时才会取较大者
 */
public class ZeroAndOneBag1 {
    private static final int N = 1010;

    private static int[] v, w;
    private static int[][] f;

    static {
        v = new int[N];
        w = new int[N];
        f = new int[N][N];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        // f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= v[i]) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - v[i]] + w[i]);
                }
            }
        }
        System.out.println(f[n][m]);
    }
}
