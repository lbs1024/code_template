package datastruction.heap;

import java.io.*;
import java.util.Arrays;

class Heap {
    int[] h;
    int size;

    public Heap(int n) {
        h = new int[n];
        size = 0;
    }

    /**
     * 堆向下调整操作
     * @param u 待调整位置
     */
    public void down(int u) {
        // 使用t来记录当前位置和其左/右儿子中最小值的位置
        int t = u;
        // 如果存在左儿子并且左儿子更小，则较小位置更新
        if (u * 2 <= size && h[u * 2] < h[t]) {
            t = u * 2;
        }
        // 如果存在右儿子并且右儿子更小，则较小位置更新
        if (u * 2 + 1 <= size && h[u * 2 + 1] < h[t]) {
            t = u * 2 + 1;
        }
        // 如果存在儿子位置变动
        if (u != t) {
            // 则将最小值交换至根位置，确保堆的性质，交换后的t位置为原来根的位置，递归处理即可
            int temp = h[u];
            h[u] = h[t];
            h[t] = temp;
            down(t);
        }
    }

    /**
     * 堆向上调整操作
     * @param u 待调整位置
     */
    public void up(int u) {
        // 如果当前位置存在父节点并且父节点的值大于当前值，则交换父子节点的值，并且继续向上调整
        while (u / 2 > 0 && h[u] < h[u / 2]) {
            int temp = h[u / 2];
            h[u / 2] = h[u];
            h[u] = temp;
            u /= 2;
        }
    }
}

/**
 * @author LBS59
 * @description 数组实现堆模板
 */
public class Main {
    private static final int N = 100010;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
        int[] arr = new int[n];
        String[] s1 = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }
        for (int i = 0; i < n; i++) {
            out.write(arr[i] + " ");
        }

        out.flush();
        in.close();
        out.close();
    }
}
