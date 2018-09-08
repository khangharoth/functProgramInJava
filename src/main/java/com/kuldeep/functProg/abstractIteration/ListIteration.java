package com.kuldeep.functProg.abstractIteration;

import com.kuldeep.functProg.fxncomposition.Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ListIteration {

    private static Function<Integer, Double> addTPFunc = x -> x * 1.2;

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);


        IntStream.range(1, 100000).parallel().forEach(i -> IntStream.range(1, 100000).forEach(j -> {
            List<Double> newList = map(integerList, addTPFunc);
            newList.forEach(System.out::println);
        }));


    }

    private static <T, U> List<T> map(List<U> list, Function<U, T> f) {
        List<T> newList = new ArrayList<>();

        for (U value : list) {
            newList.add(f.apply(value));
        }
        return newList;
    }

    private static double addTwentyPercent(Integer value) {
        return value * 1.2;
    }
}
