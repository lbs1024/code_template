package dp.numposdp.counting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author LBS59
 * @description 数位dp解决计数问题
 */
public class Count {
    private static int get(List<Integer> num, int l, int r) {
        int res = 0;
        for (int i = l; i >= r; i--) {
            res = res * 10 + num.get(i);
        }
        return res;
    }

    private static int count(int n, int x) {
        if (n == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        n = list.size();

        int res = 0;
        for (int i = n - 1 - ((x == 0) ? 1 : 0); i >= 0; i--) {
            if (i < n - 1) {
                res += get(list, n - 1, i + 1) * (int) Math.pow(10, i);
                if (x == 0) {
                    res -= (int) Math.pow(10, i);
                }
            }
            if (list.get(i) == x) {
                res += get(list, i - 1, 0) + 1;
            } else if (list.get(i) > x) {
                res += (int) Math.pow(10, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int a = sc.nextInt(), b = sc.nextInt();
            if (a == 0 && b == 0) {
                break;
            }
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            for (int i = 0; i < 10; i++) {
                System.out.printf("%d ", count(b, i) - count(a - 1, i));
            }
            System.out.println();
        }
    }
}
