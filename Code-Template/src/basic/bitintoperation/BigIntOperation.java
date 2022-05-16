package basic.bitintoperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author LBS59
 * @description 大整数的四则运算
 */
public class BigIntOperation {
    public String add(String a, String b) {
        List<Integer> al = new ArrayList<>(), bl = new ArrayList<>();
        for (int i = a.length() - 1; i >= 0; i--) {
            al.add(a.charAt(i) - '0');
        }
        for (int i = b.length() - 1; i >= 0; i--) {
            bl.add(b.charAt(i) - '0');
        }
        List<Integer> sum = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < al.size() || i < bl.size(); i++) {
            if (i < al.size()) {
                t += al.get(i);
            }
            if (i < bl.size()) {
                t += bl.get(i);
            }
            sum.add(t % 10);
            t /= 10;
        }
        if (t > 0) {
            sum.add(t);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = sum.size() - 1; i >= 0; i--) {
            sb.append(sum.get(i));
        }
        return sb.toString();
    }

    public String sub(String a, String b) {
        List<Integer> al = new ArrayList<>(), bl = new ArrayList<>();
        for (int i = a.length() - 1; i >= 0; i--) {
            al.add(a.charAt(i) - '0');
        }
        for (int i = b.length() - 1; i >= 0; i--) {
            bl.add(b.charAt(i) - '0');
        }
        List<Integer> sub = new ArrayList<>();
        for (int i = 0, t = 0; i < al.size(); i++) {
            // 当前位的被减数
            t = al.get(i) - t;
            if (i < bl.size()) {
                t -= bl.get(i);
            }
            // 这里减完t可能为负数，所以需要借位
            sub.add((t + 10) % 10);
            if (t < 0) {
                t = 1;
            } else {
                t = 0;
            }
        }
        while (sub.size() > 1 && sub.get(sub.size() - 1) == 0) {
            sub.remove(sub.size() - 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = sub.size() - 1; i >= 0; i--) {
            sb.append(sub.get(i));
        }
        return sb.toString();
    }

    public String mul(String a, int b) {
        List<Integer> al = new ArrayList<>();
        for (int i = a.length() - 1; i >= 0; i--) {
            al.add(a.charAt(i) - '0');
        }

        List<Integer> mul = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < al.size() || t > 0; i++) {
            if (i < al.size()) {
                t += al.get(i) * b;
            }
            mul.add(t % 10);
            t /= 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = mul.size() - 1; i >= 0; i--) {
            sb.append(mul.get(i));
        }
        return sb.toString();
    }

    public String[] div(String a, int b) {
        List<Integer> div = new ArrayList<>();
        // 这里r是每次运算完的余数
        int r = 0;
        for (int i = 0; i < a.length(); i++) {
            r = r * 10 + (a.charAt(i) - '0');
            div.add(r / b);
            r %= b;
        }
        while (div.size() > 1 && div.get(0) == 0) {
            div.remove(0);
        }
        StringBuilder sb = new StringBuilder();
        for (int integer : div) {
            sb.append(integer);
        }
        return new String[] {sb.toString(), "" + r};
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String a = sc.next(), b = sc.next();
//        System.out.println(new BigIntOperation().add(a, b));

//        Scanner sc = new Scanner(System.in);
//        String a = sc.next(), b = sc.next();
//        if (cmp(a, b)) {
//            System.out.println(new BigIntOperation().sub(a, b));
//        } else {
//            System.out.println("-" + new BigIntOperation().sub(b, a));
//        }

//        Scanner sc = new Scanner(System.in);
//        String a = sc.next();
//        int b = sc.nextInt();
//        System.out.println(new BigIntOperation().mul(a, b));

        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int b = sc.nextInt();
        String[] res = new BigIntOperation().div(a, b);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    /**
     * 判断字符串a表示的长整数是否大于b
     * @param a 表示a的字符串
     * @param b 表示b的字符串
     * @return a是否大于等于b
     */
    private static boolean cmp(String a, String b) {
        if (a.length() != b.length()) {
            return a.length() > b.length();
        }
        for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) != b.charAt(i)) {
                return a.charAt(i) > b.charAt(i);
            }
        }
        return true;
    }
}
