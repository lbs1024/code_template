package mathematic.prime;

import java.util.Scanner;

/**
 * @author LBS59
 * @description 试除法判断质数
 */
public class CheckPrimes {
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int x = sc.nextInt();
            if (isPrime(x)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
