package basic.discrete;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author LBS59
 * @description 离散化模板
 */
public class Discretely {
    private static final int N = (int) (3e5 + 10);
    static int[] a = new int[N], ss = new int[N];
    static List<int[]> query, add;
    static List<Integer> all;

    private static int find(int x) {
        int l = 1, r = all.size();
        while (l < r) {
            int mid = l + r >> 1;
            if (all.get(mid) >= x) {
                r = mid;
            } else {
                l = l + 1;
            }
        }
        return r;
    }

    private static List<Integer> unique(List<Integer> list) {
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0 || !list.get(i).equals(list.get(i - 1))) {
                list.set(j++, list.get(i));
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < j; i++) {
            res.add(list.get(i));
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
        query = new ArrayList<>(); add = new ArrayList<>();
        all = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] pair = in.readLine().split(" ");
            int idx = Integer.parseInt(pair[0]), c = Integer.parseInt(pair[1]);
            add.add(new int[] {idx, c});
            all.add(idx);
        }
        for (int i = 0; i < m; i++) {
            String[] pair = in.readLine().split(" ");
            int l = Integer.parseInt(pair[0]), r = Integer.parseInt(pair[1]);
            query.add(new int[] {l, r});
            all.add(l);
            all.add(r);
        }
        // 去重
        all.sort(Comparator.comparingInt(o -> o));
        all = unique(all);
        for (int[] pr : add) {
            int x = find(pr[0]);
            a[x] = pr[1];
        }

        for (int i = 1; i <= all.size(); i++) {
            ss[i] = a[i] + ss[i -1];
        }
        for (int[] q : query) {
            int l = find(q[0]), r = find(q[1]);
            System.out.println(ss[r] - ss[l - 1]);
        }

        out.flush();
        in.close();
        out.close();
    }
}
