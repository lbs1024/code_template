package dp.lineardp.numtriangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author LBS59
 * @description 线性dp解决数字三角形问题
 *     7
 *    3 8
 *   8 1 0
 *  2 7 4 4
 * 4 5 2 6 5
 */
public class DigitTriangle {
    private static final int N = 510, INF = Integer.MAX_VALUE;

    private static int[][] a;
    private static int[][] f;

    static {
        a = new int[N][N];
        f = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(f[i], -INF);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        for (int i = 1; i <= n; i++) {
            String[] row = in.readLine().split(" ");
            for (int j = 1; j <= i; j++) {
                a[i][j] = Integer.parseInt(row[j - 1]);
            }
        }
        f[1][1] = a[1][1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                f[i][j] = Math.max(f[i - 1][j - 1] + a[i][j], f[i - 1][j] + a[i][j]);
            }
        }
        int res = -INF;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, f[n][i]);
        }
        System.out.println(res);

        in.close();
    }
}
