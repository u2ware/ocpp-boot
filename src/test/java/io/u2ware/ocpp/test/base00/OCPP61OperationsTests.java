package io.u2ware.ocpp.test.base00;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class OCPP61OperationsTests {
    
    protected final Log logger = LogFactory.getLog(getClass());


    private void testV16(
        io.u2ware.ocpp.v1_6.messaging.ChargePointCommand feature,
        io.u2ware.ocpp.v1_6.messaging.ChargePoint offer, 
        io.u2ware.ocpp.v1_6.messaging.CentralSystem answer){ 

        SimpleMessageCallback x = new SimpleMessageCallback();

        offer.offer(feature, x); x.sleep(100);  
        Assertions.assertNotNull(x.msg());
        Assertions.assertNull(x.err());

        answer.answer(x.msg(), x); x.sleep(100);  
        Assertions.assertNotNull(x.msg());
        Assertions.assertNull(x.err());

        offer.answer(x.msg(), x); x.sleep(100);  
        Assertions.assertNull(x.msg());
        Assertions.assertNull(x.err());
    }

    private void testV16(
        io.u2ware.ocpp.v1_6.messaging.CentralSystemCommand feature,
        io.u2ware.ocpp.v1_6.messaging.CentralSystem offer, 
        io.u2ware.ocpp.v1_6.messaging.ChargePoint answer){ 

        SimpleMessageCallback x = new SimpleMessageCallback();

        offer.offer(feature, x); x.sleep(100);  
        Assertions.assertNotNull(x.msg());
        Assertions.assertNull(x.err());

        answer.answer(x.msg(), x); x.sleep(100);  
        Assertions.assertNotNull(x.msg());
        Assertions.assertNull(x.err());

        offer.answer(x.msg(), x); x.sleep(100);  
        Assertions.assertNull(x.msg());
        Assertions.assertNull(x.err());
    }



    @Test
    public void context1Loads()  throws Exception{

        logger.info("-------------------");
        io.u2ware.ocpp.v1_6.messaging.ChargePoint cp = new io.u2ware.ocpp.v1_6.messaging.ChargePoint();
        cp.registerDefaultFeatures();

        io.u2ware.ocpp.v1_6.messaging.CentralSystem cs = new io.u2ware.ocpp.v1_6.messaging.CentralSystem();        
        cs.registerDefaultFeatures();

        logger.info("-------------------");
        io.u2ware.ocpp.v1_6.messaging.ChargePointCommand a = io.u2ware.ocpp.v1_6.messaging.ChargePointCommand.Core.StartTransaction.build();
        logger.info(a.getAction());
        logger.info(a.getUsecase());
        logger.info(a.getIdentifier());
        logger.info(cp.resolveFeature(a.getIdentifier()));
        logger.info(cp.resolveFeature(a.getAction()));
        logger.info(cs.resolveFeature(a.getIdentifier()));
        logger.info(cs.resolveFeature(a.getAction()));

        io.u2ware.ocpp.v1_6.messaging.CentralSystemCommand b =  io.u2ware.ocpp.v1_6.messaging.CentralSystemCommand.Core.RemoteStopTransaction.build();
        logger.info(b.getAction());
        logger.info(b.getUsecase());
        logger.info(b.getIdentifier());
        logger.info(cp.resolveFeature(b.getIdentifier()));
        logger.info(cp.resolveFeature(b.getAction()));
        logger.info(cs.resolveFeature(b.getIdentifier()));
        logger.info(cs.resolveFeature(b.getAction()));

        logger.info("-------------------");
        testV16(io.u2ware.ocpp.v1_6.messaging.ChargePointCommand.Core.DataTransfer.build(), cp, cs);
        testV16(io.u2ware.ocpp.v1_6.messaging.CentralSystemCommand.Core.DataTransfer.build(), cs, cp);

        logger.info("-------------------");
        for(io.u2ware.ocpp.v1_6.messaging.ChargePointCommand.Builder e :  io.u2ware.ocpp.v1_6.messaging.ChargePointCommand.ALL.values()){
            testV16(e.build(), cp, cs);
        }
        logger.info("-------------------");
        for(io.u2ware.ocpp.v1_6.messaging.CentralSystemCommand.Builder e :  io.u2ware.ocpp.v1_6.messaging.CentralSystemCommand.ALL.values()){
            testV16(e.build(), cs, cp);
        }    
    }
}
