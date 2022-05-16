package mathematic.inandexprinciple;

import java.util.Scanner;

/**
 * @author LBS59
 * @description 容斥原理例题---计算1~n之中能被m个质数至少一个整除的个数有多少个
 */
public class InAndExPrinciple {
    private static final int N = 20;

    private static int[] p;

    static {
        p = new int[N];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            p[i] = sc.nextInt();
        }
        int res = 0;
        // 二进制暴搜法
        for (int i = 1; i < 1 << m; i++) {
            // t存储当前的乘积，cnt存储当前方案中1的个数
            int t = 1, cnt = 0;
            for (int j = 0; j < m; j++) {
                // j位置被选中
                if (((i >> j) & 1) != 0) {
                    cnt++;
                    // 因为要求当前这个组合中所有质数的乘积在n中出现多少次，就是n是组合质数乘积的多少倍，如果乘到某一个质数超过了n，直接break掉
                    if ((long) t * p[j] > n) {
                        t = -1;
                        break;
                    }
                    // 否则就乘上这个位置的质数
                    t *= p[j];
                }
            }
            if (t != -1) {
                // 根据容斥原理，奇数组合做加法
                if (cnt % 2 != 0) {
                    res += n / t;
                // 偶数组合做减法
                } else {
                    res -= n / t;
                }
            }
        }
        System.out.println(res);
    }
}
