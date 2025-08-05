package io.u2ware.ocpp.test.base00;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;

import io.u2ware.ocpp.v1_6.messaging.CentralSystem;
import io.u2ware.ocpp.v1_6.messaging.ChargePoint;
import io.u2ware.ocpp.v2_0_1.messaging.ChargingStation;


public class OCPP1VersionTests {
    

    protected final Log logger = LogFactory.getLog(getClass());


    @Test
    public void contextLoads() throws Exception {


		io.u2ware.ocpp.v1_6.messaging.ChargePoint o1 = new io.u2ware.ocpp.v1_6.messaging.ChargePoint().registerDefaultFeatures();
		io.u2ware.ocpp.v1_6.messaging.CentralSystem o2 = new io.u2ware.ocpp.v1_6.messaging.CentralSystem().registerDefaultFeatures();

		io.u2ware.ocpp.v2_0_1.messaging.ChargingStation o3 = new io.u2ware.ocpp.v2_0_1.messaging.ChargingStation().registerDefaultFeatures();
		io.u2ware.ocpp.v2_0_1.messaging.CSMS o4 = new io.u2ware.ocpp.v2_0_1.messaging.CSMS().registerDefaultFeatures();

		io.u2ware.ocpp.v2_1.messaging.ChargingStation o5 = new io.u2ware.ocpp.v2_1.messaging.ChargingStation().registerDefaultFeatures();
		io.u2ware.ocpp.v2_1.messaging.CSMS o6 = new io.u2ware.ocpp.v2_1.messaging.CSMS().registerDefaultFeatures();


        // o1.offer(null, null);

    }
}
