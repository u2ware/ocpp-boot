package io.u2ware.ocpp.test.base00;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

// import io.u2ware.ocpp.specifications.v1_6.model.SampledValue;
// import io.u2ware.ocpp.specifications.v1_6.model.TransactionDatum;

public class Model16Tests {
    

    public static void main(String[] args) throws JsonProcessingException{


        ObjectMapper m = new ObjectMapper();
        m.registerModule(new JavaTimeModule());

        // TransactionDatum r0 = new TransactionDatum();
        // r0.sampledValue();
        // System.out.println(r0);
        
        // TransactionDatum r1 = TransactionDatum.builder()
        //     .timestamp(ZonedDateTime.now())
        //     .sampledValue(SampledValue.builder().build())
        //     .sampledValue(SampledValue.builder().build())            
        //     .build();


        // System.out.println(r1);

        // String j1 = m.writeValueAsString(r1);
        // System.out.println(j1);

        // TransactionDatum j2 = m.readValue(j1, TransactionDatum.class);
        // System.out.println(j2);


    }
}
