package io.u2ware.ocpp.test.base00;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.u2ware.ocpp.test.append0.SimpleMessageCallback;
import io.u2ware.ocpp.v1_6.messaging.CentralSystem;
import io.u2ware.ocpp.v1_6.messaging.ChargePoint;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommand;

public class OCPP53FeatureTests {
    

    protected final Log logger = LogFactory.getLog(getClass());


    @Test
    public void contextLoads()  {

        ///////////////////////////////////////////
        ChargePoint cp = new ChargePoint();
        cp.registerFeature(new SimpleAuthorizeOffer("cp1", SimpleAuthorizeOffer.Test.OK));

        CentralSystem cs = new CentralSystem();
        cs.registerFeature(new SimpleAuthorizeAnswer("cp1", SimpleAuthorizeAnswer.Test.OK));


        ///////////////////////////////////////////
        String action = "Authorize";
        SimpleMessageCallback x = new SimpleMessageCallback();
        ChargePointCommand y = ChargePointCommand.Core.Authorize.build(action);

        ///////////////////////////////////////////

        cp.offer(y, x); x.sleep(500);
        Assertions.assertNotNull(x.msg());
        Assertions.assertNull(x.err());

        cs.answer(x.msg(), x); x.sleep(500);
        Assertions.assertNotNull(x.msg());
        Assertions.assertNull(x.err());

        cp.answer(x.msg(), x); x.sleep(500);
        Assertions.assertNull(x.msg());
        Assertions.assertNull(x.err());
    }
}
