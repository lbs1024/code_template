package dp.treedp.partywithoutboss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author LBS59
 * @description 树形dp解决没有上司的舞会问题
 */
public class PartyWithoutBoss {
    private static final int N = 6010;

    /**
     * 存储每一个人的快乐指数
     */
    private static int[] happy;
    /**
     * 散列表四件套
     */
    private static int[] e, ne, h;
    private static int idx;
    /**
     * 状态表示
     */
    private static int[][] f;
    /**
     * 存储当前节点是否有父节点，方便找到根节点
     */
    private static boolean[] hasFather;

    static {
        happy = new int[N];
        e = new int[N];
        ne = new int[N];
        h = new int[N];
        Arrays.fill(h, -1);
        idx = 0;
        f = new int[N][2];
        hasFather = new boolean[N];
    }

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private static void dfs(int u) {
        f[u][1] = happy[u];
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            dfs(j);
            f[u][0] += Math.max(f[j][0], f[j][1]);
            f[u][1] += f[j][0];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        for (int i = 1; i <= n; i++) {
            int hp = Integer.parseInt(in.readLine());
            happy[i] = hp;
        }
        for (int i = 0; i < n - 1; i++) {
            String[] row = in.readLine().split(" ");
            int a = Integer.parseInt(row[0]), b = Integer.parseInt(row[1]);
            // 标记a已经有父节点了
            hasFather[a] = true;
            // 添加一条b->a的边
            add(b, a);
        }
        int root = 1;
        // 寻找根节点，即没有父节点的节点
        while (hasFather[root]) {
            root++;
        }
        dfs(root);

        // 两种情况取较大者
        System.out.println(Math.max(f[root][0], f[root][1]));

        in.close();
    }
}
