package mathematic.combination.getcombination3;

import java.util.Scanner;

/**
 * @author LBS59
 */
public class GetCombination {
    private static int quickPower(int a, int k, int p) {
        long res = 1;
        long t = a;
        while (k > 0) {
            if ((k & 1) != 0) {
                res = res * t % p;
            }
            t = t * t % p;
            k >>= 1;
        }
        return (int) res;
    }

    private static int combination(int a, int b, int p) {
        int res = 1;
        for (int i = 1, j = a; i <= b; i++, j--) {
            res = (int) ((long) res * j % p);
            res = (int) ((long) res * quickPower(i, p - 2, p) % p);
        }
        return res;
    }

    private static long lucas(long a, long b, int p) {
        if (a < p && b < p) {
            return combination((int) a, (int) b, p);
        }
        return combination((int) (a % p), (int) (b % p), p) * lucas(a / p, b / p, p) % p;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            long a = sc.nextLong(), b = sc.nextLong();
            int p = sc.nextInt();
            System.out.println(lucas(a, b, p));
        }
    }
}
