package dp.countingdp.digitdiv;

import java.util.Scanner;

/**
 * @author LBS59
 * @description 玄学法求解整数划分问题
 */
public class IntDivide2 {
    private static final int N = 1010, MOD = (int) 1e9 + 7;

    private static int[][] f;

    static {
        f = new int[N][N];
        f[0][0] = 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                f[i][j] = (f[i - 1][j - 1] + f[i - j][j]) % MOD;
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = (res + f[n][i]) % MOD;
        }
        System.out.println(res);
    }
}
