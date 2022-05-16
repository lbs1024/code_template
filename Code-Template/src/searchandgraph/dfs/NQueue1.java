package searchandgraph.dfs;

import java.io.*;

/**
 * @author LBS59
 * @description DFS模板问题-N皇后问题(1):按行枚举所有皇后
 */
public class NQueue1 {
    private static final int N = 20;
    static char[][] g = new char[N][N];
    static boolean[] visCol = new boolean[N], visDg = new boolean[N], visUdg = new boolean[N];

    /**
     * @param idx 搜索到idx层
     * @param n 总的皇后数量
     */
    private static void dfs(int idx, int n) {
        if (idx == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("%c", g[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            if (!visCol[i] && !visDg[idx + i] && !visUdg[n - idx + i]) {
                // 如果当前位置的列以及正副对角线都没有放其他皇后，则
                g[idx][i] = 'Q';
                visCol[i] = visDg[idx + i] = visUdg[n - idx + i] = true;
                dfs(idx + 1, n);
                visCol[i] = visDg[idx + i] = visUdg[n - idx + i] = false;
                g[idx][i] = '.';
            }
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
        dfs(0, n);

        out.flush();
        in.close();
        out.close();
    }
}
