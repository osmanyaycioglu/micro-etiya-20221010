package org.training.microservice.msorder.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;
import org.training.microservice.common.error.RestErrorObj;

@Component
public class MyHealth implements HealthIndicator {
    @Override
    public Health health() {
        return Health.status(Status.UP)
                     .withDetail("myhealth",
                                 RestErrorObj.createRestErrorObj()
                                             .setDesc("HEalth test")
                                             .setCode(100)).build();
    }
}
