package org.training.microservice.resilience;

import java.util.function.Predicate;

public class ResultRetryHandler implements Predicate<String> {

    @Override
    public boolean test(String s) {
        if ("hello ali".equals(s)){
            return true;
        }
        return false;
    }

}
