package greedy.absequalization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author LBS59
 * @description 绝对值不等式贪心问题：货仓选址
 */
public class WarehouseLocation {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine().trim());
        int[] arr = new int[n];
        String[] row = in.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(row[i]);
        }
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.abs(arr[i] - arr[n / 2]);
        }
        System.out.println(res);

        in.close();
    }
}
