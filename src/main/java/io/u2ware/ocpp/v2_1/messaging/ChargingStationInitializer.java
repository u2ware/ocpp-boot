package io.u2ware.ocpp.v2_1.messaging;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;



public class ChargingStationInitializer implements InitializingBean, ApplicationContextAware {

    private ChargingStation operations;
    private ApplicationContext applicationContext;
    private MultiValueMap<String,Object> metadata = new LinkedMultiValueMap<>();


    public ChargingStationInitializer(ChargingStation operations) {
        this.operations = operations;
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, ChargingStationHandler> handlers = applicationContext.getBeansOfType(ChargingStationHandler.class);
        for(ChargingStationHandler handler : handlers.values()) {
            operations.registerHandler(handler, metadata);
        }
    }

}