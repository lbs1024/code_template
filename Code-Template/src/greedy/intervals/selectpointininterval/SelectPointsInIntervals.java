package greedy.intervals.selectpointininterval;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author LBS59
 * @description 贪心思想求解区间选点问题
 */
public class SelectPointsInIntervals {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[][] ranges = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] row = in.readLine().split(" ");
            int l = Integer.parseInt(row[0]), r = Integer.parseInt(row[1]);
            ranges[i] = new int[]{l, r};
        }

        // 按区间右端点由小到大排序
        Arrays.sort(ranges, Comparator.comparingInt(o -> o[1]));

        int res = 0, cur = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (ranges[i][0] > cur) {
                res++;
                cur = ranges[i][1];
            }
        }
        System.out.println(res);

        in.close();
    }
}
