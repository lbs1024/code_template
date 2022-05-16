package mathematic.prime.getprime;

import java.util.Scanner;

/**
 * @author LBS59
 * @description 埃氏筛法
 */
public class GetPrimes1 {
    private static final int N = 1000010;
    /**
     * 保存质数
     */
    private static int[] primes;
    /**
     * 保存质数个数
     */
    private static int cnt;
    /**
     * 筛掉合数
     */
    private static boolean[] vis;

    static {
        primes = new int[N];
        cnt = 0;
        vis = new boolean[N];
    }

    public static void getPrimes(int n) {
        for (int i = 2; i <= n; i++) {
            if (!vis[i]) {
                primes[cnt++] = i;
                for (int j = i + i; j <= n; j += i) {
                    vis[j] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        getPrimes(n);
        System.out.println(cnt);
        for (int i = 0; i < cnt; i++) {
            System.out.printf("%d ", primes[i]);
        }
    }
}
