package greedy.intervals.groupintervals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author LBS59
 * @description 贪心思想求解区间分组问题
 */
public class GroupingIntervals {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[][] ranges = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] row = in.readLine().split(" ");
            int l = Integer.parseInt(row[0]), r = Integer.parseInt(row[1]);
            ranges[i] = new int[]{l, r};
        }

        Arrays.sort(ranges, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (heap.isEmpty() || heap.peek() >= ranges[i][0]) {
                heap.offer(ranges[i][1]);
            } else {
                heap.poll();
                heap.offer(ranges[i][1]);
            }
        }
        System.out.println(heap.size());

        in.close();
    }
}
