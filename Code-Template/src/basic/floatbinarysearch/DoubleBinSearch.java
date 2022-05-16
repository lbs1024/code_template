package basic.floatbinarysearch;

import java.util.Scanner;

/**
 * @author LBS59
 * @description 浮点数二分模板
 */
public class DoubleBinSearch {
    static final double V = 1e-8;

    /**
     * 这里存在精度问题，假设以保留6位小数为例
     * @return 查询结果
     */
    public double doubleBinSearch1(double x) {
        double l = 0.0, r = x;
        while (r - l > V) {
            double mid = (l + r) / 2.0;
            if (mid * mid >= x) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return l;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        // 这里以求x的算数平方根为例
        double res = new DoubleBinSearch().doubleBinSearch1(x);
        System.out.printf("%6f", res);
    }
}
