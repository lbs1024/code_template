package basic.presum;

import java.util.Scanner;

/**
 * @author LBS59
 * @description 一维前缀和模板
 */
public class OneDPreSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] preSum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            preSum[i] = preSum[i - 1] + sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int l = sc.nextInt(), r = sc.nextInt();
            System.out.println(preSum[r] - preSum[l - 1]);
        }
    }
}
