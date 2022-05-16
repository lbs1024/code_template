package dp.countingdp.digitdiv;

import java.util.Scanner;

/**
 * @author LBS59
 * @description 整数划分问题--完全背包方法求解
 */
public class IntDivide1 {
    private static final int N = 1010, MOD = (int) 1e9 + 7;

    private static int[] f;

    static {
        f = new int[N];
        f[0] = 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                f[j] = (f[j] + f[j - i]) % MOD;
            }
        }
        System.out.println(f[n]);
    }
}
