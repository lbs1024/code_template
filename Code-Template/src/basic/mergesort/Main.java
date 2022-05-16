package basic.mergesort;

import java.util.Scanner;

/**
 * @author LBS59
 * @description 归并排序模板
 */
public class Main {
    static int n;
    static int[] nums, tmp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = new int[n];
        tmp = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        mergeSort(0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.printf("%d", nums[i]);
            if (i != n - 1) {
                System.out.print(" ");
            }
        }
    }

    private static void mergeSort(int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) >> 1;
        mergeSort(l, mid);
        mergeSort(mid + 1, r);

        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= r) {
            tmp[k++] = nums[j++];
        }
        for (int q = l, w = 0; q <= r; q++, w++) {
            nums[q] = tmp[w];
        }
    }
}
