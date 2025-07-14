package io.u2ware.ocpp.test.mock0;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

// import io.u2ware.ocpp.specifications.v2_0_1.model.APN;
// import io.u2ware.ocpp.specifications.v2_0_1.model.CustomData;


public class Model20Tests {
    

    public static void main(String[] args) throws JsonProcessingException{


        ObjectMapper m = new ObjectMapper();
        m.registerModule(new JavaTimeModule());

        // APN r0 = new APN();
        // System.out.println(r0);
        
        // APN r1 = APN.builder()
        //     // .useOnlyPreferredNetwork(false)
        //     .build();
        // System.out.println(r1);



        // CustomData c = CustomData.builder().additionalProperties("k","v").build();
        // System.out.println(c);


        // String j1 = m.writeValueAsString(c);
        // System.out.println(j1);

        // CustomData j2 = m.readValue(j1, CustomData.class);
        // System.out.println(j2);
    }
}
