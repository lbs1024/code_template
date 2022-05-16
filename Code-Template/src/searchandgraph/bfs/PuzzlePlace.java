package searchandgraph.bfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LBS59
 * @description BFS模板及解决问题-走迷宫问题
 */
public class PuzzlePlace {
    private static final int N = 110;
    static int[][] g = new int[N][N], d = new int[N][N];
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    private static int bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        d[0][0] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = cur[0] + dx[i], y = cur[1] + dy[i];
                if (x >= 0 && x < row && y >= 0 && y < col && g[x][y] == 0 && d[x][y] == -1) {
                    d[x][y] = d[cur[0]][cur[1]] + 1;
                    q.offer(new int[] {x, y});
                }
            }
        }
        return d[row - 1][col - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strs = in.readLine().split(" ");
        int n = Integer.parseInt(strs[0]), m = Integer.parseInt(strs[1]);
        for (int i = 0; i < n; i++) {
            String[] col = in.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                g[i][j] = Integer.parseInt(col[j]);
            }
        }
        for (int i = 0; i < N; i++) {
            Arrays.fill(d[i], -1);
        }
        System.out.println(bfs(n, m));

        out.flush();
        in.close();
        out.close();
    }
}
