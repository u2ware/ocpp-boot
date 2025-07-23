package io.u2ware.ocpp.test.mock0;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.messaging.*;
import io.u2ware.ocpp.v1_6.exception.*;

public class OCPP61OperationTests {
    
    protected final Log logger = LogFactory.getLog(getClass());


    @Test
    public void contextLoads()  {

        String action = "Authorize";

        SimpleMessageCallback x = new SimpleMessageCallback();
        SpecificationAction y = Specification.InitiatedByChargePoint.Authorize.message(action);


        ///////////////////////////////////////////
        ChargePoint cp0 = new ChargePoint();
        cp0.registerDefaultUsecase(Specification.InitiatedByChargePoint.Authorize);

        ChargePoint cp1 = new ChargePoint();
        cp1.registerUsecase(Specification.InitiatedByChargePoint.Authorize, new SimpleAuthorizeOffer("cp1", SimpleAuthorizeOffer.Test.CALLERROR));

        ChargePoint cp2 = new ChargePoint();
        cp2.registerUsecase(Specification.InitiatedByChargePoint.Authorize, new SimpleAuthorizeOffer("cp1", SimpleAuthorizeOffer.Test.EXCEPTION));


        ///////////////////////////////////////////        
        cp0.offer(y, x); x.sleep(500);
        Assertions.assertNotNull(x.getMsg());
        Assertions.assertNull(x.getErr());
     
        
        cp1.offer(y, x); x.sleep(500);
        Assertions.assertNull(x.getMsg());
        Assertions.assertNotNull(x.getErr());
        Assertions.assertTrue(StringUtils.endsWithIgnoreCase(x.getErr().getMessage(), "'sendAuthorizeRequest' method cannot invoke"));
        Assertions.assertTrue(ClassUtils.isAssignableValue(ErrorCode.class, x.getErr().getCause())); 


        cp2.offer(y, x); x.sleep(500);
        Assertions.assertNull(x.getMsg());
        Assertions.assertNotNull(x.getErr());
        Assertions.assertTrue(StringUtils.endsWithIgnoreCase(x.getErr().getMessage(), "'sendAuthorizeRequest' method cannot invoke"));

    }
}
