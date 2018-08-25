package com.kuldeep.functProg.abscontrolstr;

import java.util.function.Supplier;

class Case<T> extends Tuple<Supplier<Boolean>, Supplier<Result<T>>> {
    Case(Supplier<Boolean> booleanSupplier, Supplier<Result<T>> resultSupplier) {
        super(booleanSupplier, resultSupplier);
    }

    private static class DefaultCase<T> extends Case<T> {
        DefaultCase(Supplier<Boolean> booleanSupplier, Supplier<Result<T>> resultSupplier) {
            super(booleanSupplier, resultSupplier);
        }
    }

    static <T> Case<T> mcase(Supplier<Boolean> condition, Supplier<Result<T>> value) {
        return new Case<>(condition, value);
    }

    static <T> DefaultCase<T> mcase(Supplier<Result<T>> value) {
        return new DefaultCase<>(() -> true, value);
    }

    @SafeVarargs
    static <T> Result<T> match(final DefaultCase<T> defaultCase, final Case<T>... matchers) {


        for (Case<T> aCase : matchers) {
            if (aCase.getFirst().get()) {
                return aCase.getSecond().get();
            }
        }
        return defaultCase.getSecond().get();

    }
}
