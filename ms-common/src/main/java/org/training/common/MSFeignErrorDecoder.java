package org.training.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.training.microservice.common.error.RestErrorObj;

import java.io.IOException;
import java.io.InputStream;

public class MSFeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey,
                            Response response) {
        try {
            InputStream inputStream = response.body()
                                              .asInputStream();
            ObjectMapper objectMapper = new ObjectMapper();
            RestErrorObj errorObj = objectMapper.readValue(inputStream,
                                                           RestErrorObj.class);
            return new MSRestClientException(errorObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new MSRestClientException();
    }
}
