package greedy.sortnonequalization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author LBS59
 * @description 排序不等式例题，排队打水问题
 */
public class GetWater {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine().trim());
        String[] row = in.readLine().trim().split(" ");
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = Integer.parseInt(row[i]);
        }
        Arrays.sort(t);
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += (long) t[i] * (n - i - 1);
        }
        System.out.println(res);

        in.close();
    }
}
