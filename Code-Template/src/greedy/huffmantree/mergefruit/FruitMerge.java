package greedy.huffmantree.mergefruit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * @author LBS59
 * @description Huffman树贪心例题，与合并石子有点类似，但是每次合并可以合并任意两堆
 */
public class FruitMerge {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine().trim());
        String[] row = in.readLine().trim().split(" ");

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(row[i]));
        }

        int res = 0;
        // 贪心思想，每一次合并最小的两堆
        while (pq.size() > 1) {
            int a = pq.poll(), b = pq.poll();
            res += a + b;
            pq.offer(a + b);
        }
        System.out.println(res);

        in.close();
    }
}
