package io.u2ware.ocpp.test.base00;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.u2ware.ocpp.test.append0.SimpleMessageCallback;
import io.u2ware.ocpp.v1_6.messaging.*;


public class OCPP61OperationsTests {
    
    protected final Log logger = LogFactory.getLog(getClass());


    private void testV16(
        ChargePointCommand feature,
        ChargePoint offer, 
        CentralSystem answer){ 

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
        CentralSystemCommand feature,
        CentralSystem offer, 
        ChargePoint answer){ 

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
        ChargePoint cp = new ChargePoint();
        cp.registerDefaultFeatures();

        CentralSystem cs = new CentralSystem();        
        cs.registerDefaultFeatures();

        logger.info("-------------------");
        ChargePointCommand a = ChargePointCommand.ALL.StartTransaction.build();
        logger.info(a.getAction());
        logger.info(a.getUsecase());
        logger.info(a.getIdentifier());
        logger.info(cp.resolveFeature(a.getIdentifier()));
        logger.info(cp.resolveFeature(a.getAction()));
        logger.info(cs.resolveFeature(a.getIdentifier()));
        logger.info(cs.resolveFeature(a.getAction()));

        CentralSystemCommand b =  CentralSystemCommand.ALL.RemoteStopTransaction.build();
        logger.info(b.getAction());
        logger.info(b.getUsecase());
        logger.info(b.getIdentifier());
        logger.info(cp.resolveFeature(b.getIdentifier()));
        logger.info(cp.resolveFeature(b.getAction()));
        logger.info(cs.resolveFeature(b.getIdentifier()));
        logger.info(cs.resolveFeature(b.getAction()));

        logger.info("-------------------");
        testV16(ChargePointCommand.ALL.DataTransfer.build(), cp, cs);
        testV16(CentralSystemCommand.ALL.DataTransfer.build(), cs, cp);

        logger.info("-------------------");
        int initiatedByClient = 0;
        for(ChargePointCommand.Builder e :  ChargePointCommand.ALL.values()){
            testV16(e.build(), cp, cs);
            initiatedByClient++;
        }
        logger.info("-------------------");
        int initiatedByServer = 0;
        for(CentralSystemCommand.Builder e :  CentralSystemCommand.ALL.values()){
            testV16(e.build(), cs, cp);
            initiatedByServer++;
        }
        System.err.println("initiatedByClient: "+initiatedByClient);
        System.err.println("initiatedByServer: "+initiatedByServer); // add DataTransfer
        
        
    }
}
