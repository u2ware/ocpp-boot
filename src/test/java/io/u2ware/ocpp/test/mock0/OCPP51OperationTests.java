package io.u2ware.ocpp.test.mock0;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.core.*;
import io.u2ware.ocpp.v1_6.messaging.*;
import io.u2ware.ocpp.v1_6.exception.*;
import io.u2ware.ocpp.v1_6.model.*;


public class OCPP51OperationTests {

    protected final Log logger = LogFactory.getLog(getClass());


    
    @Test
    public void context1Loads() throws Exception {



        CentralSystem cs = new CentralSystem();
        cs.registerDefaultUsecase(Specification.InitiatedByChargePoint.Usecase.Authorize);


        ChargePoint cp = new ChargePoint();        
        cp.registerDefaultUsecase(Specification.InitiatedByChargePoint.Usecase.Authorize);
        
        SimpleMessageCallback x = new SimpleMessageCallback();



        ////////////////////////////////////////////
        //
        ////////////////////////////////////////////
        String action = "Authorize";

        // logger.info("1: "+OCPPIdentifierBuilder.fromAction(action).build());
        // logger.info("2: "+OCPPIdentifierBuilder.fromAction(action).action("action").build());
        // logger.info("3: "+OCPPIdentifierBuilder.fromAction(action).unique("unique").usecase("usecase").session("session").build());
        // logger.info("4: "+OCPPIdentifierBuilder.fromMessageId("XXAuthorizeYY").build());
        // logger.info("5: "+OCPPIdentifierBuilder.fromMessageId("XXAuthorizeYY").action("action").build());
        // logger.info("6: "+OCPPIdentifierBuilder.fromMessageId("XXAuthorizeYY").unique("unique").usecase("usecase").session("session").build());
        // // logger.info("7: "+OCPPIdentifierBuilder.fromMessageId("XXAuthorizeYY").unique("unique").usecase(Arrays.asList("XX")).session(Arrays.asList("YY")).build());

        SpecificationAction ci = Specification.InitiatedByChargePoint.Usecase.Authorize.message(action);
        // OCPPAction ci = Specification.InitiatedByChargePoint.Authorize.Authorize.action(action);


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
        Assertions.assertNotNull(x.getMsg());
        Assertions.assertNull(x.getErr());
        Assertions.assertTrue(ClassUtils.isAssignableValue(Call.class, x.getMsg()));
        Assertions.assertTrue(ClassUtils.isAssignableValue(AuthorizeRequest.class, x.getMsg().getPayload()));


        cs.offer(ci, x);  x.sleep(500);
        Assertions.assertNull(x.getMsg());
        Assertions.assertNotNull(x.getErr());
        Assertions.assertTrue(StringUtils.endsWithIgnoreCase(x.getErr().getMessage(), "'sendAuthorizeRequest' method cannot invoke"));


        ////////////////////////////////////////////////////////
        cp.answer(cc, x); x.sleep(1000);
        Assertions.assertNull(x.getMsg());
        Assertions.assertNotNull(x.getErr());
        Assertions.assertTrue(StringUtils.endsWithIgnoreCase(x.getErr().getMessage(), "'receivedAuthorizeRequest' method cannot invoke"));


        cs.answer(cc, x); x.sleep(500);
        Assertions.assertNotNull(x.getMsg());
        Assertions.assertNull(x.getErr());
        Assertions.assertTrue(ClassUtils.isAssignableValue(CallResult.class, x.getMsg()));
        Assertions.assertTrue(ClassUtils.isAssignableValue(AuthorizeResponse.class, x.getMsg().getPayload()));


        ////////////////////////////////////////////////////////        
        cp.answer(cr, x); x.sleep(500);
        Assertions.assertNull(x.getMsg());
        Assertions.assertNull(x.getErr());

        cs.answer(cr, x); x.sleep(500);
        Assertions.assertNull(x.getMsg());
        Assertions.assertNotNull(x.getErr());
        Assertions.assertTrue(StringUtils.endsWithIgnoreCase(x.getErr().getMessage(), "'receivedAuthorizeResponse' method cannot invoke"));


        logger.info("-------------------------");
        ////////////////////////////////////////////////////////        
        cp.answer(ce, x); x.sleep(500);
        Assertions.assertNull(x.getMsg());
        Assertions.assertNull(x.getErr());

        cs.answer(ce, x); x.sleep(500);
        Assertions.assertNull(x.getMsg());
        Assertions.assertNotNull(x.getErr());
        Assertions.assertTrue(StringUtils.endsWithIgnoreCase(x.getErr().getMessage(), "'receivedAuthorizeResponse' method cannot invoke"));

    }
}
