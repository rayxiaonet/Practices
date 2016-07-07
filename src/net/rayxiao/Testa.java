package net.rayxiao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rxiao on 7/6/16.
 */
public class Testa {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer[] a = list.stream().map(x -> {
                    System.out.println(x.toString());
                    return x;
                }
        ).toArray(Integer[]::new);

        Object r2 = (Runnable) () -> System.out.println("Howdy, world!");
        ((Runnable) r2).run();
    }
}
