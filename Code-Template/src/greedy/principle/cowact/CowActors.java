package greedy.principle.cowact;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author LBS59
 * @description
 */
public class CowActors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] cow = new int[n][2];
        for (int i = 0; i < n; i++) {
            int w = sc.nextInt(), s = sc.nextInt();
            cow[i] = new int[] {w, s};
        }
        Arrays.sort(cow, Comparator.comparingInt(o -> o[0] + o[1]));
        // res统计承重最大值，sum表示当前承重
        int res = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, sum - cow[i][1]);
            sum += cow[i][0];
        }
        System.out.println(res);
    }
}
