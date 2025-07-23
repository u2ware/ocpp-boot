package io.u2ware.ocpp.v1_6.messaging;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class SpecificationOperationsInitializer implements InitializingBean, ApplicationContextAware {

    private boolean allowDefaultUsecase;
    private SpecificationOperations operations;
    private ApplicationContext applicationContext;

    public SpecificationOperationsInitializer(SpecificationOperations operations, boolean allowDefaultUsecase) {
        this.operations = operations;
        this.allowDefaultUsecase = allowDefaultUsecase;
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        Specification[] usecase = Specification.usecases(null);
        for(Specification u : usecase) {

            Class<?> type = operations.usecaseClass(u.usecase());
            if(type == null) continue;
            
            if(allowDefaultUsecase) {
                operations.registerDefaultUsecase(u);
            }

            String[] beanNames = applicationContext.getBeanNamesForType(type);
            if(beanNames.length == 0) continue;
            String beanName = beanNames[beanNames.length-1];
            // System.err.println(beanName);

            Object target = applicationContext.getBean(beanName);
            // System.err.println(target);

            operations.registerUsecase(u, target);
        }
    }
}