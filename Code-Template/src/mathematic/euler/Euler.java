package mathematic.euler;

import java.util.Scanner;

/**
 * @author LBS59
 * @description 容斥原理求欧拉函数
 */
public class Euler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int a = sc.nextInt();
            int res = a;
            for (int i = 2; i <= a / i; i++) {
                if (a % i == 0){
                    res = res / i * (i - 1);
                    while (a % i == 0) {
                        a /= i;
                    }
                }
            }
            if (a > 1) {
                res = res / a * (a - 1);
            }
            System.out.println(res);
        }
    }
}
