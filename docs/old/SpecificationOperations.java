package io.u2ware.ocpp.v1_6.messaging.old;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.ClassUtils;

import io.u2ware.ocpp.core.OCPPConsumer;
import io.u2ware.ocpp.core.OCPPMessage;
import io.u2ware.ocpp.core.OCPPOperations;
import io.u2ware.ocpp.core.OCPPReflection;
import io.u2ware.ocpp.core.OCPPVersion;

public abstract class SpecificationOperations extends OCPPOperations{

    protected Map<String, OCPPReflection> usecase = new HashMap<>();
    
    // public void registerFeature(Specification u) {
    //     Class<?> type = featureClass(u.usecase());
    //     if(type != null) {
    //         Object target = OCPPReflection.invokeField(type, "DEFAULT");
    //         logger.info(String.format("[%s] %s(%s)", name(), u.usecase(), ClassUtils.getDescriptiveType(target)));
    //         this.usecase.put(u.usecase(), new OCPPReflection(target));
    //         return;
    //     }
    //     type = featureClass(u.action());
    //     if(type != null) {            
    //         Object target = OCPPReflection.invokeField(type, "DEFAULT");
    //         logger.info(String.format("[%s] %s(%s)", name(), u.action(), ClassUtils.getDescriptiveType(target)));
    //         this.usecase.put(u.action(), new OCPPReflection(target));
    //         return;
    //     }
    // }

    // public void offer(SpecificationFeature feature, OCPPConsumer<OCPPMessage<?>> consumer) {
    //     super.offer(()->{ 
    //         return feature;
    //     }, consumer);
    // }


    @Override
    public OCPPReflection feature(String source) {
        if(usecase.containsKey(source)) return usecase.get(source);
        String key = OCPPReflection.extractElement(usecase.keySet(), source);
        return usecase.get(key);
    }


    @Override
    public String name() {
        return ClassUtils.getShortName(getClass());
    }

    @Override
    public OCPPVersion version() {
        return OCPPVersion.V1_6;
    }

    ////////////////////////////////
    //
    ////////////////////////////////
    // public void offer(SpecificationFeature source, OCPPConsumer<OCPPMessage<?>> consumer) {
    //     super.offer(()->{ 
    //         return source;
    //     }, consumer);
    // }

    // public void offer(String source, OCPPConsumer<String> consumer) {
    //     super.offer(()->{
    //         SpecificationAction a = conversion.comfortableReadValue(source, SpecificationAction.class);
    //         return a;
    //     }, (t,u)->{
    //         if( t != null) {
    //             String s = null;
    //             Throwable x = null;
    //             try{
    //                 s = conversion.convertMessage(t);
    //                 x = u;
    //             }catch(Exception e){
    //                 s = null;
    //                 x = e;
    //             }
    //             consumer.accept(s, x);
    //         }else{
    //             consumer.accept(null, u);
    //         }
    //     });
    // }   
}
