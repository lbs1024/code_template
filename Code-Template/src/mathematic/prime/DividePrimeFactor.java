package mathematic.prime;

import java.util.Scanner;

/**
 * @author LBS59
 * @description 试除法分解质因子，以及质因子的指数
 */
public class DividePrimeFactor {
    public static void divide(int n) {
        for (int i = 2; i <= n / i; i++) {
            // 当前的i一定是一个质数
            if (n % i == 0) {
                // 求质数的指数
                int s = 0;
                while (n % i == 0) {
                    n /= i;
                    s++;
                }
                System.out.println(i + " " + s);
            }
        }
        if (n > 1) {
            System.out.println(n + " " + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int x = sc.nextInt();
            divide(x);
            System.out.println();
        }
    }
}
