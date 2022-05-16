package searchandgraph.dfs;

import java.io.*;
import java.util.Scanner;

/**
 * @author LBS59
 * @description DFS模板问题-全排列
 */
public class Permutation {
    private static final int N = 10;
    private static int[] path = new int[N];
    private static boolean[] visited = new boolean[N];

    private static void dfs(int idx, int n) {
        if (idx == n) {
            for (int i = 0; i < n; i++) {
                System.out.printf("%d ", path[i]);
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                // 如果当前路径未走过，则以当前数字作为当前位置
                path[idx] = i;
                visited[i] = true;
                // 寻找下一层位置和数字
                dfs(idx + 1, n);
                // 回溯，恢复现场
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        dfs(0, n);

        out.flush();
        in.close();
        out.close();
    }
}
