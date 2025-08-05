package io.u2ware.ocpp.test.base00;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.u2ware.ocpp.test.append0.SimpleMessageCallback;
import io.u2ware.ocpp.v2_1.messaging.*;


public class OCPP63OperationsTests {
    
    protected final Log logger = LogFactory.getLog(getClass());

    private void testV21(
        ChargingStationCommand feature,
        ChargingStation offer, 
        CSMS answer){ 

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

    private void testV21(
        CSMSCommand feature,
        CSMS offer, 
        ChargingStation answer){ 

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
        ChargingStation cp = new ChargingStation();
        cp.registerDefaultFeatures();

        CSMS cs = new CSMS();        
        cs.registerDefaultFeatures();

        logger.info("-------------------");
        ChargingStationCommand a = ChargingStationCommand.ALL.TransactionEvent.build();
        logger.info(a.getAction());
        logger.info(a.getUsecase());
        logger.info(a.getIdentifier());
        logger.info(cp.resolveFeature(a.getIdentifier()));
        logger.info(cp.resolveFeature(a.getAction()));
        logger.info(cs.resolveFeature(a.getIdentifier()));
        logger.info(cs.resolveFeature(a.getAction()));

        CSMSCommand b =  CSMSCommand.ALL.RequestStartTransaction.build();
        logger.info(b.getAction());
        logger.info(b.getUsecase());
        logger.info(b.getIdentifier());
        logger.info(cp.resolveFeature(b.getIdentifier()));
        logger.info(cp.resolveFeature(b.getAction()));
        logger.info(cs.resolveFeature(b.getIdentifier()));
        logger.info(cs.resolveFeature(b.getAction()));

        logger.info("-------------------");
        testV21(ChargingStationCommand.ALL.DataTransfer.build(), cp, cs);
        testV21(CSMSCommand.ALL.DataTransfer.build(), cs, cp);
        testV21(ChargingStationCommand.ALL.NotifyPeriodicEventStream.build(), cp, cs);


        logger.info("-------------------");
        int initiatedByClient = 0;
        for(ChargingStationCommand.Builder e :  ChargingStationCommand.ALL.values()){
            testV21(e.build(), cp, cs);
            initiatedByClient++;
        }
        logger.info("-------------------");
        int initiatedByServer = 0;
        for(CSMSCommand.Builder e :  CSMSCommand.ALL.values()){
            testV21(e.build(), cs, cp);
            initiatedByServer++;
        }    

        System.err.println("initiatedByClient: "+initiatedByClient);
        System.err.println("initiatedByServer: "+initiatedByServer);
    }
}
