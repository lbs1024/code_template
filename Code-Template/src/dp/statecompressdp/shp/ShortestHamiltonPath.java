package dp.statecompressdp.shp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LBS59
 * @description 状态压缩dp解决最短Hamilton路径问题
 */
public class ShortestHamiltonPath {
    private static final int N = 20, M = 1 << N, INF = 0x3f3f3f3f;
    /**
     * 记录边权
     */
    private static int[][] w;
    /**
     * 记录状态，f[i][j]表示，从0到达j，并且状态为i的最短Hamilton路径
     */
    private static int[][] f;

    static {
        w = new int[N][N];
        f = new int[M][N];
        // 初始化所有的状态的Hamilton路径为无穷，
        for (int i = 0; i < M; i++) {
            Arrays.fill(f[i], INF);
        }
        // f[1][0]表示从0到达0，没有经过任何边，状态为1，则Hamilton路径为0
        f[1][0] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                w[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                // 如果可以从i到达j
                if ((i >> j & 1) != 0) {
                    // 遍历中间结点k，表示从i可以不经过j到达k并且从k可以一步直接到达j
                    for (int k = 0; k < n; k++) {
                        // i不经过j可以到达k
                        if (((i - (1 << j)) >> k & 1) != 0) {
                            f[i][j] = Math.min(f[i][j], f[i - (1 << j)][k] + w[k][j]);
                        }
                    }
                }
            }
        }
        // 应该输出的是从0达到n - 1并且经过所有结点的最短路径
        System.out.println(f[(1 << n) - 1][n - 1]);
    }
}
