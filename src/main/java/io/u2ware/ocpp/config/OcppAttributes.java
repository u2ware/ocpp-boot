package io.u2ware.ocpp.config;

import java.lang.annotation.Annotation;
import java.util.Map;

import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import io.u2ware.ocpp.core.OCPPVersion;
    
    
public class OcppAttributes {

    private AnnotationAttributes attributes;

    public OcppAttributes(AnnotationMetadata m, Class<? extends Annotation> a){
        Map<String, Object> s = m.getAnnotationAttributes(a.getName());
        this.attributes = new AnnotationAttributes(s);
    }

    public String getUri(){
        return attributes.getString("uri");
    }

    public boolean getAllowDefaultUsecase(){
        return attributes.getBoolean("allowDefaultUsecase");
    }    

    public OCPPVersion getVersion(){
        return (OCPPVersion)attributes.get("version");
    }    

}