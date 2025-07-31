package io.u2ware.ocpp.v1_6.messaging.old;

import java.util.HashMap;
import java.util.Map;

public interface Ss {

    default String usecase() {return "";}
    public String action();

    default SpecificationFeature feature() {
        return feature(Long.toString(System.currentTimeMillis()), new HashMap<>());
    }

    default SpecificationFeature feature(String identifier) {
        return feature(identifier, new HashMap<>());
    }
   
    default SpecificationFeature feature(String identifier, Map<String,Object> attributes) {
        return createFeature(usecase(), action(), identifier, attributes);
    }

    default SpecificationFeature featureOf(String feature) {
        return featureOf(feature, Long.toString(System.currentTimeMillis()), new HashMap<>());
    }

    default SpecificationFeature featureOf(String feature, String identifier) {
        return featureOf(feature, identifier, new HashMap<>());
    }
   
    default SpecificationFeature featureOf(String feature, String identifier, Map<String,Object> attributes) {
        return createFeature(feature, action(), identifier, attributes);
    }

    private static SpecificationFeature createFeature(String usecase, String action, String identifier, Map<String,Object> attributes){
        SpecificationFeature u = new SpecificationFeature();
        u.setIdentifier(identifier+usecase);
        u.setUsecase(usecase);
        u.setAction(action);
        u.setAttributes(attributes);
        return u;
    }
}
