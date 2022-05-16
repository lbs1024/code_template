package mathematic.divisor;

import java.util.Scanner;

/**
 * @author LBS59
 * @description 欧几里得算法求最大公约数
 */
public class GCD {
    public static int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt();
            System.out.println(gcd(a, b));
        }
    }
}
