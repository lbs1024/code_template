import java.util.*;

/**
 * @author lbs
 * @description leetcode刷题
 */
class Solution {
    /**
     * @Author LBS59
     * @Description 单链表的实现
     * @Date 11:30 2022/5/31
     **/
    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * @Author LBS59
     * @Description 二叉树实现
     * @Date 11:27 2022/5/31
     **/
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * @Author LBS59
     * @Description 多叉树实现
     * @Date 11:27 2022/5/31
     **/
    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    /**
     * @Author LBS59
     * @Description 快排和归并模板
     * @Date 11:28 2022/5/31
     **/
    private static class Sort {
        int n;
        int[] arr, tmp;

        public Sort(int n) {
            this.n = n;
            arr = new int[n];
            tmp = new int[n];
        }

        /**
         * 快排模版
         * @param l 左边界
         * @param r 右边界
         */
        public void quickSort(int l, int r) {
            if (l >= r) {
                return;
            }
            int x = arr[l], i = l - 1, j = r + 1;
            while (i < j) {
                do {
                    i++;
                } while (arr[i] < x);
                do {
                    j--;
                } while (arr[j] > x);
                if (i < j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            quickSort(l, j);
            quickSort(j + 1, r);
        }

        /**
         * 归并排序模版
         * @param l 左边界
         * @param r 有边界
         */
        public void mergeSort(int l, int r) {
            if (l >= r) {
                return;
            }
            int mid = l + r >> 1;
            mergeSort(l, mid);
            mergeSort(mid + 1, r);
            // 这里k表示需要放置元素的下表，i表示左区间的第一个下标，j表示右区间的第一个下标
            int k = 0, i = l, j = mid + 1;
            while (i <= mid && j <= r) {
                if (arr[i] <= arr[j]) {
                    tmp[k++] = arr[i++];
                } else {
                    tmp[k++] = arr[j++];
                }
            }
            // 处理未处理完的区间:两个while循环只会执行一个
            while (i <= mid) {
                tmp[k++] = arr[i++];
            }
            while (j <= r) {
                tmp[k++] = arr[j++];
            }
            // 将排序好的部分覆盖回原来的arr数组
            for (int q = l, w = 0; q <= r; q++, w++) {
                arr[q] = tmp[w];
            }
        }
    }

    /**
     * @Author LBS59
     * @Description 二分搜索模板
     * @Date 11:28 2022/5/31
     **/
    private static class BinarySearch {
        private static final int N = 100010;
        private int[] arr = new int[N];

        private boolean check(int a, int b) {
            /*
            自定义比较关系
             */
            return true;
        }

        /**
         * 二分第一个模板，注意看mid的取值
         * @param l 左边界
         * @param r 有边界
         * @param target 目标值
         * @return 目标值所在下标
         */
        public int binarySearch1(int l, int r, int target) {
            while (l < r) {
                // 看这里
                int mid = l + r >> 1;
                if (check(arr[mid], target)) {
                    // 看这里
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }

        /**
         * 二分第二个模板，注意看mid的取值
         * @param l 左边界
         * @param r 有边界
         * @param target 目标值
         * @return 目标值所在下标
         */
        public int binarySearch2(int l, int r, int target) {
            while (l < r) {
                // 看这里
                int mid = l + r + 1 >> 1;
                if (check(arr[mid], target)) {
                    // 看这里
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            return l;
        }
    }

    /**
     * @Author LBS59
     * @Description 前缀和模板
     * @Date 11:28 2022/5/31
     **/
    private static class PreSum {
        /**
         * 一维前缀和
         * @param nums 原数组
         * @return 前缀和数组
         */
        public int[] preSum1(int[] nums) {
            int n = nums.length;
            int[] pre = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                pre[i] = pre[i - 1] + nums[i - 1];
            }
            int[] res = new int[n];
            for (int i = 1; i <= n; i++) {
                res[i] = pre[i + 1];
            }
            return res;
        }

        /**
         * 二维前缀和
         * @param nums 原数组
         */
        public int[][] preSum1(int[][] nums) {
            int m = nums.length, n = nums[0].length;
            int[][] pre = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    pre[i][j] += pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + nums[i - 1][j - 1];
                }
            }
            int[][] res = new int[m][n];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    res[i][j] = pre[i - 1][j - 1];
                }
            }
            return res;
        }
    }

    /**
     * @Author LBS59
     * @Description 差分和模板:通过差分数组求前缀和数组可以得到原数组
     * @Date 11:29 2022/5/31
     **/
    private static class DivSum {
        private void insert1(int[] arr, int l, int r, int c) {
            arr[l] += c;
            arr[r + 1] -= c;
        }

        /**
         * 一维差分数组
         * @param nums 原数组
         * @return 差分数组
         */
        public int[] divSum1(int[] nums) {
            int n = nums.length;
            int[] div = new int[n + 1];
            for (int i = 0; i < n; i++) {
                insert1(div, i + 1, i + 1, nums[i]);
            }
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] = div[i];
            }
            return res;
        }

        private void insert2(int[][] arr, int x1, int x2, int y1, int y2, int c) {
            arr[x1][x2] += c;
            arr[x1][y2 + 1] -= c;
            arr[x2 + 1][y1] -= c;
            arr[x2 + 1][y2 + 1] += c;
        }

        /**
         * 二维差分数组
         * @param nums 原数组
         * @return 差分数组
         */
        public int[][] divSum2(int[][] nums) {
            int m = nums.length, n = nums[0].length;
            int[][] div = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    insert2(div, i, i, j, j, nums[i][j]);
                }
            }
            int[][] res = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    res[i][j] = div[i][j];
                }
            }
            return res;
        }
    }

    /**
     * @Author LBS59
     * @Description 二进制位运算模板
     * @Date 11:29 2022/5/31
     **/
    private static class BitOperation {
        /**
         * 求整数n二进制表示中从低到高第k位是0还是1
         * @param n 整数
         * @param k 位数
         * @return 0/1
         */
        public int val(int n, int k) {
            return (n >> k) & 1;
            // return n & (1 << k);
        }

        /**
         * 求整数n二进制表示中最后一位1的位置，这里用值表示，如1表示第0位，2表示第一位，以此类推
         * @param n 整数
         * @return 2^(位数)
         */
        public int lowBit(int n) {
            return n & -n;
        }
    }

    /**
     * @Author LBS59
     * @Description 区间合并模板
     * @Date 11:29 2022/5/31
     **/
    private static class MergeIntervals {
        private static final int INF = Integer.MIN_VALUE;
        /**
         * 区间合并
         * @param intervals 待合并区间
         * @return 合并后的所有区间
         */
        public List<int[]> mergeIntervals(int[][] intervals) {
            // 按区间左端点排序
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
            List<int[]> res = new ArrayList<>();
            // 设定起始区间位置为负无穷
            int st = INF, ed = INF;
            for (int[] interval : intervals) {
                if (st == INF && ed == INF) {
                    st = interval[0];
                    ed = interval[1];
                } else {
                    // 当前区间左端点小于ed，说明二者之间有交集，更新右边界即可
                    if (interval[0] <= ed) {
                        ed = Math.max(ed, interval[1]);
                    } else {
                        // 无交集，产生了一个新区间
                        res.add(new int[] {st, ed});
                        st = interval[0];
                        ed = interval[1];
                    }
                }
            }
            // 最后剩余一个单独的区间，添加到res中
            if (st != INF && ed != INF) {
                res.add(new int[] {st, ed});
            }
            return res;
        }
    }

    /**
     * @Author LBS59
     * @Description 单调栈和单调队列模板
     * @Date 11:37 2022/5/31
     **/
    private static class StackAndQueue {
        /**
         * 单调栈实现：这里实现的内容为寻找数组中每一个元素左边离自己最近并且比自己小的元素，不存在设为-1
         * @param nums 数组
         * @return 较小值数组
         */
        public int[] getLeftMin(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    res[i] = -1;
                } else {
                    res[i] = stack.peek();
                }
                stack.push(nums[i]);
            }
            return res;
        }

        /**
         * 单调队列实现：这里实现的内容找出长度为k的子数组中的最小值
         * @param nums 数组
         * @param k 区间长度
         * @return 区间最小值集合
         */
        public List<Integer> getMin(int[] nums, int k) {
            int n = nums.length;
            List<Integer> res = new ArrayList<>();
            // 队列中存储的为下标
            Deque<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if (!queue.isEmpty() && i - k + 1 > queue.peekFirst()) {
                    queue.pollFirst();
                }
                while (!queue.isEmpty() && nums[queue.peekLast()] >= nums[i]) {
                    queue.pollLast();
                }
                queue.offerLast(i);
                if (i >= k - 1) {
                    res.add(nums[queue.peekFirst()]);
                }
            }
            return res;
        }
    }

    /**
     * @Author LBS59
     * @Description 字典树实现
     * @Date 11:32 2022/5/31
     **/
    private static class Trie {
        private int[][] son;
        private int[] cnt;
        private int idx;

        public Trie(int n) {
            son = new int[n][26];
            cnt = new int[n];
            idx = 0;
        }

        /**
         * 将字符串s插入到字典树中
         * @param s 字符串
         */
        public void insert(String s) {
            // 从根节点开始
            int p = 0;
            for (char c : s.toCharArray()) {
                // 获取在当前层的下标
                int u = c - 'a';
                if (son[p][u] == 0) {
                    // 如果当前位置不存在，则创建该分支
                    son[p][u] = ++idx;
                }
                // 跳到该分支
                p = son[p][u];
            }
            // 字符串s的个数自增
            cnt[p]++;
        }

        /**
         * 查询字典树中存在字符串s的个数
         * @param s
         * @return
         */
        public int query(String s) {
            // 从根节点开始
            int p = 0;
            for (char c : s.toCharArray()) {
                // 获取当前层对应下标
                int u = c - 'a';
                if (son[p][u] == 0) {
                    // 如果当前分支不存在，则说明字典树中不存在当前字符串，直接返回
                    return 0;
                }
                // 跳到该分支
                p = son[p][u];
            }
            return cnt[p];
        }
    }

    /**
    * @Author LBS59
    * @Description 并查集实现
    * @Date 11:43 2022/5/31
    **/
    private static class UnionFind {
        int[] parent, size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int a, int b) {
            if (find(a) != find(b)) {
                size[find(b)] += size[find(a)];
                parent[find(a)] = find(b);
            }
        }
    }

    /**
    * @Author LBS59
    * @Description 自定义堆
    * @Date 11:53 2022/5/31
    **/
    private static class MyHeap {
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
    }

    /**
    * @Author LBS59
    * @Description 自定义哈希表
    * @Date 11:43 2022/5/31
    **/
    private static class MyHashMap {
        private static final int N = 100003;
        int[] h, e, ne;
        int idx;

        public MyHashMap() {
            h = new int[N];
            Arrays.fill(h, -1);
            e = new int[N];
            ne = new int[N];
            idx = 0;
        }

        public void insert(int x) {
            int hash = (x % N + N) % N;
            e[idx] = x;
            ne[idx] = h[hash];
            h[hash] = idx++;
        }

        public boolean find(int x) {
            int hash = (x % N + N) % N;
            for (int i = h[hash]; i != -1 ; i = ne[i]) {
                if (e[i] == x) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
    * @Author LBS59
    * @Description 自定义存储有向图的临街表
    * @Date 11:44 2022/5/31
    **/
    private static class Adjacent {
        private static final int N = 100010;
        private static final int M = N * 2;
        /**
         * 散列表四件套
         */
        int[] h, e, ne;
        int idx;
        /**
         * 判重
         */
        private final boolean[] vis;

        /**
         * bfs可以计算0-1图的最短路径
         */
        private final int[] dis;

        /**
         * 拓扑排序
         */
        int n;
        int cnt;
        int[] res;


        public Adjacent(int n) {
            h = new int[N];
            Arrays.fill(h, -1);
            e = new int[M];
            ne = new int[M];
            idx = 0;
            vis = new boolean[N];
            dis = new int[N];
            Arrays.fill(dis, -1);
            this.n = n;
            res = new int[N];
            cnt = 0;
        }

        /**
         * 添加一条a->的边
         * @param a fr
         * @param b to
         */
        public void add(int a, int b) {
            e[idx] = b;
            ne[idx] = h[a];
            h[a] = idx++;

        }

        /**
         * 深度优先遍历有向图
         * @param u 任意节点
         */
        public void dfs(int u) {
            vis[u] = true;
            for (int i = h[u]; i != -1; i = ne[i]) {
                int j = e[i];
                if (!vis[j]) {
                    dfs(j);
                }
            }
        }

        /**
         * 广度优先遍历有向图
         */
        public void bfs() {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(1);
            dis[1] = 0;
            while (!queue.isEmpty()) {
                int t = queue.poll();
                for (int i = h[t]; i != -1; i = ne[i]) {
                    int j = e[i];
                    if (dis[j] == -1) {
                        dis[j] = dis[t] + 1;
                        queue.offer(j);
                    }
                }
            }
        }

        /**
         * 判断一个有向图是否存在拓扑序列
         * @return true表示存在，false表示不存在
         */
        public boolean topSort() {
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (dis[i] == 0) {
                    queue.offer(i);
                    res[cnt++] = i;
                }
            }
            while (!queue.isEmpty()) {
                int t = queue.poll();
                for (int i = h[t]; i != -1; i = ne[i]) {
                    int j = e[i];
                    dis[j]--;
                    if (dis[j] == 0) {
                        queue.offer(j);
                        res[cnt++] = j;
                    }
                }
            }
            return cnt == n;
        }


    }

    /**
    * @Author LBS59
    * @Description dijkstra最短路径算法-朴素版+堆优化版
    * @Date 11:44 2022/5/31
    **/
    private static class Dijkstra {
        private static final int N = 510, INF = 0x3f3f3f3f;
        /**
         * 稠密图：邻接矩阵存储每一条边的边权
         */
        private static int[][] g;
        /**
         * 稀疏图：邻接表存储每一条边的边权
         */
        private static int[] h, e, ne, w;
        private static int idx;

        private static int[] dist;
        private static boolean[] vis;

        public Dijkstra() {
            // 稠密图
            g = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(g[i], INF);
            }

            // 稀疏图
            h = new int[N];
            Arrays.fill(h, -1);
            e = new int[N];
            ne = new int[N];
            w = new int[N];
            idx = 0;

            dist = new int[N];
            Arrays.fill(dist, INF);
            vis = new boolean[N];
        }

        /**
         * 求节点1到节点n的最短路径
         * @param n 终点节点
         * @return 最短路径值
         */
        public int dijkstra1(int n) {
            dist[1] = 0;
            for (int i = 0; i < n; i++) {
                int t = -1;
                for (int j = 1; j <= n; j++) {
                    if (!vis[j] && (t == -1 || dist[t] > dist[j])) {
                        t = j;
                    }
                }
                if (t == n) {
                    break;
                }
                vis[t] = true;
                for (int j = 1; j <= n; j++) {
                    dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
                }
            }
            if (dist[n] == INF) {
                // 从1到不了n
                return -1;
            }
            return dist[n];
        }

        /**
         * 添加一条a->b，权重为c的有向边
         * @param a 1
         * @param b 2
         * @param c 3
         */
        private void add(int a, int b, int c) {
            e[idx] = b;
            w[idx] = c;
            ne[idx] = h[a];
            h[a] = idx++;
        }

        public int dijkstra2(int n) {
            dist[1] = 0;
            // 堆存储一个长度为2的数组，{距离节点1的距离，当前节点编号}
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
            pq.offer(new int[] {0, 1});
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int dis = cur[0], ver = cur[1];
                if (vis[ver]) {
                    continue;
                }
                if (ver == n) {
                    break;
                }
                vis[ver] = true;
                for (int i = h[ver]; i != -1; i = ne[i]) {
                    int j = e[i];
                    if (dist[j] > dis + w[i]) {
                        dist[j] = dis = w[i];
                        pq.offer(new int[] {dist[j], j});
                    }
                }
            }
            if (dist[n] == INF) {
                return -1;
            }
            return dist[n];
        }
    }

    /**
    * @Author LBS59
    * @Description Bellman-Ford最短路径算法：处理含负权边的有向图最短路径问题
    * @Date 12:05 2022/5/31
    **/
    private static class BellmanFord {
        /**
         * 创建边权类
         */
        private static class Edge {
            int from;
            int to;
            int weight;

            public Edge(int a, int b, int w) {
                this.from = a;
                this.to = b;
                this.weight = w;
            }
        }

        private static final int N = 510, M = 10010, INF = 0x3f3f3f3f;
        /**
         * dist存储所有节点到节点1的最短距离
         */
        private int[] dist;
        /**
         * backup存储上次更新的结果
         */
        private int[] backup;
        /**
         * edges存储所有边的信息
         */
        private Edge[] edges;

        public BellmanFord() {
            dist = new int[N];
            Arrays.fill(dist, INF);
            backup = new int[N];
            edges = new Edge[M];
        }

        /**
         * 创建一条边权信息
         * @param a from
         * @param b to
         * @param w weight
         * @return Edge对象
         */
        private Edge insert(int a, int b, int w) {
            return new Edge(a, b, w);
        }

        public int bellmanFord(int n, int k, int m) {
            dist[1] = 0;
            for (int i = 0; i < k; i++) {
                backup = Arrays.copyOf(dist, dist.length);
                for (int j = 0; j < m; j++) {
                    int a = edges[j].from, b = edges[j].to, w = edges[j].weight;
                    dist[b] = Math.min(dist[b], backup[a] + w);
                }
            }
            return dist[n];
        }
    }

    /**
    * @Author LBS59
    * @Description SPFA最短路径算法：一种更高效的处理含负权边的最短路径问题
    * @Date 12:06 2022/5/31
    **/
    private static class SPFA {
        private static final int N = 100010, INF = 0x3f3f3f3f;

        private int[] h, e, ne, w;
        private int[] dist;
        private boolean[] vis;
        private int idx;

        public SPFA() {
            h = new int[N];
            Arrays.fill(h, -1);
            e = new int[N];
            ne = new int[N];
            w = new int[N];
            dist = new int[N];
            Arrays.fill(dist, INF);
            vis = new boolean[N];
            idx = 0;
        }

        private void add(int a, int b, int c) {
            e[idx] = b;
            w[idx] = c;
            ne[idx] = h[a];
            h[a] = idx++;
        }

        public int spfa(int n) {
            Queue<Integer> queue = new ArrayDeque<>();
            dist[1] = 0;
            vis[1] = true;
            queue.offer(1);
            while (!queue.isEmpty()) {
                int t = queue.poll();
                vis[t] = false;
                for (int i = h[t]; i != -1; i = ne[i]) {
                    int j = e[i];
                    if (dist[j] > dist[t] + w[i]) {
                        dist[j] = dist[t] + w[i];
                        if (!vis[j]) {
                            queue.offer(j);
                            vis[j] = true;
                        }
                    }
                }
            }
            return dist[n];
        }
    }

    /**
    * @Author LBS59
    * @Description floyd最短路径算法：解决多源最短路问题
    * @Date 12:12 2022/5/31
    **/
    private static class Floyd {
        private static final int N = 210, INF = 0x3f3f3f3f;

        private int[][] dist;

        public Floyd() {
            dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], INF);
            }
        }

        public void floyd(int n) {
            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }

    /**
    * @Author LBS59
    * @Description 两种方法求一个有向图的最小生成树
    * @Date 16:18 2022/5/31
    **/
    private static class MinSpanTree {
        /**
        * @Author LBS59
        * @Description Prim算法求解最小生成树-类似于Dijkstra算法
        * @Date 16:19 2022/5/31
        **/
        private static class Prim {
            private static final int N = 510, INF = 0x3f3f3f3f;

            /**
             * 稠密图使用邻接矩阵来存储边
             */
            private int[][] g;
            /**
             * dist存储连通块的最短距离
             */
            private int[] dist;
            /**
             * 用来判重
             */
            private boolean[] vis;

            public Prim() {
                g = new int[N][N];
                for (int i = 0; i < N; i++) {
                    Arrays.fill(g[i], INF);
                }
                dist = new int[N];
                Arrays.fill(dist, INF);
                vis = new boolean[N];
            }

            /**
             * prim算法求解最小生成树
             * @param n 节点数
             * @return 边权和最小值
             */
            public int prim(int n) {
                int res = 0;
                for (int i = 0; i < n; i++) {
                    // 找到一个不在连通块中的距离连通块最近的节点
                    int t = -1;
                    for (int j = 1; j <= n; j++) {
                        if (!vis[j] && (t == -1 || dist[t] > dist[j])) {
                            t = j;
                        }
                    }
                    if (i > 0 && dist[t] == INF) {
                        return INF;
                    }
                    if (i > 0) {
                        res += dist[t];
                    }
                    for (int j = 1; j <= n; j++) {
                        dist[j] = Math.min(dist[j], g[t][j]);
                    }
                    vis[t] = true;
                }
                return res;
            }
        }

        /**
        * @Author LBS59
        * @Description Kruskal算法求解最小生成树
        * @Date 16:28 2022/5/31
        **/
        private static class Kruskal {
            /**
             * Edge类存储边权信息
             */
            private static class Edge implements Comparable<Edge> {
                int from;
                int to;
                int weight;

                public Edge(int fr, int to, int weight) {
                    this.from = fr;
                    this.to = to;
                    this.weight = weight;
                }

                @Override
                public int compareTo(Edge o) {
                    return Integer.compare(weight, o.weight);
                }
            }

            private static final int N = 200020;

            private int[] p;
            private Edge[] edges;

            public Kruskal() {
                p = new int[N];
                edges = new Edge[N];
            }

            private Edge insert(int a, int b, int c) {
                return new Edge(a, b, c);
            }

            private int find(int x) {
                return p[x] == x ? p[x] : find(p[x]);
            }
        }
    }

    /**
    * @Author LBS59
    * @Description 数学相关的算法
    * @Date 16:38 2022/5/31
    **/
    private static class Mathematic {
        /**
        * @Author LBS59
        * @Description 质数相关算法
        * @Date 16:39 2022/5/31
        **/
        private static class Primes {
            private static final int N = 1000010;
            /**
             * 保留质数
             */
            private int[] primes;
            /**
             * 保留质数的个数
             */
            private int cnt;
            /**
             * 筛掉合数
             */
            private boolean[] vis;

            public Primes() {
                primes = new int[N];
                cnt = 0;
                vis = new boolean[N];
            }

            /**
             * 试除法：判断正整数n是否为质数
             * @param n 正整数n
             * @return true：质数；false：非质数
             */
            public boolean isPrime(int n) {
                if (n < 2) {
                    return false;
                }
                for (int i = 2; i <= n / i; i++) {
                    if (n % i == 0) {
                        return false;
                    }
                }
                return true;
            }

            /**
             * 试除法：分解质因数
             * @param n 正整数n
             * @return 所有质因子以及指数
             */
            public List<int[]> divide(int n) {
                List<int[]> res = new ArrayList<>();
                for (int i = 2; i <= n / i; i++) {
                    // i一定为质数
                    if (n % i == 0) {
                        int c = 0;
                        while (n % i == 0) {
                            n /= i;
                            c++;
                        }
                        res.add(new int[] {i, c});
                    }
                }
                if (n > 1) {
                    res.add(new int[] {n, 1});
                }
                return res;
            }

            /**
             * 埃氏筛法：找出1~n以内的所有质数
             * @param n 正整数
             * @return 所有质数
             */
            public int[] getPrimes1(int n) {
                for (int i = 2; i <= n; i++) {
                    if (!vis[i]) {
                        // i一定为质数
                        primes[cnt++] = i;
                        // 将质数i的倍数全部排除掉
                        for (int j = i + i; j <= n; j += i) {
                            vis[j] = true;
                        }
                    }
                }
                return Arrays.copyOf(primes, cnt);
            }

            /**
             * 线性筛法：找出1~n以内的所有质数
             * @param n 正整数
             * @return 所有质数
             */
            public int[] getPrimes2(int n) {
                for (int i = 2; i <= n; i++) {
                    if (!vis[i]) {
                        // i一定为质数
                        primes[cnt++] = i;
                    }
                    for (int j = 0; primes[j] <= n / i; j++) {
                        vis[primes[j] * i] = true;
                        if (i * primes[j] == 0) {
                            break;
                        }
                    }
                }
                return Arrays.copyOf(primes, cnt);
            }
        }

        /**
        * @Author LBS59
        * @Description 约数方面的算法
        * @Date 17:22 2022/5/31
        **/
        private static class Divisors {
            /**
             * 试除法：求正整数n的所有约数
             * @param n 正整数
             * @return 所有约数集合
             */
            public List<Integer> getDivisors(int n) {
                List<Integer> res = new ArrayList<>();
                for (int i = 1; i <= n / i; i++) {
                    if (n % i == 0) {
                        res.add(i);
                        if (i != n / i) {
                            res.add(n / i);
                        }
                    }
                }
                Collections.sort(res);
                return res;
            }

            /**
             * 求正整数n的约数个数
             * @param n 正整数n
             * @return 约数个数
             */
            public long getDivisorCnt(int n) {
                // 采用分解质因数的方式，哈希表中存储{质因数，质因数的指数}
                Map<Integer, Integer> primes = new HashMap<>();
                for (int i = 2; i <= n / i; i++) {
                    while (n % i == 0) {
                        // i一定为一个质数
                        n /= i;
                        primes.put(i, primes.getOrDefault(i, 0) + 1);
                    }
                }
                if (n > 1) {
                    primes.put(n, primes.getOrDefault(n, 0) + 1);
                }
                long res = 1;
                for (int p : primes.values()) {
                    res *= (p + 1);
                }
                return res;
            }

            /**
             * 求正整数n的所有约数之和
             * @param n 正整数n
             * @return 约数之和
             */
            public long getDivisorSum(int n) {
                Map<Integer, Integer> primes = new HashMap<>();
                for (int i = 2; i <= n / i; i++) {
                    while (n % i == 0) {
                        n /= i;
                        primes.put(i, primes.getOrDefault(i, 0) + 1);
                    }
                }
                if (n > 1) {
                    primes.put(n, primes.getOrDefault(n, 0) + 1);
                }
                long res = 1;
                for (Map.Entry<Integer, Integer> entry : primes.entrySet()) {
                    int p = entry.getKey(), a = entry.getValue();
                    long t = 1;
                    while (a-- > 0) {
                        t = t * p + 1;
                    }
                    res *= t;
                }
                return res;
            }

            /**
             * 欧几里得算法求解最大公约数
             * @param a a
             * @param b b
             * @return 最大公约数
             */
            public int gcd(int a, int b) {
                return b > 0 ? gcd(b, a % b) : a;
            }
        }

        /**
         * 求解n的欧拉函数，表示在1~n之间所有和n互质的数的个数
         * @param n 正整数n
         * @return 1~n之间所有和n互质的数的个数
         */
        public int getEuler(int n) {
            int res = n;
            for (int i = 2; i <= n / i; i++) {
                if (n % i == 0) {
                    res = res / i * (i - 1);
                    while (n % i == 0) {
                        n /= i;
                    }
                }
            }
            if (n > 1) {
                res = res / n * (n - 1);
            }
            return res;
        }

        /**
         * 快速幂算法：求解a^k%p的结果
         * -----------------------
         * 这里扩展一个求逆元的方法，如果a和p互质，则a%p的逆元为 x = quickPower(a, p - 2, p)
         * -----------------------
         * @param a 底数
         * @param k 质数
         * @param p mod
         * @return 结果
         */
        public int quickPower(int a, int k, int p) {
            long res = 1;
            long t = a;
            while (k > 0) {
                if ((k & 1) > 0) {
                    res = res * t % p;
                }
                k >>= 1;
                t = t * t % p;
            }
            return (int) res;
        }

        private static int x, y;
        /**
         * 扩展的欧几里得算法：找到一组非零整数x，y，使得ax + by = gcd(a, b)
         *
         * @param a a
         * @param b b
         */
        public void exGcd(int a, int b) {
            if (b == 0) {
                x = 1;
                y = 0;
                return;
            }
            exGcd(b, a % b);
            int temp = x;
            x = y;
            y = temp - a / b * y;
        }

        /**
        * @Author LBS59
        * @Description 组合问题1：求解多组C^b_a mod (1e9+7)，区别主要看N的范围
        * @Date 17:36 2022/5/31
        **/
        private static class Combination1 {
            private static final int N = 2010, MOD = (int) 1e9 + 7;

            private int[][] c;

            public Combination1() {
                c = new int[N][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j <= i; j++) {
                        if (j == 0) {
                            c[i][j] = 1;
                        } else {
                            c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % MOD;
                        }
                    }
                }
            }

            public int getCombination(int a, int b) {
                return c[a][b];
            }
        }

        /**
        * @Author LBS59
        * @Description 组合问题2：和组合问题一类似，但是N的范围变大，无法使用二维数组预处理
        * @Date 17:46 2022/5/31
        **/
        private class Combination2 {
            private static final int N = 100010, MOD = (int) 1e9 + 7;

            private int[] fact;
            private int[] infact;

            public Combination2() {
                fact = new int[N];
                infact = new int[N];
                fact[0] = infact[0] = 1;
                for (int i = 1; i < N; i++) {
                    fact[i] = (int) (((long) fact[i - 1] * i) % MOD);
                    infact[i] = (int) (((long) infact[i - 1] * quickPower(i, MOD - 2, MOD)) % MOD);
                }
            }

            public int getCombination(int a, int b) {
                return (int) (((long) fact[a] * infact[a - b] % MOD) * infact[b] % MOD);
            }
        }

        /**
        * @Author LBS59
        * @Description 组合问题3：计算C^b_a mod p，但是a，b的范围为[1, 1e18]，p的范围为[1, 1e5]
        * @Date 17:48 2022/5/31
        **/
        private class Combination3 {
            public long lucas(long a, long b, int p) {
                if (a < p && b < p) {
                    return getCombination((int) a, (int) b, p);
                }
                return getCombination((int) (a % p), (int) (b % p), p) * lucas(a / p, b / p, p) % p;
            }

            private int getCombination(int a, int b, int p) {
                int res = 1;
                for (int i = 1, j = a; i <= b; i++, j--) {
                    res = (int) ((long) res * j % p);
                    res = (int) ((long) res * quickPower(i, p - 2, p) % p);
                }
                return res;
            }
        }

        /**
        * @Author LBS59
        * @Description 直接计算出C^b_a，而不是取模的结果
        * @Date 17:54 2022/5/31
        **/
        private static class Combination4 {
            private static final int N = 5010;

            private int[] primes, sum;
            private boolean[] vis;
            private int cnt;

            public Combination4() {
                primes = new int[N];
                sum = new int[N];
                cnt = 0;
                vis = new boolean[N];
            }

            /**
             * 线性筛选质因数
             * @param n 正整数n
             */
            private void getPrimes(int n) {
                for (int i = 2; i <= n; i++) {
                    if (!vis[i]) {
                        primes[cnt++] = i;
                    }
                    for (int j = 0; primes[j] <= n / i; j++) {
                        vis[primes[j] * i] = true;
                        if (i * primes[j] == 0) {
                            break;
                        }
                    }
                }
            }

            private int get(int n, int p) {
                int res = 0;
                while (n > 0) {
                    res += n / p;
                    n /= p;
                }
                return res;
            }

            private List<Integer> mul(List<Integer> a, int b) {
                List<Integer> res = new ArrayList<>();
                int t = 0;
                for (int x : a) {
                    t += x * b;
                    res.add(t % 10);
                    t /= 10;
                }
                while (t > 0) {
                    res.add(t % 10);
                    t /= 10;
                }
                return res;
            }

            public List<Integer> getCombination(int a, int b) {
                getPrimes(a);
                for (int i = 0; i < cnt; i++) {
                    int p = primes[i];
                    sum[i] = get(a, p) - get(b, p) - get(a - b, p);
                }
                List<Integer> res = new ArrayList<>();
                res.add(1);
                for (int i = 0; i < cnt; i++) {
                    for (int j = 0; j < sum[i]; j++) {
                        res = mul(res, primes[i]);
                    }
                }
                return res;
            }
        }
    }

    /**
     * 测试接口
     * @param args 1
     */
    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Mathematic().getEuler(n));
    }
}
