package io.u2ware.ocpp.v2_0_1.messaging.old3;

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

    public void registerFeature(Specification u) {
        Class<?> type = featureClass(u.usecase());
        if(type != null) {
            Object target = OCPPReflection.invokeField(type, "DEFAULT");
            logger.info(String.format("[%s] %s(%s)", name(), u.usecase(), ClassUtils.getDescriptiveType(target)));
            this.usecase.put(u.usecase(), new OCPPReflection(target));
            return;
        }
        type = featureClass(u.action());
        if(type != null) {            
            Object target = OCPPReflection.invokeField(type, "DEFAULT");
            logger.info(String.format("[%s] %s(%s)", name(), u.action(), ClassUtils.getDescriptiveType(target)));
            this.usecase.put(u.action(), new OCPPReflection(target));
            return;
        }
    }


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
        return OCPPVersion.V2_0_1;
    }

    ////////////////////////////////
    //
    ////////////////////////////////
    public void offer(SpecificationFeature source, OCPPConsumer<OCPPMessage<?>> consumer) {
        super.offer(()->{ 
            return source;
        }, consumer);
    }

    // public void offer(String source, OCPPConsumer<String> consumer) {
    //     super.offer(()->{
    //         SpecificationFeature a = conversion.comfortableReadValue(source, SpecificationFeature.class);
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