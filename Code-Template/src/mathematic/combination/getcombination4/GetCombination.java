package mathematic.combination.getcombination4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author LBS59
 * @description 求组合数
 */
public class GetCombination {
    private static final int N = 5010;

    private static int[] primes, sum;
    private static boolean[] vis;
    private static int cnt;

    static {
        primes = new int[N];
        sum = new int[N];
        cnt = 0;
        vis = new boolean[N];
    }

    /**
     * 线性筛质数
     * @param n 待筛
     */
    private static void getPrimes(int n) {
        for (int i = 2; i <= n; i++) {
            if (!vis[i]) {
                primes[cnt++] = i;
            }
            for (int j = 0; primes[j] <= n / i; j++) {
                vis[primes[j] * i] = true;
                if (i * primes[j] == 0) {
                    break;
                }
            }
        }
    }

    /**
     * 对p的各个指数次数算整数倍数
     * @param n 1
     * @param p 2
     * @return 3
     */
    private static int get(int n, int p) {
        int res = 0;
        while (n > 0) {
            res += n / p;
            n /= p;
        }
        return res;
    }

    private static List<Integer> mul(List<Integer> a, int b) {
        List<Integer> res = new ArrayList<>();
        int t = 0;
        for (int integer : a) {
            t += integer * b;
            res.add(t % 10);
            t /= 10;
        }
        while (t > 0) {
            res.add(t % 10);
            t /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        getPrimes(a);

        for (int i = 0; i < cnt; i++) {
            int p = primes[i];
            sum[i] = get(a, p) - get(b, p) - get(a - b, p);
        }

        List<Integer> res = new ArrayList<>();
        res.add(1);

        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < sum[i]; j++) {
                res = mul(res, primes[i]);
            }
        }

        for (int i = res.size() - 1; i >= 0; i--) {
            System.out.printf("%d", res.get(i));
        }
    }
}
