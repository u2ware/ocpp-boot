package io.u2ware.ocpp.core;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;


public class OCPPReflection {

    protected final Log logger = LogFactory.getLog(getClass());

    private String name;
    private Object target;

    public OCPPReflection(String name, Object target){
        this.name = name;
        this.target = target;
    }

    public Object target() {
        return target;
    }

    public void target(Object target) {
        this.target = target;
    }

    public String name(){
        return name;
    }

    public String toString(){
        return target.toString();
    }


    /////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////
    @SuppressWarnings("unchecked")
    public <Req,Res> Req sendRequest(String action, String id, Res req) {
        String method = String.format("send%sRequest", action);
        return (Req)invokeMethod(target(), method, id, req);
    }

    public <Req,Res> void receivedResponse(String action, String id, Res res, Object err) {
        String method = String.format("received%sResponse", action);
        invokeMethod(target(), method, id, res,err);
    }

    @SuppressWarnings("unchecked")
    public <Req,Res> Res receivedRequest(String action, String id, Req req) {
        String method = String.format("received%sRequest", action);
        return (Res)invokeMethod(target(), method, id, req);
    }
     
    public <Req,Res> void sendResponse(String action, String id, Res res, Object err) {
        String method = String.format("send%sResponse", action);
        invokeMethod(target(), method, id, res, err);
    }


    public boolean isOffer(String action){
        try {
            Class<?> type = target.getClass();

            AtomicReference<Boolean> result = new AtomicReference<>(false);
            ReflectionUtils.doWithMethods(type, (m)->{
                result.set(true);
            }, (m)->{
                String method1 = String.format("send%sRequest", action);
                String method2 = String.format("received%sResponse", action);
                return m.getName().equals(method1) || m.getName().equals(method2);
            });
            return result.get();

        } catch (Exception e) {
             return false;
        }
    }
    public boolean isAnswer(String action){
        try {
            Class<?> type = target.getClass();

            AtomicReference<Boolean> result = new AtomicReference<>(false);
            ReflectionUtils.doWithMethods(type, (m)->{
                result.set(true);
            }, (m)->{
                String method1 = String.format("received%sRequest", action);
                String method2 = String.format("send%sResponse", action);
                return m.getName().equals(method1) || m.getName().equals(method2);
            });
            return result.get();

        } catch (Exception e) {
             return false;
        }
    }



    /////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////
    public static Class<?> invokeType(String name) {
        try{
            return ClassUtils.forName(name, OCPPOperations.class.getClassLoader());
        }catch(Exception e){
            return null;
        }
    }
    
    /////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////
    public static String extractElement(Collection<String> elements, String source) {
        if(StringUtils.hasText(source)) { 
            for(String element : elements){
                if(source.contains(element)) {
                    return element;
                }
            }
        }
        return null;    
    }    
    
    public static Object invokeInstance(Class<?> type) {
        try {
            return type.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("'"+type+"' instance cannot invoke", e);
        }        
    }

    public static Object invokeField(Class<?> type, String name) {
        try {
            Field field = ReflectionUtils.findField(type, name);
            return field.get(null);
        } catch (Exception e) {
            throw new RuntimeException("'"+name+"' field cannot invoke", e);
        }        
    }


    public static Object invokeMethod(Object target, String name, Object... args){
        try {
            // System.out.println(name);
            // System.out.println(target);
            // System.out.println(target);

            Class<?> type = target.getClass();

            AtomicReference<Method> ref = new AtomicReference<>();
            ReflectionUtils.doWithMethods(type, (m)->{
                ReflectionUtils.makeAccessible(m);
                ref.set(m);
            }, (m)->{
                return m.getName().equals(name);
            });
            Method method = ref.get();

            // System.out.println(method);

            return ReflectionUtils.invokeMethod(method, target, args);

        } catch (Exception e) {
            // e.printStackTrace();
            throw new RuntimeException("'"+name+"' method cannot invoke", e);
        }
    }
}