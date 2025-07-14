package io.u2ware.ocpp.test.mock0;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

// import io.u2ware.ocpp.specifications.v2_1.model.CustomData;


public class Model21Tests {
    

    public static void main(String[] args) throws JsonProcessingException{


        ObjectMapper m = new ObjectMapper();
        m.registerModule(new JavaTimeModule());



        

        // CustomData r1 = CustomData.builder().build();
        // System.out.println(r1);

        

       
        // String j1 = m.writeValueAsString(r1);
        // System.out.println(j1);

        // CustomData j2 = m.readValue(j1, CustomData.class);
        // System.out.println(j2);

    }
}
