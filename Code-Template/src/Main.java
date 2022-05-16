import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
* @Author LBS59
* @Description 本地测试类
* @Date 20:25 2022/5/10
**/
class Main {
    private static final int N = (int) 5e5;

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        System.out.println("数据量：" + N);
        long s1 = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list1.add(0, i);
        }
        long e1 = System.currentTimeMillis();
        System.out.println("ArrayList插入操作：" +  (e1 - s1));

        long s2 = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list2.add(0, i);
        }
        long e2 = System.currentTimeMillis();
        System.out.println("LinkedList插入操作：" +  (e2 - s2));

        long s3 = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list1.remove(0);
        }
        long e3 = System.currentTimeMillis();
        System.out.println("ArrayList删除操作：" +  (e3 - s3));

        long s4 = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list2.remove(0);
        }
        long e4 = System.currentTimeMillis();
        System.out.println("ArrayList删除操作：" +  (e4 - s4));
    }
}
