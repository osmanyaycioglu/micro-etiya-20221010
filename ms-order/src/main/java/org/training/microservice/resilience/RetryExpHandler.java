package org.training.microservice.resilience;

import org.training.common.MSRestClientException;
import org.training.microservice.common.error.RestErrorObj;

import java.io.IOException;
import java.util.function.Predicate;

public class RetryExpHandler implements Predicate<Throwable> {

    @Override
    public boolean test(Throwable throwable) {
        if (throwable instanceof MSRestClientException) {
            MSRestClientException exception = (MSRestClientException) throwable;
            RestErrorObj restErrorObj = exception.getRestErrorObj();
            if (restErrorObj != null) {
                Integer code = restErrorObj.getCode();
                switch (code) {
                    case 1024:
                    case 1025:
                    case 2048:
                    case 3055:
                        return true;
                    default:
                        return false;
                }
            }
        } else if (throwable instanceof IOException) {
            return true;
        }

        return false;
    }
}
