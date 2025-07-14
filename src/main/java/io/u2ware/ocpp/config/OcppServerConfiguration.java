package io.u2ware.ocpp.config;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

class OcppServerConfiguration implements ImportBeanDefinitionRegistrar{

    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        registry.registerBeanDefinition("ocppAttributes", 
            BeanDefinitionBuilder
                .genericBeanDefinition(OcppAttributes.class)
                .addConstructorArgValue(importingClassMetadata)
                .addConstructorArgValue(EnableOcppServer.class)
                .getBeanDefinition());


        OcppAttributes a = new OcppAttributes(importingClassMetadata, EnableOcppServer.class);
        switch (a.getVersion()) {
            case V1_6: {

                registry.registerBeanDefinition("ocppOperations", BeanDefinitionBuilder
                    .genericBeanDefinition(io.u2ware.ocpp.v1_6.messaging.CentralSystem.class)
                    .getBeanDefinition());
                
                
                registry.registerBeanDefinition("ocppTemplate", BeanDefinitionBuilder
                    .genericBeanDefinition(io.u2ware.ocpp.v1_6.messaging.SpecificationSendingTemplate.class)
                    .addConstructorArgReference("ocppOperations")
                    .addConstructorArgReference("brokerMessagingTemplate")
                    .getBeanDefinition());


                registry.registerBeanDefinition("ocppInitializer", BeanDefinitionBuilder
                    .genericBeanDefinition(io.u2ware.ocpp.v1_6.messaging.SpecificationOperationsInitializer.class)
                    .addConstructorArgReference("ocppOperations")
                    .addConstructorArgValue(a.getAllowDefaultUsecase())
                    .getBeanDefinition());


                return;
            }
            case V2_0_1: {
                registry.registerBeanDefinition("ocppOperations", BeanDefinitionBuilder
                    .genericBeanDefinition(io.u2ware.ocpp.v2_0_1.messaging.CSMS.class)
                    .getBeanDefinition());
                
                
                registry.registerBeanDefinition("ocppTemplate", BeanDefinitionBuilder
                    .genericBeanDefinition(io.u2ware.ocpp.v2_0_1.messaging.SpecificationSendingTemplate.class)
                    .addConstructorArgReference("ocppOperations")
                    .addConstructorArgReference("brokerMessagingTemplate")
                    .getBeanDefinition());


                registry.registerBeanDefinition("ocppInitializer", BeanDefinitionBuilder
                    .genericBeanDefinition(io.u2ware.ocpp.v2_0_1.messaging.SpecificationOperationsInitializer.class)
                    .addConstructorArgReference("ocppOperations")
                    .addConstructorArgValue(a.getAllowDefaultUsecase())
                    .getBeanDefinition());

                return;

            }
            case V2_1: {
                
            };
            default: {
                

            }
        }
    }
}
