package io.u2ware.ocpp.v2_0_1.messaging;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class CSMSInitializer implements InitializingBean, ApplicationContextAware {

    private CSMS operations;
    private ApplicationContext applicationContext;

    public CSMSInitializer(CSMS operations) {
        this.operations = operations;
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        Map<String, CSMSHandler> handlers = applicationContext.getBeansOfType(CSMSHandler.class);
        for(CSMSHandler handler : handlers.values()) {
            operations.registerFeature(handler);
        }
    }

}