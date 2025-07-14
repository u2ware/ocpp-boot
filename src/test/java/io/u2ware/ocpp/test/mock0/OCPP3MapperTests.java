package io.u2ware.ocpp.test.mock0;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;

import io.u2ware.ocpp.core.Call;
import io.u2ware.ocpp.core.CallError;
import io.u2ware.ocpp.core.CallException;
import io.u2ware.ocpp.core.CallResult;
import io.u2ware.ocpp.core.OCPPConversion;
import io.u2ware.ocpp.core.OCPPMessage;
import io.u2ware.ocpp.v1_6.model.AuthorizeRequest;
import io.u2ware.ocpp.v1_6.model.AuthorizeResponse;

public class OCPP3MapperTests {
    

    protected final Log logger = LogFactory.getLog(getClass());


    // private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void contextLoads() throws Exception {

        OCPPConversion mapper = new OCPPConversion();

        Call<Object> cc = new Call<>();
        cc.setId("1");
        cc.setAction("action");
        cc.setPayload(new AuthorizeRequest());
        cc.setPayload(new AuthorizeResponse());


        CallResult<String> cr = new CallResult<>();
        cr.setId("2");
        cr.setPayload("111");

        CallError<CallException> ce = new CallError<>();
        ce.setId("3");
        ce.setPayload(new CallException("1", "2", "ce"){});


        String m11 = mapper.convertMessage(cc);
        logger.info("m11: "+m11);
        OCPPMessage<?> m12 = mapper.convertMessage(m11);
        logger.info("m12: "+m12);
        logger.info("m12: "+m12.getPayload().getClass());



        String m21 = mapper.convertMessage(cr);
        logger.info("m21: "+m21);
        OCPPMessage<?> m22 = mapper.convertMessage(m21);
        logger.info("m22: "+m22);
        logger.info("m22: "+m22.getPayload().getClass());


        String m31 = mapper.convertMessage(ce);
        logger.info("m31: "+m31);
        OCPPMessage<?> m32 = mapper.convertMessage(m31);
        logger.info("m32: "+m32);
        logger.info("m32: "+m32.getPayload().getClass());


    }
}
