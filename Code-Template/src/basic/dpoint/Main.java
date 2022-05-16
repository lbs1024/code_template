package basic.dpoint;

import java.util.Scanner;

/**
 * @author LBS59
 * @description 双指针模板题-这里为求最长连续不重复子序列
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] cnt = new int[100010];
        int res = 0;
        // 这里i遍历的是所有的终点
        for (int i = 0, j = 0; i < n; i++) {
            cnt[arr[i]]++;
            while (cnt[arr[i]] > 1) {
                cnt[arr[j]]--;
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        System.out.println(res);
    }
}
