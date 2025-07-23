package io.u2ware.ocpp.test.mock0;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// import io.u2ware.ocpp.core.*;
// // import io.u2ware.ocpp.v1_6.messaging.*;
// // import io.u2ware.ocpp.v1_6.exception.*;
// // import io.u2ware.ocpp.v1_6.model.*;

public class OCPP52OperationTests {
    
    protected final Log logger = LogFactory.getLog(getClass());


    private void testUsecaseV201(
        io.u2ware.ocpp.v2_0_1.messaging.Specification[] usecase, 
        io.u2ware.ocpp.v2_0_1.messaging.SpecificationOperations offer, 
        io.u2ware.ocpp.v2_0_1.messaging.SpecificationOperations answer){

        SimpleMessageCallback x = new SimpleMessageCallback();
        long size = usecase.length;
        long count = 0;

        for(io.u2ware.ocpp.v2_0_1.messaging.Specification u : usecase) {

            io.u2ware.ocpp.v2_0_1.messaging.SpecificationAction ca =  u.message(u.action());
            if(ca == null) continue;

            offer.offer(ca, x); x.sleep(100);  
            Assertions.assertNotNull(x.getMsg());
            Assertions.assertNull(x.getErr());

            answer.answer(x.getMsg(), x); x.sleep(100);  
            Assertions.assertNotNull(x.getMsg());
            Assertions.assertNull(x.getErr());

            offer.answer(x.getMsg(), x); x.sleep(100);  
            Assertions.assertNull(x.getMsg());
            Assertions.assertNull(x.getErr());


            count++;
        }
        logger.info(size+" "+count);
    }


    private void testUsecaseV16(
        io.u2ware.ocpp.v1_6.messaging.Specification[] usecase, 
        io.u2ware.ocpp.v1_6.messaging.SpecificationOperations offer, 
        io.u2ware.ocpp.v1_6.messaging.SpecificationOperations answer){    
    
    
        SimpleMessageCallback x = new SimpleMessageCallback();
        long size = usecase.length;
        long count = 0;

        for(io.u2ware.ocpp.v1_6.messaging.Specification u : usecase) {
            System.out.println(u);

            io.u2ware.ocpp.v1_6.messaging.SpecificationAction ca =  u.message(u.action());
            if(ca == null) continue;
            
            offer.offer(ca, x); x.sleep(100);  
            Assertions.assertNotNull(x.getMsg());
            Assertions.assertNull(x.getErr());

            answer.answer(x.getMsg(), x); x.sleep(100);  
            Assertions.assertNotNull(x.getMsg());
            Assertions.assertNull(x.getErr());

            offer.answer(x.getMsg(), x); x.sleep(100);  
            Assertions.assertNull(x.getMsg());
            Assertions.assertNull(x.getErr());


            count++;
        }
        logger.info(size+" "+count);
    }




    @Test
    public void context1Loads()  {

        io.u2ware.ocpp.v1_6.messaging.ChargePoint cp = new io.u2ware.ocpp.v1_6.messaging.ChargePoint();
        cp.registerDefaultUsecases();
        io.u2ware.ocpp.v1_6.messaging.CentralSystem cs = new io.u2ware.ocpp.v1_6.messaging.CentralSystem();
        cs.registerDefaultUsecases();

        testUsecaseV16(io.u2ware.ocpp.v1_6.messaging.Specification.usecases(cp), cp, cs);
        testUsecaseV16(io.u2ware.ocpp.v1_6.messaging.Specification.usecases(cs), cs, cp);

        // io.u2ware.ocpp.v1_6.messaging.SpecificationAction a = io.u2ware.ocpp.v1_6.messaging.Specification.InitiatedByCentralSystem.Usecase.RemoteStopTransaction.message();
        // logger.info(a);
        // logger.info(a.getAction());
        // logger.info(a.getUsecase());
        // logger.info(a.getIdentifier());

        // logger.info(cp.usecase(a.getIdentifier()));
        // logger.info(cp.usecase(a.getAction()));
        // logger.info(cs.usecase(a.getIdentifier()));
        // logger.info(cs.usecase(a.getAction()));

    }

    @Test
    public void context2Loads()  {

        io.u2ware.ocpp.v2_0_1.messaging.ChargingStation cp = new io.u2ware.ocpp.v2_0_1.messaging.ChargingStation();
        cp.registerDefaultUsecases();

        io.u2ware.ocpp.v2_0_1.messaging.CSMS cs = new io.u2ware.ocpp.v2_0_1.messaging.CSMS();
        cs.registerDefaultUsecases();

        testUsecaseV201(io.u2ware.ocpp.v2_0_1.messaging.Specification.offers(cp), cp, cs);
        testUsecaseV201(io.u2ware.ocpp.v2_0_1.messaging.Specification.offers(cs), cs, cp);


        // io.u2ware.ocpp.v2_0_1.messaging.SpecificationAction a = io.u2ware.ocpp.v2_0_1.messaging.Specification.Security.Usecase.A03.message();
        // logger.info(a);
        // logger.info(a.getAction());
        // logger.info(a.getUsecase());
        // logger.info(a.getIdentifier());

        // logger.info(cp.usecase(a.getIdentifier()));
        // logger.info(cp.usecase(a.getAction()));
        // logger.info(cs.usecase(a.getIdentifier()));
        // logger.info(cs.usecase(a.getAction()));


    }
}
