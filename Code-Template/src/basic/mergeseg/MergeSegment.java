package basic.mergeseg;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author LBS59
 * @description 区间合并模板
 */
public class MergeSegment {
    static final int REMOTE = (int) -2e9;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] pair = in.readLine().split(" ");
            arr[i][0] = Integer.parseInt(pair[0]);
            arr[i][1] = Integer.parseInt(pair[1]);
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        int s = REMOTE, e = REMOTE;
        for (int[] item : arr) {
            if (s == REMOTE && e == REMOTE) {
                s = item[0];
                e = item[1];
            } else {
                if (item[0] <= e) {
                    e = Math.max(e, item[1]);
                } else {
                    res.add(new int[] {s, e});
                    s = item[0];
                    e = item[1];
                }
            }
        }
        if (s != REMOTE && e != REMOTE) {
            res.add(new int[] {s, e});
        }
        out.write(res.size() + "");
        out.flush();
        in.close();
        out.close();
    }
}
