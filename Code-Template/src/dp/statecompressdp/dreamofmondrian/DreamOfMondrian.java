package dp.statecompressdp.dreamofmondrian;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LBS59
 * @description 状态压缩dp例题-蒙德里安的梦想
 */
public class DreamOfMondrian {
    private static final int N = 12, M = 1 << N;

    private static long[][] f;

    private static boolean[] st;

    static {
        f = new long[N][M];
        st = new boolean[M];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt(), m = sc.nextInt();
            if (n == 0 && m == 0) {
                break;
            }
            for (int i = 0; i < N; i++) {
                Arrays.fill(f[i], 0);
            }
            for (int i = 0; i < 1 << n; i++) {
                st[i] = true;
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if ((i >> j & 1) != 0) {
                        if ((cnt & 1) != 0) {
                            st[i] = false;
                            cnt = 0;
                        }
                    } else {
                        cnt++;
                    }
                }
                if ((cnt & 1) != 0) {
                    st[i] = false;
                }
            }
            f[0][0] = 1;
            for (int i = 1; i <= m; i++) {
                for (int j = 0; j < 1 << n; j++) {
                    for (int k = 0; k < 1 << n; k++) {
                        if ((j & k) == 0 && st[j | k]) {
                            f[i][j] += f[i - 1][k];
                        }
                    }
                }
            }
            System.out.println(f[m][0]);
        }
    }
}
