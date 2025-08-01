package io.u2ware.ocpp.test.base00;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.Call;
import io.u2ware.ocpp.CallError;
import io.u2ware.ocpp.CallResult;
import io.u2ware.ocpp.test.append0.SimpleMessageCallback;
import io.u2ware.ocpp.v1_6.messaging.*;
import io.u2ware.ocpp.v1_6.exception.*;
import io.u2ware.ocpp.v1_6.handlers.Authorize;
import io.u2ware.ocpp.v1_6.model.*;


public class OCPP51FeatureTests {

    protected final Log logger = LogFactory.getLog(getClass());
    
    @Test
    public void context1Loads() throws Exception {

        CentralSystem cs = new CentralSystem();
        cs.registerFeature(Authorize.CentralSystemHandler.DEFAULT);


        ChargePoint cp = new ChargePoint();        
        cp.registerFeature(Authorize.ChargePointHandler.DEFAULT);



        ////////////////////////////////////////////
        //
        ////////////////////////////////////////////
        String action = "Authorize";
        ChargePointCommand ci = io.u2ware.ocpp.v1_6.messaging.ChargePointCommand.Core.Authorize.build();
        SimpleMessageCallback x = new SimpleMessageCallback();


        Call<AuthorizeRequest> cc = new Call<>();
        cc.setId(action);
        cc.setAction(action);
        cc.setPayload(AuthorizeRequest.builder().build());

        CallResult<AuthorizeResponse> cr = new CallResult<>();
        cr.setId(action);
        cr.setPayload(AuthorizeResponse.builder().build());

        CallError<ErrorCode> ce = new CallError<>();
        ce.setId(action);
        ce.setPayload(ErrorCodes.GenericError.exception());

        ////////////////////////////////////////////////////////    
        cp.offer(ci, x);  x.sleep(500);
        Assertions.assertNotNull(x.msg());
        Assertions.assertNull(x.err());
        Assertions.assertTrue(ClassUtils.isAssignableValue(Call.class, x.msg()));
        Assertions.assertTrue(ClassUtils.isAssignableValue(AuthorizeRequest.class, x.msg().getPayload()));


        ////////////////////////////////////////////////////////
        cp.answer(cc, x); x.sleep(1000);
        Assertions.assertNull(x.msg());
        Assertions.assertNotNull(x.err());
        Assertions.assertTrue(StringUtils.endsWithIgnoreCase(x.err().getMessage(), "'receivedAuthorizeRequest' method cannot invoke"));


        cs.answer(cc, x); x.sleep(500);
        Assertions.assertNotNull(x.msg());
        Assertions.assertNull(x.err());
        Assertions.assertTrue(ClassUtils.isAssignableValue(CallResult.class, x.msg()));
        Assertions.assertTrue(ClassUtils.isAssignableValue(AuthorizeResponse.class, x.msg().getPayload()));


        ////////////////////////////////////////////////////////        
        cp.answer(cr, x); x.sleep(500);
        Assertions.assertNull(x.msg());
        Assertions.assertNull(x.err());

        cs.answer(cr, x); x.sleep(500);
        Assertions.assertNull(x.msg());
        Assertions.assertNotNull(x.err());
        Assertions.assertTrue(StringUtils.endsWithIgnoreCase(x.err().getMessage(), "'receivedAuthorizeResponse' method cannot invoke"));


        ////////////////////////////////////////////////////////        
        cp.answer(ce, x); x.sleep(500);
        Assertions.assertNull(x.msg());
        Assertions.assertNull(x.err());

        cs.answer(ce, x); x.sleep(500);
        Assertions.assertNull(x.msg());
        Assertions.assertNotNull(x.err());
        Assertions.assertTrue(StringUtils.endsWithIgnoreCase(x.err().getMessage(), "'receivedAuthorizeResponse' method cannot invoke"));

    }
}
