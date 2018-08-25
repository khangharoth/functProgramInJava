package com.kuldeep.functProg.fxncomposition;

public class ComposeMain {

    public static void main(String[] args) {
        Function<Integer, Integer> triple = arg -> arg * 3;
        Function<Integer, Integer> square = arg -> arg * arg;

        System.out.println(square.apply(triple.apply(3)));
        System.out.println(compose(square, triple).apply(3));
    }

    private static Function<Integer, Integer> compose(Function<Integer, Integer> f1, Function<Integer, Integer> f2) {
        return arg -> f1.apply(f2.apply(arg));
    }


}


