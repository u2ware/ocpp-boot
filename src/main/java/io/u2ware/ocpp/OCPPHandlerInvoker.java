package io.u2ware.ocpp;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;


public class OCPPHandlerInvoker {

    protected final Log logger = LogFactory.getLog(getClass());

    private Object target;

    public OCPPHandlerInvoker(Object target){
        Assert.notNull(target, "target is null");
        this.target = target;
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
        return (Req)invokeMethod(target, method, id, req);
    }

    public <Req,Res> void receivedResponse(String action, String id, Res res, Object err) {
        String method = String.format("received%sResponse", action);
        invokeMethod(target, method, id, res,err);
    }

    @SuppressWarnings("unchecked")
    public <Req,Res> Res receivedRequest(String action, String id, Req req) {
        String method = String.format("received%sRequest", action);
        return (Res)invokeMethod(target, method, id, req);
    }
     
    public <Req,Res> void sendResponse(String action, String id, Res res, Object err) {
        String method = String.format("send%sResponse", action);
        invokeMethod(target, method, id, res, err);
    }


    /////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////
    public static String extractElement(Collection<String> elements, String source) {
        if(StringUtils.hasText(source)) { 
            for(String element : elements){
                // System.err.println(element+" "+source);
                if(source.contains(element)) {
                    return element;
                }
            }
        }
        return null;    
    } 

    public static Enum<?>[] appendElements(Enum<?>[]... s){
        int total = 0;
        for(Enum<?>[] ss : s) {
            total = total + ss.length;
        }
        Enum<?>[] r = new Enum<?>[total];
        int position = 0;
        for(Object[] ss : s) {
            System.arraycopy(ss, 0, r, position, ss.length);
            position = ss.length;
        }
        return r;
    }








    /////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////
    public static Class<?> resolveType(String name) {
        try{
            return ClassUtils.forName(name, OCPPHandlerOperations.class.getClassLoader());
        }catch(Exception e){
            return null;
        }
    }

    public static Method resolveMethod(Class<?> type, String name) {
        try{
            AtomicReference<Method> ref = new AtomicReference<>();
            ReflectionUtils.doWithMethods(type, (m)->{
                ReflectionUtils.makeAccessible(m);
                ref.set(m);
            }, (m)->{
                return m.getName().equals(name);
            });
            return ref.get();
        } catch (Exception e) {
            return null;
        }
    }



    /////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////
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