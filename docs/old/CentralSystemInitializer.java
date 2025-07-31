package io.u2ware.ocpp.v1_6.messaging;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class CentralSystemInitializer implements InitializingBean, ApplicationContextAware {

    private CentralSystem operations;
    private ApplicationContext applicationContext;

    public CentralSystemInitializer(CentralSystem operations) {
        this.operations = operations;
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        Map<String, CentralSystemHandler> handlers = applicationContext.getBeansOfType(CentralSystemHandler.class);
        for(CentralSystemHandler handler : handlers.values()) {
            operations.register(handler);
        }
    } 
}