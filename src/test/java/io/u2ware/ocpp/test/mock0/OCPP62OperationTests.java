package io.u2ware.ocpp.test.mock0;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.u2ware.ocpp.v1_6.messaging.*;

public class OCPP62OperationTests {
    

    protected final Log logger = LogFactory.getLog(getClass());


    @Test
    public void contextLoads()  {

        // String usecase = "Hello";
        String action = "Authorize";

        SimpleMessageCallback x = new SimpleMessageCallback();

        ChargePoint cp = new ChargePoint();
        cp.registerUsecase(Specification.InitiatedByChargePoint.Usecase.Authorize, new SimpleAuthorizeOffer("cp1", SimpleAuthorizeOffer.Test.OK));


        CentralSystem cs = new CentralSystem();
        cs.registerUsecase(Specification.InitiatedByChargePoint.Usecase.Authorize, new SimpleAuthorizeAnswer("cp1", SimpleAuthorizeAnswer.Test.OK));


        SpecificationAction ca = Specification.InitiatedByChargePoint.Usecase.Authorize.message(action);

        cp.offer(ca, x); x.sleep(500);
        Assertions.assertNotNull(x.getMsg());
        Assertions.assertNull(x.getErr());

        cs.answer(x.getMsg(), x); x.sleep(500);
        Assertions.assertNotNull(x.getMsg());
        Assertions.assertNull(x.getErr());

        cp.answer(x.getMsg(), x); x.sleep(500);
        Assertions.assertNull(x.getMsg());
        Assertions.assertNull(x.getErr());
    }
}
