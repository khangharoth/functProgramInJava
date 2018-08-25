package com.kuldeep.functProg.abscontrolstr;

import com.kuldeep.functProg.fxncomposition.Function;

import java.util.regex.Pattern;

import static com.kuldeep.functProg.abscontrolstr.Case.match;
import static com.kuldeep.functProg.abscontrolstr.Case.mcase;
import static com.kuldeep.functProg.abscontrolstr.Result.failure;
import static com.kuldeep.functProg.abscontrolstr.Result.success;
import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static java.util.regex.Pattern.compile;

public class EmailValidation {
    private final Pattern emailPattern = compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", CASE_INSENSITIVE);


    private static final Effect<String> success = s -> System.out.println("Verification mail send to " + s);
    private static final Effect<String> failure = s -> System.out.println("Error message logged " + s);

    private final Function<String, Result<String>> emailChecker = s -> match(
            mcase(() -> success(s)),
            mcase(() -> s == null, () -> failure("email must not be null")),
            mcase(() -> s.length() == 0, () -> failure("email must not be empty")),
            mcase(() -> !emailPattern.matcher(s).matches(), () -> failure("email " + s + " is invalid")));


    public static void main(String[] args) {
        new EmailValidation().emailChecker.apply("kul@db.com").bind(success, failure);
    }

}
