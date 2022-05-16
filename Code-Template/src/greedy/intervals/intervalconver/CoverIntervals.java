package greedy.intervals.intervalconver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author LBS59
 * @description 贪心思想求解区间覆盖问题
 */
public class CoverIntervals {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] interval = in.readLine().split(" ");
        int st = Integer.parseInt(interval[0]), ed = Integer.parseInt(interval[1]);
        int n = Integer.parseInt(in.readLine());
        int[][] ranges = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] row = in.readLine().split(" ");
            int l = Integer.parseInt(row[0]), r = Integer.parseInt(row[1]);
            ranges[i] = new int[]{l, r};
        }

        Arrays.sort(ranges, Comparator.comparingInt(o -> o[0]));

        int res = 0;
        boolean flag = false;
        // 双指针法
        for (int i = 0; i < n; i++) {
            // 起始最大右端点为负无穷
            int j = i, r = Integer.MIN_VALUE;
            while (j < n && ranges[j][0] <= st) {
                // 寻找可以覆盖住st点的最后端点
                r = Math.max(r, ranges[j][1]);
                j++;
            }
            // 找到的最后端点没有覆盖住st点
            if (r < st) {
                res = -1;
                break;
            }
            res++;
            // 区间覆盖完成
            if (r >= ed) {
                flag = true;
                break;
            }
            // 更新起始点为选择的最大右端点，继续循环
            st = r;
            i = j - 1;
        }
        if (!flag) {
            res = -1;
        }
        System.out.println(res);

        in.close();
    }
}
