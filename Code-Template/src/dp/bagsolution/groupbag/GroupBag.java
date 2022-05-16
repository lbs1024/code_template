package dp.bagsolution.groupbag;

import java.util.Scanner;

/**
 * @author LBS59
 * @description dp解决分组背包问题
 */
public class GroupBag {
    private static final int N = 110;

    private static int[][] v, w;
    private static int[] s;
    private static int[] f;

    static {
        v = new int[N][N];
        w = new int[N][N];
        s = new int[N];
        f = new int[N];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            s[i] = sc.nextInt();
            for (int j = 0; j < s[i]; j++) {
                v[i][j] = sc.nextInt();
                w[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 0; j--) {
                for (int k = 0; k < s[i]; k++) {
                    if (v[i][k] <= j) {
                        f[j] = Math.max(f[j], f[j - v[i][k]] + w[i][k]);
                    }
                }
            }
        }
        System.out.println(f[m]);
    }
}
