package datastruction.heap;

/**
 * @author LBS59
 * @description 带有映射关系的堆
 */
public class MyHeap {
    /**
     * h存储队中节点的值，ph表示从指针到堆的映射，hp表示从堆到指针的映射
     */
    int[] h, ph, hp;
    /**
     * size表示当前队中存储节点的个数
     */
    int size;

    public MyHeap(int n) {
        h = new int[n];
        ph = new int[n];
        hp = new int[n];
        size = 0;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void heapSwap(int a, int b) {
        swap(ph, hp[a], hp[b]);
        swap(hp, a, b);
        swap(h, a, b);
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
            heapSwap(u, t);
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
            heapSwap(u / 2, u);
            u /= 2;
        }
    }

    public static void main(String[] args) {

    }
}
