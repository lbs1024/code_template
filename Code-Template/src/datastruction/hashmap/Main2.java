package datastruction.hashmap;


import java.io.*;
import java.util.Arrays;

/**
 * 开放寻址法实现散列表
 */
class MyHash2 {
    private static final int N = (int) 2e5 + 3, NULL = 0x3f3f3f3f;
    int[] h;

    public MyHash2() {
        h = new int[N];
        Arrays.fill(h, NULL);
    }

    public int find(int x) {
        int k = (x % N + N) % N;
        while (h[k] != NULL && h[k] != x) {
            k++;
            if (k == N) {
                k = 0;
            }
        }
        return k;
    }
}

/**
 * @author LBS59
 * @description 自定义散列表模板测试
 */
public class Main2 {
    private static final int NULL = 0x3f3f3f3f;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        MyHash2 hash = new MyHash2();
        for (int i = 0; i < n; i++) {
            String[] input = in.readLine().split(" ");
            String op = input[0];
            int num = Integer.parseInt(input[1]);
            int k = hash.find(num);
            if ("I".equals(op)) {
                hash.h[k] = num;
            } else {
                System.out.println(hash.h[k] != NULL ? "Yes" : "No");
            }
        }

        out.flush();
        in.close();
        out.close();
    }
}
