package mathematic.gausseliminate;

import java.util.Scanner;

/**
 * @author LBS59
 * @description 高斯消元法求解多元一次线性方程组
 */
public class GaussLiminate {
    private static final int N = 110;
    /**
     * 浮点数判0可能存在精度问题
     */
    private static final double EPS = 1e-6;
    /**
     * a表示方程组的系数矩阵
     */
    private static double[][] a;

    static {
        a = new double[N][N];
    }

    private static void swap(double[][] a, int x1, int y1, int x2, int y2) {
        double temp = a[x1][y1];
        a[x1][y1] = a[x2][y2];
        a[x2][y2] = temp;
    }

    public static int gauss(int n) {
        int c, r;
        for (c = 0, r = 0; c < n; c++) {
            int t = r;
            // 找到从r行开始，当前所有列中系数绝对值最大的行
            for (int i = r; i < n; i++) {
                if (Math.abs(a[i][c]) > Math.abs(a[t][c])) {
                    t = i;
                }
            }
            // 如果当前列不存在最大的系数，没有更新，则直接处理下一列
            if (Math.abs(a[t][c]) < EPS) {
                continue;
            }
            // 将当前行替换为当前的第r行
            for (int i = c; i <= n; i++) {
                swap(a, t, i, r, i);
            }
            // 将当前行的c列系数替换为1
            for (int i = n; i >= c; i--) {
                a[r][i] /= a[r][c];
            }
            // 将当前所有未处理过的c列替换为0
            for (int i = r + 1; i < n; i++) {
                if (Math.abs(a[i][c]) > EPS) {
                    for (int j = n; j >= c; j--) {
                        a[i][j] -= a[r][j] * a[i][c];
                    }
                }
            }
            r++;
        }
        if (r < n) {
            for (int i = r; i < n; i++) {
                if (Math.abs(a[i][n]) > EPS) {
                    return 2;
                }
            }
            return 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                a[i][n] -= a[i][j] * a[j][n];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                a[i][j] = sc.nextDouble();
            }
        }
        int res = gauss(n);
        if (res == 0) {
            for (int i = 0; i < n; i++) {
                if (Math.abs(a[i][n]) < EPS) {
                    System.out.println("0.00");
                } else {
                    System.out.printf("%.2f\n", a[i][n]);
                }
            }
        }
    }
}
