package io.u2ware.ocpp.config;

import org.springframework.context.annotation.Import;

import io.u2ware.ocpp.core.OCPPVersion;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({
    WebSocketStompServerConfiguration.class, 

    OcppClientConfiguration.class,
    WebSocketStandardClientConfiguration.class, 
    
    WebSocketStandardClientConfiguration.Scheduller.class
})
public @interface EnableOcppClient {

    OCPPVersion version() default OCPPVersion.V2_0_1;
    
    String uri() default "wss://localhost:8080/ocpp";

    boolean allowDefaultUsecase() default false;
}