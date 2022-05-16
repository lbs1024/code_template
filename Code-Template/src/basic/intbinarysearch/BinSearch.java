package basic.intbinarysearch;

/**
 * @author LBS59
 * @description 整数二分模板
 */
public class BinSearch {
    /**
     * 区间[l, r]被划分成[l, mid]和[mid + 1, r]时使用
     *
     * @param l 查询左边界
     * @param r 查询有边界
     * @return 查询结果
     */
    public int bSearch1(int l, int r) {
        while (l < r) {
            int mid = l + r >> 1;
            // 这里check是判断mid位置是否满足某种性质
            if (check(mid) > 0) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     * 区间[l, r]被划分成[l, mid - 1]和[mid, r]时使用
     *
     * @param l 查询左边界
     * @param r 查询有边界
     * @return 查询结果
     */
    public int bSearch2(int l, int r) {
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid) > 0) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private int check(int mid) {
        /**
         * 省略
         */
        return 0;
    }
}
