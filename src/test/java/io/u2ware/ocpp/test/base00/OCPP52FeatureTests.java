package io.u2ware.ocpp.test.base00;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.test.append0.SimpleMessageCallback;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.ChargePoint;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommand;

public class OCPP52FeatureTests {
    
    protected final Log logger = LogFactory.getLog(getClass());


    @Test
    public void contextLoads()  {

        ///////////////////////////////////////////
        ChargePoint cp0 = new ChargePoint();
        cp0.registerFeature(io.u2ware.ocpp.v1_6.handlers.Authorize.ChargePointHandler.DEFAULT);

        ChargePoint cp1 = new ChargePoint();
        cp1.registerFeature(new SimpleAuthorizeOffer("cp1", SimpleAuthorizeOffer.Test.CALLERROR));

        ChargePoint cp2 = new ChargePoint();
        cp2.registerFeature(new SimpleAuthorizeOffer("cp1", SimpleAuthorizeOffer.Test.EXCEPTION));


        ///////////////////////////////////////////        
        String action = "Authorize";
        SimpleMessageCallback x = new SimpleMessageCallback();
        ChargePointCommand y = ChargePointCommand.Core.Authorize.build(action);


        ///////////////////////////////////////////        
        cp0.offer(y, x); x.sleep(500);
        Assertions.assertNotNull(x.msg());
        Assertions.assertNull(x.err());
     
        
        cp1.offer(y, x); x.sleep(500);
        Assertions.assertNull(x.msg());
        Assertions.assertNotNull(x.err());
        Assertions.assertTrue(StringUtils.endsWithIgnoreCase(x.err().getMessage(), "'sendAuthorizeRequest' method cannot invoke"));
        Assertions.assertTrue(ClassUtils.isAssignableValue(ErrorCode.class, x.err().getCause())); 


        cp2.offer(y, x); x.sleep(500);
        Assertions.assertNull(x.msg());
        Assertions.assertNotNull(x.err());
        Assertions.assertTrue(StringUtils.endsWithIgnoreCase(x.err().getMessage(), "'sendAuthorizeRequest' method cannot invoke"));

    }
}
