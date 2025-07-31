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
	
	OcppServerConfiguration.class,
	WebSocketStandardServerConfiguration.class
})
public @interface EnableOcppServer {

    OCPPVersion version() default OCPPVersion.V2_0_1;
    
    String uri() default "/ocpp";

    // boolean allowDefaultUsecase() default false;
}