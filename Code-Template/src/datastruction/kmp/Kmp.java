package datastruction.kmp;

import java.io.*;

/**
 * @author LBS59
 * @description KMP字符串匹配算法模板 --- 这里下标从1开始
 */
public class Kmp {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        // p为匹配串-一般较短
        int n = Integer.parseInt(in.readLine());
        String p = in.readLine();
        char[] pcs = new char[n + 1];
        for (int i = 1; i <= n; i++) {
            pcs[i] = p.charAt(i - 1);
        }

        // m为模式串-一般较长
        int m = Integer.parseInt(in.readLine());
        String s = in.readLine();
        char[] scs = new char[m + 1];
        for (int i = 1; i <= m; i++) {
            scs[i] = s.charAt(i - 1);
        }

        // 求next数组
        int[] next = new int[n + 1];
        for (int i = 2, j = 0; i <= n; i++) {
            while (j > 0 && pcs[i] != pcs[j + 1]) {
                j = next[j];
            }
            if (pcs[i] == pcs[j + 1]) {
                j++;
            }
            next[i] = j;
        }

        // KMP匹配过程
        for (int i = 1, j = 0; i <= m; i++) {
            while (j > 0 && scs[i] != pcs[j + 1]) {
                j = next[j];
            }
            if (scs[i] == pcs[j + 1]) {
                j++;
            }
            if (j == n) {
                out.write(i - n + " ");
                // 完全匹配后继续搜索
                j = next[j];
            }
        }


        out.flush();
        in.close();
        out.close();
    }
}
