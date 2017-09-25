package net.rayxiao;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by rxiao on 7/6/16.
 */
public class Testa {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        Integer[] a = l.stream().map(
                x -> {
                    System.out.println(x.toString());

                    return x;
                }).map(x -> {
                    System.out.println(x.toString());
                    return x;
                }).toArray(Integer[]::new);

        Object r2 = (Runnable) () -> System.out.println("Howdy, world!");
        ((Runnable) r2).run();
        System.out.println(5 / 2);
        Pattern p;
        int[] a2 = {1, 2, 3, 4};
        test1(a2);
        System.out.println("hahah".substring(1,2));

    }

    private static void test1(int[] var) {
        var[0] = 0;

    }

}
