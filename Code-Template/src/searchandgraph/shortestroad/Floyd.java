package searchandgraph.shortestroad;

import java.io.*;

/**
 * @author LBS59
 * @description Floyd算法：解决多源最短路问题
 */
public class Floyd {
    private static final int N = 210, INF = 0x3f3f3f3f;

    private static int[][] dist;

    static {
        dist = new int[N][N];
    }

    public static void floyd(int n) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]), k = Integer.parseInt(s[2]);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        while (m-- > 0) {
            String[] row = in.readLine().split(" ");
            int a = Integer.parseInt(row[0]), b = Integer.parseInt(row[1]), c = Integer.parseInt(row[2]);
            dist[a][b] = Math.min(dist[a][b], c);
        }

        floyd(n);

        while (k-- > 0) {
            String[] q = in.readLine().split(" ");
            int i = Integer.parseInt(q[0]), j = Integer.parseInt(q[1]);
            if (dist[i][j] > INF / 2) {
                out.write("impossible\n");
            } else {
                out.write(dist[i][j] + "\n");
            }
        }

        out.flush();
        in.close();
        out.close();
    }
}
