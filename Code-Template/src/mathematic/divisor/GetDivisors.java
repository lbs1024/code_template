package mathematic.divisor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author LBS59
 * @description 试除法求一个数的所有约数
 */
public class GetDivisors {
    public static List<Integer> getDivisors(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n / i; i++) {
            if (n % i == 0) {
                res.add(i);
                if (i != n / i) {
                    res.add(n / i);
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int x = sc.nextInt();
            List<Integer> res = getDivisors(x);
            for (int t : res) {
                System.out.printf("%d ", t);
            }
            System.out.println();
        }
    }
}
