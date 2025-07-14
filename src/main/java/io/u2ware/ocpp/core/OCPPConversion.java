package io.u2ware.ocpp.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.ClassUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class OCPPConversion {
    
    protected final Log logger = LogFactory.getLog(getClass());

    private ObjectMapper mapper ;


    public OCPPConversion(){
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }        


    // public OCPPPredicate convertAction(String text) {
    //     try {
    //         return mapper.readValue(text, OCPPPredicate.class);
    //     } catch (Exception e) {
    //         throw new RuntimeException(e);
    //     }        
    // }
    // public String convertAction(OCPPPredicate m) {
    //     try {
    //         return mapper.writeValueAsString(m);
    //     } catch (Exception e) {
    //         throw new RuntimeException(e);
    //     }
    // }


    public OCPPMessage<?> convertMessage(String text) {
        try {
            JsonNode n = mapper.readTree(text);
            if(n == null) throw new RuntimeException("node is null");
            if(! n.isArray()) throw new RuntimeException("node is not array");

            ArrayNode elements = (ArrayNode)n;
            Integer size = elements.size();
            int type = elements.get(0).asInt();

            if(CallType.Call.correct(type, size)) {

                String id = elements.get(1).asText();
                String action = elements.get(2).asText();
                JsonNode payload = elements.get(3);

                Call<JsonNode> m = new Call<>();
                m.setId(id);
                m.setAction(action);
                m.setPayload(payload);
                return m;


            }else if(CallType.CallResult.correct(type, size)) {

                String id = elements.get(1).asText();
                JsonNode payload = elements.get(2);

                CallResult<JsonNode> m = new CallResult<>();
                m.setId(id);
                m.setPayload(payload);
                return m;

            }else if(CallType.CallError.correct(type, size)) {

                String id = elements.get(1).asText();
                String code = elements.get(2).asText();
                String description = elements.get(3).asText();
                JsonNode payload = elements.get(4);

                CallException e = new CallException(code, description, payload) {};

                CallError<CallException> m = new CallError<>();
                m.setId(id);
                m.setPayload(e);
                return m;

            }else{
                throw new RuntimeException("unconfirmed message. type="+type+", size="+size);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public String convertMessage(OCPPMessage<?> m) {
        try {        
            ArrayNode elements = null;

            if(CallType.Call.correct(m)) {

                Call<?> cc = (Call<?>)m;

                elements = mapper.createArrayNode();
                elements.add(CallType.Call.type());
                elements.add(cc.getId());
                elements.add(cc.getAction());
                elements.add(mapper.convertValue(cc.getPayload(), JsonNode.class));


            }else if(CallType.CallResult.correct(m)) {
                CallResult<?> cr = (CallResult<?>)m;

                elements = mapper.createArrayNode();
                elements.add(CallType.CallResult.type());
                elements.add(cr.getId());
                elements.add(mapper.convertValue(cr.getPayload(), JsonNode.class));            

            }else if(CallType.CallError.correct(m)) {

                CallError<?> ce = (CallError<?>)m;       

                elements = mapper.createArrayNode();
                elements.add(CallType.CallError.type());
                elements.add(ce.getId());
                elements.add(ce.getPayload().getCode());
                elements.add(ce.getPayload().getDescription());
                elements.add(mapper.convertValue(ce.getPayload().getDetails(), JsonNode.class));

            } else {
                throw new RuntimeException("unconfirmed message. type is not found");
            }

            return mapper.writeValueAsString(elements);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    public Object convertPayload(Object payload, Class<?> type) {
        if(ClassUtils.isAssignableValue(JsonNode.class, payload)) {
            return mapper.convertValue(payload, type);
        }
        return payload;
    }





    public <T> T comfortableReadValue(String json, Class<T> type) {
        try{
            return mapper.readValue(json, type);
        }catch(Exception e){
            return null;
        }
    }

    public String comfortableWriteValue(Object value) {
        try{
            return mapper.writeValueAsString(value);
        }catch(Exception e){
            return null;
        }
    }






    // @SuppressWarnings("unchecked")
    // public Map<String,Object> writeValueAsMap(Object payload) {

    //     if(ObjectUtils.isEmpty(payload)) return new HashMap<>();

    //     Map<String,Object> result = null;

    //     if(ClassUtils.isAssignableValue(Throwable.class, payload)) {
    //         Throwable t = (Throwable)payload;
    //         ArrayList<String> stack = new ArrayList<>();
    //         while(t != null) {
    //             stack.add(stack.toString());
    //             t = t.getCause();
    //         }
    //         result = new HashMap<>();
    //         result.put("exception", stack);
    //         return result;
    //     }

    //     try{
    //         result = mapper.convertValue(payload, Map.class);
    //     }catch(Exception e){
    //         result = null;
    //     }
    //     if(result != null) return result;
    //     return new HashMap<>();
    // }











    // public JsonNode fromText(String text) {
    //     try {
    //         return mapper.readTree(text);
    //     } catch (Exception e) {
    //         throw new RuntimeException(e);
    //     }
    // }
    // public String toText(JsonNode node) {
    //     try {
    //         return mapper.writeValueAsString(node);
    //     } catch (Exception e) {
    //         return null;
    //     }
    // }

    // ////////////////////////////////////////////////////////
    // //
    // ////////////////////////////////////////////////////////
    // public Object convert(Object payload, Class<?> type) {
    //     if(ClassUtils.isAssignableValue(JsonNode.class, payload)) {
    //         return mapper.convertValue(payload, type);
    //     }
    //     return payload;
    // }


    // ////////////////////////////////////////////////////////
    // //
    // ////////////////////////////////////////////////////////
    // public JsonNode fromMessage(OCPPMessage<?> m) {

    //     if(OCPPMessageType.Call.correct(m)) {

    //         Call<?> cc = (Call<?>)m;

    //         ArrayNode elements = mapper.createArrayNode();
    //         elements.add(OCPPMessageType.Call.type());
    //         elements.add(cc.getId());
    //         elements.add(cc.getAction());
    //         elements.add(mapper.convertValue(cc.getPayload(), JsonNode.class));

    //         return elements;

    //     }else if(OCPPMessageType.CallResult.correct(m)) {
    //         CallResult<?> cr = (CallResult<?>)m;

    //         ArrayNode elements = mapper.createArrayNode();
    //         elements.add(OCPPMessageType.CallResult.type());
    //         elements.add(cr.getId());
    //         elements.add(mapper.convertValue(cr.getPayload(), JsonNode.class));            
    //         return elements;

    //     }else if(OCPPMessageType.CallError.correct(m)) {

    //         CallError<?> ce = (CallError<?>)m;       

    //         ArrayNode elements = mapper.createArrayNode();
    //         elements.add(OCPPMessageType.CallError.type());
    //         elements.add(ce.getId());
    //         elements.add(ce.getPayload().getCode());
    //         elements.add(ce.getPayload().getDescription());
    //         elements.add(mapper.convertValue(ce.getPayload().getDetails(), JsonNode.class));
    //         return elements;

    //     } else {
    //         throw new RuntimeException("unconfirmed message. type is not found");
    //     }
    // }  


    // public OCPPMessage<?> toMessage(JsonNode n) {

    //     if(n == null) throw new RuntimeException("node is null");
    //     if(! n.isArray()) return mapper.convertValue(n, OCPPMessage.class);

    //     ArrayNode elements = (ArrayNode)n;
    //     Integer size = elements.size();
    //     int type = elements.get(0).asInt();

    //     if(OCPPMessageType.Call.correct(type, size)) {

    //         String id = elements.get(1).asText();
    //         String action = elements.get(2).asText();
    //         JsonNode payload = elements.get(3);

    //         Call<JsonNode> m = new Call<>();
    //         m.setId(id);
    //         m.setAction(action);
    //         m.setPayload(payload);
    //         return m;


    //     }else if(OCPPMessageType.CallResult.correct(type, size)) {

    //         String id = elements.get(1).asText();
    //         JsonNode payload = elements.get(2);

    //         CallResult<JsonNode> m = new CallResult<>();
    //         m.setId(id);
    //         m.setPayload(payload);
    //         return m;

    //     }else if(OCPPMessageType.CallError.correct(type, size)) {

    //         String id = elements.get(1).asText();
    //         String code = elements.get(2).asText();
    //         String description = elements.get(3).asText();
    //         JsonNode payload = elements.get(4);

    //         OCPPMessageException e = new OCPPMessageException(code, description, payload) {};

    //         CallError<OCPPMessageException> m = new CallError<>();
    //         m.setId(id);
    //         m.setPayload(e);
    //         return m;

    //     }else{
    //         throw new RuntimeException("unconfirmed message. type="+type+", size="+size);
    //     }
    // }
}
