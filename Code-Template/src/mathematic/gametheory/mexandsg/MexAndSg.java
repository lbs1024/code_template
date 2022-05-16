package mathematic.gametheory.mexandsg;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author LBS59
 * @description 集合Nim游戏
 */
public class MexAndSg {
    private static final int N = 110, M = 10010;

    private static int[] s, f;

    static {
        s = new int[N];
        f = new int[M];
        Arrays.fill(f, -1);
    }

    private static int sg(int x, int m) {
        if (f[x] != -1) {
            return f[x];
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int sum = s[i];
            if (x >= sum) {
                set.add(sg(x - sum, m));
            }
        }
        for (int i = 0; ; i++) {
            if (!set.contains(i)) {
                return f[x] = i;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            s[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            res ^= sg(x, m);
        }
        if (res > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
