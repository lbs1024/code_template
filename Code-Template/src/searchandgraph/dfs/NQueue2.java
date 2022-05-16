package searchandgraph.dfs;

import java.io.*;

/**
 * @author LBS59
 * @description DFS模板问题-N皇后问题(1):按每一个格子枚举皇后
 */
public class NQueue2 {
    private static final int N = 20;
    static char[][] g = new char[N][N];
    static boolean[] visRow = new boolean[N], visCol = new boolean[N], visDg = new boolean[N], visUdg = new boolean[N];

    /**
     * @param x 搜索位置横坐标
     * @param y 搜索位置纵坐标
     * @param cnt 当前皇后的数量
     * @param n 总共的皇后数量
     */
    private static void dfs(int x, int y, int cnt, int n) {
        // 当前行走到了尽头
        if (y == n) {
            y = 0;
            x++;
        }
        // 如果搜索到最后一行并且皇后数量放置到n个
        if (x == n && cnt == n) {
            for (int i = 0; i < n; i++) {
                System.out.printf("%s", String.valueOf(g[i]));
                System.out.println();
            }
            System.out.println();
            return;
        }
        // 当前位置不放置皇后
        dfs(x, y + 1, cnt, n);
        // 当前位置放置皇后
        if (!visRow[x] && !visCol[y] && !visDg[x + y] && !visUdg[x - y + n]) {
            // 当前位置不冲突
            g[x][y] = 'Q';
            visRow[x] = visCol[y] = visDg[x + y] = visUdg[x - y + n] = true;
            // 寻找下一个皇后的位置
            dfs(x, y + 1, cnt + 1, n);
            // 回溯，恢复现场

            visRow[x] = visCol[y] = visDg[x + y] = visUdg[x - y + n] = false;
            g[x][y] = '.';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = '.';
            }
        }
        dfs(0, 0, 0, n);

        out.flush();
        in.close();
        out.close();
    }
}
