package org.training.common;

import org.training.microservice.common.error.RestErrorObj;

public class MSRestClientException extends RuntimeException {
    private RestErrorObj restErrorObj;

    public MSRestClientException(RestErrorObj restErrorObj) {
        super(restErrorObj.getDesc());
        this.restErrorObj = restErrorObj;
    }

    public MSRestClientException() {
    }

    public RestErrorObj getRestErrorObj() {
        return restErrorObj;
    }

    public void setRestErrorObj(RestErrorObj restErrorObj) {
        this.restErrorObj = restErrorObj;
    }
}
