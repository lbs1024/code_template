package datastruction.unfind;

import javax.script.ScriptEngineManager;
import java.io.*;

/**
 * 并查集模板 --- 路径压缩+连通分量中节点个数统计
 */
class UF {
    /**
     * 记录每一个节点的父亲节点
     */
    int[] parent, size;

    public UF(int n) {
        parent = new int[n];
        size = new int[n];
    }

    /**
     * 获取x的祖宗节点 + 路径压缩
     * @param x 查询节点
     * @return 子树编号
     */
    public int find(int x) {
        return parent[x] == x ? parent[x] : find(parent[x]);
    }

    /**
     * 合并两个子树
     */
    public void union(int a, int b) {
        if (find(a) != find(b)) {
            size[find(b)] += size[find(a)];
            parent[find(a)] = find(b);
        }
    }
}

/**
 * @author LBS59
 * @description 并查集例题
 */
public class Main {
    private static final int N = 100010;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = in.readLine().split(" ");
        int n = Integer.parseInt(s1[0]), m = Integer.parseInt(s1[1]);
        UF uf = new UF(N);
        for (int i = 1; i <= n; i++) {
            uf.parent[i] = i;
            uf.size[i] = 1;
        }
        for (int i = 0; i < m; i++) {
            String[] input = in.readLine().split(" ");
            String op = input[0];
            int a = Integer.parseInt(input[1]), b = Integer.parseInt(input[2]);
            if ("M".equals(op)) {
                uf.union(a, b);
            } else {
                System.out.println(uf.find(a) == uf.find(b) ? "Yes" : "No");
            }
        }

        out.flush();
        in.close();
        out.close();
    }
}
