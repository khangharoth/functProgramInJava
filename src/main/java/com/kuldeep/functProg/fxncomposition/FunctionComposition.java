package com.kuldeep.functProg.fxncomposition;

public class FunctionComposition {

    public static void main(String[] args) {


        Function<Function<Integer, Integer>, Function<Function<Integer, Integer>,
                Function<Integer, Integer>>> compose = x -> y -> z -> x.apply(y.apply(z));

        Function<Integer, Integer> triple = arg -> arg * 3;
        Function<Integer, Integer> square = arg -> arg * arg;

        Function<Integer, Integer> composedFunction = compose.apply(triple).apply(square);
        System.out.println(composedFunction.apply(2));
    }


}
