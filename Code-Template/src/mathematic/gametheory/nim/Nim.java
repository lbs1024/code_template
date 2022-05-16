package mathematic.gametheory.nim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author LBS59
 * @description Nim游戏
 */
public class Nim {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        String[] row = in.readLine().split(" ");
        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= Integer.parseInt(row[i]);
        }
        if (res > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        in.close();
    }
}
