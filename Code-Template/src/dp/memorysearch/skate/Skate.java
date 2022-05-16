package dp.memorysearch.skate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author LBS59
 * @description 记忆化搜索+dp解决滑雪问题
 */
public class Skate {
    private static final int N = 310;
    /**
     * 存储每一个位置的高度
     */
    private static int[][] h;
    /**
     * 存储每一个位置的状态
     */
    private static int[][] f;
    /**
     * 上下左右方向标识
     */
    private static final int[][] DIR = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static {
        h = new int[N][N];
        f = new int[N][N];
        //  -1表示当前位置没有处理过
        for (int i = 0; i < N; i++) {
            Arrays.fill(f[i], -1);
        }
    }

    private static int dp(int x, int y, int n, int m) {
        if (f[x][y] != -1) {
            return f[x][y];
        }
        f[x][y] = 1;
        for (int[] d : DIR) {
            int a = x + d[0], b = y + d[1];
            if (a >= 1 && a <= n && b >= 1 && b <= m && h[a][b] < h[x][y]) {
                f[x][y] = Math.max(f[x][y], dp(a, b, n, m) + 1);
            }
        }
        return f[x][y];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
        for (int i = 1; i <= n; i++) {
            String[] row = in.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                h[i][j] = Integer.parseInt(row[j - 1]);
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                res = Math.max(res, dp(i, j, n, m));
            }
        }
        System.out.println(res);

        in.close();
    }
}
