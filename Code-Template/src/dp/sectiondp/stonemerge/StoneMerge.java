package dp.sectiondp.stonemerge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author LBS59
 * @description 区间dp解决石子合并问题
 */
public class StoneMerge {
    private static final int N = 310;

    private static int[] s;
    private static int[][] f;

    static {
        s = new int[N];
        f = new int[N][N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] row = in.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            s[i] = Integer.parseInt(row[i - 1]);
            s[i] += s[i - 1];
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int r = i + len - 1;
                f[i][r] = Integer.MAX_VALUE;
                for (int k = i; k < r; k++) {
                    f[i][r] = Math.min(f[i][r], f[i][k] + f[k + 1][r] + s[r] - s[i - 1]);
                }
            }
        }
        System.out.println(f[1][n]);
    }
}
