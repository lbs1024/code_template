package datastruction.singlequeue;

import java.io.*;

/**
 * @author LBS59
 * @description 单调队列滑动窗口问题
 */
public class Main {
    private static final double[] DX = {-1, -0.5, 0.5, 1, 0.5, -0.5}, DY = {0, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = in.readLine().split(" ");
        int d1 = Integer.parseInt(s[0]);
        int p1 = Integer.parseInt(s[1]);
        int q1 = Integer.parseInt(s[2]);
        int d2 = Integer.parseInt(s[3]);
        int p2 = Integer.parseInt(s[4]);
        int q2 = Integer.parseInt(s[5]);
        double x = 0, y = 0;
        double x1 = x + DX[d1] * p1, y1 = y + DY[d1] * p1;
        x1 = x1 + DX[(d1 + 2) % 6] * q1;
        y1 = y1 + DY[(d1 + 2) % 6] * q1;


        double x2 = x + DX[d2] * p2, y2 = y + DY[d2] * p2;
        x2 = x2 + DX[(d2 + 2) % 6] * q2;
        y2 = y2 + DY[(d2 + 2) % 6] * q2;

        out.write(Math.abs((int) x1 - (int) x2) + Math.abs((int) y1 - (int) y2) + "");


        out.flush();
        in.close();
        out.close();
    }
}
