package io.u2ware.ocpp.test.base11;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.test.append1.TestCentralSystemCommandOperations;
import io.u2ware.ocpp.test.append1.TestChargePointCommandOperations;
import io.u2ware.ocpp.v1_6.messaging.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ApplicationTests {

	protected Log logger = LogFactory.getLog(getClass());

    protected @Autowired ApplicationContext ac;

	@Test
	void contextLoads() throws Exception {


		CentralSystem cs = new CentralSystem();
        cs.registerDefaultFeatures();


		ChargePoint cp = new ChargePoint();
        cp.registerDefaultFeatures();


		///////////////////////////////////////
		// Test without I/O by AbstractEventBusTemplate
		///////////////////////////////////////
		TestCentralSystemCommandOperations serverOperations = new TestCentralSystemCommandOperations(cs, ac);
		TestChargePointCommandOperations clientOperations = new TestChargePointCommandOperations(cp, ac);


		////////////////////////////
		/// 
		////////////////////////////
		logger.info("0 ===================");		
		cp.offer(ChargePointCommand.ALL.StartTransaction.build(), clientOperations.getServerCallback());
		Thread.sleep(500);

		
		logger.info("0 ===================");		
		cs.offer(CentralSystemCommand.ALL.RemoteStartTransaction.build(), serverOperations.getClientCallback());
		Thread.sleep(500);

		////////////////////////////
		/// 
		////////////////////////////
		logger.info("1 ===================");		
		clientOperations.send(ChargePointCommand.ALL.Authorize.build());
		Thread.sleep(500);

		logger.info("2 ===================");	
		serverOperations.send(CentralSystemCommand.ALL.TriggerMessage.build("hello"));
		Thread.sleep(2000);


		logger.info("3 ===================");	
		clientOperations.send(ChargePointCommand.ALL.DataTransfer.build("hello"));
		Thread.sleep(2000);

		logger.info("4 ===================");	
		serverOperations.send(CentralSystemCommand.ALL.DataTransfer.build("hello"));
		Thread.sleep(2000);

	}
}