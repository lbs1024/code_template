package mathematic.prime.getprime;

import java.util.Scanner;

/**
 * @author LBS59
 * @description 线性筛法
 */
public class GetPrimes2 {
    private static final int N = 1000010;

    private static int[] primes;
    private static int cnt;
    private static boolean[] st;

    static {
        primes = new int[N];
        cnt = 0;
        st = new boolean[N];
    }

    public static void getPrimes(int n) {
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                primes[cnt++] = i;
            }
            for (int j = 0; primes[j] <= n / i; j++) {
                st[primes[j] * i] = true;
                if (i % primes[j] == 0) {
                    break;
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
