package mathematic.divisor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author LBS59
 * @description 整数的约数之和
 */
public class SumOfDivisors {
    private static final int MOD = (int) 1e9 + 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<Integer, Integer> primes = new HashMap<>();

        while (n-- > 0) {
            int x = sc.nextInt();
            for (int i = 2; i <= x / i; i++) {
                while (x % i == 0) {
                    x /= i;
                    primes.put(i, primes.getOrDefault(i, 0) + 1);
                }
            }
            if (x > 1) {
                primes.put(x, primes.getOrDefault(x, 0) + 1);
            }
        }
        long res = 1;
        for (Map.Entry<Integer, Integer> entry : primes.entrySet()) {
            int p = entry.getKey(), a = entry.getValue();
            long t = 1;
            while (a-- > 0) {
                t = (t * p + 1) % MOD;
            }
            res = res * t % MOD;
        }
        System.out.println(res);
    }
}
