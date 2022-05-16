package basic.preDiv;

import java.util.Scanner;

/**
 * @author LBS59
 * @description 一维差分计算 - 注意这里的数组长度需要前后均扩增一维
 */
public class OneDPreDiv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] temp = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            int cur = sc.nextInt();
            insert(temp, i, i, cur);
        }
        for (int i = 0; i < m; i++) {
            int l = sc.nextInt(), r = sc.nextInt(), c = sc.nextInt();
            insert(temp, l, r, c);
        }
        for (int i = 1; i <= n; i++) {
            temp[i] += temp[i - 1];
            System.out.printf("%d ", temp[i]);
        }
    }

    private static void insert(int[] temp, int l, int r, int c) {
        temp[l] += c;
        temp[r + 1] -= c;
    }
}
