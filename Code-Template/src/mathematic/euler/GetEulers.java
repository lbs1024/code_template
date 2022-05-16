package mathematic.euler;

import java.util.Scanner;

/**
 * @author LBS59
 * @description 线性筛法求欧拉函数
 */
public class GetEulers {
    private static final int N = 1000010;
    /**
     * 线性筛法求质数三件套
     */
    private static int[] primes;
    private static int cnt;
    private static boolean[] vis;
    /**
     * 每一个数的欧拉函数
     */
    private static int[] phi;

    static {
        primes = new int[N];
        cnt = 0;
        vis = new boolean[N];
        phi = new int[N];
    }

    public static long getEulers(int n) {
        phi[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (!vis[i]) {
                primes[cnt++] = i;
                phi[i] = i - 1;
            }
            for (int j = 0; primes[j] <= n / i; j++) {
                vis[primes[j] * i] = true;
                if (i % primes[j] == 0) {
                    phi[primes[j] * i] = phi[i] * primes[j];
                    break;
                }
                phi[primes[j] * i] = phi[i] * (primes[j] - 1);
            }
        }
        long res = 0;
        for (int i = 1; i <= n; i++) {
            res += phi[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getEulers(n));
    }
}
