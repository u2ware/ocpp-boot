package io.u2ware.ocpp.test.mock0;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.core.Call;
import io.u2ware.ocpp.core.CallError;
import io.u2ware.ocpp.core.CallResult;
import io.u2ware.ocpp.core.CallType;
import io.u2ware.ocpp.core.OCPPMessage;

public class OCPP2MessageTests {
    
    protected final Log logger = LogFactory.getLog(getClass());


    // private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void contextLoads() throws Exception {


        OCPPMessage<String> msg0 = new OCPPMessage<>(){};
        print(msg0);


        Call<String> msg1 = new Call<>();
        print(msg1);


        CallResult<String> msg2 = new CallResult<>();
        print(msg2);


        CallError<?> msg3 = new CallError<>();
        print(msg3);
        

        // System.err.println(new OCPPIdentifier());
        // System.err.println(new OCPPIdentifier("aaaa", true));
        // System.err.println(new OCPPIdentifier("aaaa", false));
        // System.err.println(new OCPPIdentifier("aaaa@bbbb", true));
        // System.err.println(new OCPPIdentifier("aaaa@bbbb", false));
        // System.err.println(new OCPPIdentifier("@"));
        // System.err.println(new OCPPIdentifier("@aaaa"));
        // System.err.println(new OCPPIdentifier("aaaa@"));
        // System.err.println(new OCPPIdentifier("aaaa@bbbb"));


        String a = "111@ddd@333";
        String[] items = StringUtils.delimitedListToStringArray(a, "@", "@");

        for(String item : items){
            System.err.println(item);
        }


    }

    private void print(OCPPMessage<?> msg) {
        logger.info(msg+" ------------------------------");
        logger.info(CallType.Call.correct(msg));
        logger.info(CallType.CallResult.correct(msg));
        logger.info(CallType.CallError.correct(msg));

        logger.info(msg.getType());
        logger.info(msg.getPayload());
    }
}
