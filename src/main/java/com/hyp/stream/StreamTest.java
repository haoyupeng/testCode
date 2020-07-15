package com.hyp.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        //        Stream<Integer> dd = Stream.iterate(2, x->x+1);
//        dd.limit(10).forEach(System.out::println);

//        int sum = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8).stream().filter(x -> x % 2 == 0).mapToInt(x -> x).sum();
//        System.out.println(sum);
//
//        Stream<Integer> ddddddddddddddd = Arrays.asList( 5, 6, 7,1, 2, 3, 4).stream().filter(x -> {
//            System.out.println("ddddddddddddddd");
//            return x % 2 == 0;
//        });
//
//        System.out.println(ddddddddddddddd.max((a,b)->a -b).get());

        Stream.iterate(1,x->x+1).limit(50).skip(30).forEach(System.out::println);

    }
}
