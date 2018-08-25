package com.kuldeep.functProg.fxncomposition;

public class CurryExample {

    public static void main(String[] args) {


        BinaryOperator add = x -> y -> x + y;


        BinaryOperator mult = x -> y -> x * y;

        System.out.println(add.apply(3).apply(5));

    }

    interface BinaryOperator extends Function<Integer, Function<Integer, Integer>> {

    }
}
