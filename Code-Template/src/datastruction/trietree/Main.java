package datastruction.trietree;

import java.io.*;

class Trie {
    /**
     * son[i][j]记录第i层中j这个路径是否存在，大于0表示有路径
     */
    private final int[][] son;
    /**
     * cnt[i]表示以当前字符结尾的单词的个数
     */
    private final int[] cnt;
    /**
     * 当前所处的层
     */
    private int idx;

    public Trie(int n) {
        son = new int[n][26];
        cnt = new int[n];
        // 初始化根节点为第0层
        idx = 0;
    }

    /**
     * 向字典树中添加字符串s
     **/
    public void insert(String s) {
        // 从根节点开始查询
        int p = 0;
        char[] chs = s.toCharArray();
        for (char c : chs) {
            // 找到对应位置
            int u = c - 'a';
            if (son[p][u] == 0) {
                // 如果当前层没有对象字符，则创建并指向对应字符的路径
                son[p][u] = ++idx;
            }
            p = son[p][u];
        }
        // 将此位置单词数+1
        cnt[p]++;
    }

    /**
     * 查询字典树中有几个字符串s
     **/
    public int query(String s) {
        // 从根节点开始查询
        int p = 0;
        char[] chs = s.toCharArray();
        for (char c : chs) {
            // 获取字符对应下标
            int u = c - 'a';
            if (son[p][u] == 0) {
                return 0;
            }
            p = son[p][u];
        }
        return cnt[p];
    }
}

/**
 * @author LBS59
 * @description
 */
public class Main {
    private static final int N = 100010;

    public static void main(String [] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        Trie t = new Trie(N);
        for (int i = 0; i < n; i++) {
            String[] input = in.readLine().split(" ");
            if ("I".equals(input[0])) {
                t.insert(input[1]);
            } else {
                System.out.println(t.query(input[1]));
            }
        }

        out.flush();
        in.close();
        out.close();
    }
}
