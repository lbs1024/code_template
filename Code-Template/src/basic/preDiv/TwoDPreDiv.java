package basic.preDiv;

import java.io.*;

/**
 * @author LBS59
 * @description 二维差分数组模板
 */
public class TwoDPreDiv {
    private static final int N = 1010;
    static int[][] temp = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = in.readLine().split(" ");
        int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]), q = Integer.parseInt(input[2]);
        temp = new int[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            String[] row = in.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                int cur = Integer.parseInt(row[j - 1]);
                insert(i, j, i, j, cur);
            }
        }
        for (int i = 0; i < q; i++) {
            String[] query = in.readLine().split(" ");
            int x1 = Integer.parseInt(query[0]), y1 = Integer.parseInt(query[1]), x2 = Integer.parseInt(query[2]), y2 = Integer.parseInt(query[3]), c = Integer.parseInt(query[4]);
            insert(x1, y1, x2, y2, c);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                temp[i][j] += temp[i - 1][j] + temp[i][j - 1] - temp[i - 1][j - 1];
                out.write(temp[i][j] + " ");
            }
            out.write("\n");
        }
        out.flush();
        in.close();
        out.close();
    }

    private static void insert(int x1, int y1, int x2, int y2, int c) {
        temp[x1][y1] += c;
        temp[x1][y2 + 1] -= c;
        temp[x2 + 1][y1] -= c;
        temp[x2 + 1][y2 + 1] += c;
    }
}
