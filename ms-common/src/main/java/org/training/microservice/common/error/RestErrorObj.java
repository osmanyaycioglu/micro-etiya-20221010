package org.training.microservice.common.error;

import javafx.print.Collation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RestErrorObj {
    private List<RestErrorObj> subErrors;
    private String             microservice;
    private String             desc;
    private Integer            code;

    public static RestErrorObj createRestErrorObj() {
        return new RestErrorObj();
    }

    public RestErrorObj addSubError(RestErrorObj restErrorObj) {
        if (subErrors == null) {
            subErrors = new ArrayList<>();
        }
        subErrors.add(restErrorObj);
        return this;

    }

    public RestErrorObj addSubErrors(Collection<RestErrorObj> restErrorObj) {
        if (subErrors == null) {
            subErrors = new ArrayList<>();
        }
        subErrors.addAll(restErrorObj);
        return this;

    }

    public List<RestErrorObj> getSubErrors() {
        return subErrors;
    }

    public RestErrorObj setSubErrors(List<RestErrorObj> subErrors) {
        this.subErrors = subErrors;
        return this;
    }

    public String getMicroservice() {
        return microservice;
    }

    public RestErrorObj setMicroservice(String microservice) {
        this.microservice = microservice;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public RestErrorObj setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public RestErrorObj setCode(Integer code) {
        this.code = code;
        return this;
    }

    public static void main(String[] args) {
        RestErrorObj errorObj = RestErrorObj.createRestErrorObj()
                                            .setMicroservice("ms1")
                                            .setDesc("test error")
                                            .setCode(1000)
                                            .addSubError(RestErrorObj.createRestErrorObj()
                                                                     .setMicroservice("ms2")
                                                                     .setDesc("test error 2")
                                                                     .setCode(1001))
                                            .addSubError(RestErrorObj.createRestErrorObj()
                                                                     .setMicroservice("ms3")
                                                                     .setDesc("test error 2")
                                                                     .setCode(1000));

    }
}
