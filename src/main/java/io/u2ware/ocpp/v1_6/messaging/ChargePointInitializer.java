package io.u2ware.ocpp.v1_6.messaging;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


public class ChargePointInitializer implements InitializingBean, ApplicationContextAware {

    private ChargePoint operations;
    private ApplicationContext applicationContext;
    private MultiValueMap<String,String> metadata = new LinkedMultiValueMap<>();

    public ChargePointInitializer(ChargePoint operations) {
        this.operations = operations;
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
       
        Map<String, ChargePointHandler> handlers = applicationContext.getBeansOfType(ChargePointHandler.class);
        for(ChargePointHandler handler : handlers.values()) {
            operations.registerHandler(handler, metadata);
        }
    }

}