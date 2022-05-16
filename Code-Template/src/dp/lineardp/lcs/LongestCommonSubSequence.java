package dp.lineardp.lcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author LBS59
 * @description 动态规划解决最长公共子序列问题
 */
public class LongestCommonSubSequence {
    private static final int N = 1010;

    private static int[][] f;

    static {
        f = new int[N][N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
        String a = in.readLine();
        String b = in.readLine();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                f[i + 1][j + 1] = Math.max(f[i][j + 1], f[i + 1][j]);
                if (a.charAt(i) == b.charAt(j)) {
                    f[i + 1][j + 1] = Math.max(f[i + 1][j + 1], f[i][j] + 1);
                }
            }
        }
        System.out.println(f[n][m]);

        in.close();
    }
}
