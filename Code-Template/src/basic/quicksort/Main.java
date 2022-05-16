package basic.quicksort;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LBS59
 * @description 快速排序模板
 */
public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        quickSort(0, n - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int l, int r) {
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
}
