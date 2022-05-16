package datastruction.hashmap;

import java.io.*;
import java.util.Arrays;

/**
 * 冲突链表法实现散列表
 */
class MyHash1 {
    /**
     * 这里N取质数
     */
    private static final int N = (int) 1e5 + 3;
    int[] h, e, ne;
    int idx;

    public MyHash1() {
        h = new int[N];
        Arrays.fill(h, -1);
        e = new int[N];
        ne = new int[N];
        idx = 0;
    }

    public void insert(int x) {
        int hash = (x % N + N) % N;
        e[idx] = x;
        ne[idx] = h[hash];
        h[hash] = idx++;
    }

    public boolean find(int x) {
        int hash = (x % N + N) % N;
        for (int i = h[hash]; i != -1; i = ne[i]) {
            if (e[i] == x) {
                return true;
            }
        }
        return false;
    }
}

/**
 * @author LBS59
 * @description 自定义散列表模板测试
 */
public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        MyHash1 hash = new MyHash1();
        for (int i = 0; i < n; i++) {
            String[] input = in.readLine().split(" ");
            String op = input[0];
            int num = Integer.parseInt(input[1]);
            if ("I".equals(op)) {
                hash.insert(num);
            } else {
                boolean success = hash.find(num);
                System.out.println(success ? "Yes" : "No");
            }
        }

        out.flush();
        in.close();
        out.close();
    }
}
