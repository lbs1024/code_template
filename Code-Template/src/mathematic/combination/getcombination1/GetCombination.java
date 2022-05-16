package mathematic.combination.getcombination1;

import java.io.*;

/**
 * @author LBS59
 * @description 求组合数问题：给定a，b，求a对b的组合数，最后对1e9+7取模
 */
public class GetCombination {
    private static final int N = 2010, MOD = (int) 1e9 + 7;

    private static int[][] c;

    static {
        c = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    c[i][j] = 1;
                } else {
                    c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % MOD;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            String[] query = in.readLine().split(" ");
            int a = Integer.parseInt(query[0]), b = Integer.parseInt(query[1]);
            out.write(c[a][b] + "\n");
        }

        out.flush();
        in.close();
        out.close();
    }
}
