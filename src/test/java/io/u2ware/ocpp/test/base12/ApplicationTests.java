package io.u2ware.ocpp.test.base12;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.client.MockWebSocketHandlerInvoker;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ApplicationTests {

	protected Log logger = LogFactory.getLog(getClass());

    protected @Autowired ApplicationContext ac;

	@Test
	void context16Loads() throws Exception {


		/////////////////////////////////////////////////////
		// Test without I/O by MockWebSocketHandlerInvoker
		/////////////////////////////////////////////////////
		io.u2ware.ocpp.v1_6.messaging.CentralSystemCommandTemplate serverOperations = new io.u2ware.ocpp.v1_6.messaging.CentralSystemCommandTemplate("Mock1");
		io.u2ware.ocpp.v1_6.messaging.ChargePointCommandTemplate clientOperations = new io.u2ware.ocpp.v1_6.messaging.ChargePointCommandTemplate("Mock2");

		MockWebSocketHandlerInvoker.of(ac).connect(serverOperations, clientOperations);
		Thread.sleep(1000);

		////////////////////////////
		/// 
		////////////////////////////
		logger.info("1 ===================");		
		clientOperations.send(io.u2ware.ocpp.v1_6.messaging.ChargePointCommand.ALL.Authorize.build());
		Thread.sleep(500);

		logger.info("2 ===================");	
		serverOperations.send(io.u2ware.ocpp.v1_6.messaging.CentralSystemCommand.ALL.TriggerMessage.build("hello"));
		Thread.sleep(500);


		logger.info("3 ===================");	
		clientOperations.send(io.u2ware.ocpp.v1_6.messaging.ChargePointCommand.ALL.DataTransfer.build("hello"));
		Thread.sleep(500);

		logger.info("4 ===================");	
		serverOperations.send(io.u2ware.ocpp.v1_6.messaging.CentralSystemCommand.ALL.DataTransfer.build("hello"));
		Thread.sleep(500);
	}

	@Test
	void context20Loads() throws Exception {


		/////////////////////////////////////////////////////
		// Test without I/O by MockWebSocketHandlerInvoker
		/////////////////////////////////////////////////////
		io.u2ware.ocpp.v2_0_1.messaging.CSMSCommandTemplate serverOperations = new io.u2ware.ocpp.v2_0_1.messaging.CSMSCommandTemplate("Mock1");
		io.u2ware.ocpp.v2_0_1.messaging.ChargingStationCommandTemplate clientOperations = new  io.u2ware.ocpp.v2_0_1.messaging.ChargingStationCommandTemplate("Mock2");

		MockWebSocketHandlerInvoker.of(ac).connect(serverOperations, clientOperations);
		Thread.sleep(1000);

		////////////////////////////
		/// 
		////////////////////////////
		logger.info("1 ===================");		
		clientOperations.send(io.u2ware.ocpp.v2_0_1.messaging.ChargingStationCommand.ALL.Authorize.build());
		Thread.sleep(500);

		logger.info("2 ===================");	
		serverOperations.send(io.u2ware.ocpp.v2_0_1.messaging.CSMSCommand.ALL.TriggerMessage.build("hello"));
		Thread.sleep(500);


		logger.info("3 ===================");	
		clientOperations.send(io.u2ware.ocpp.v2_0_1.messaging.ChargingStationCommand.ALL.DataTransfer.build("hello"));
		Thread.sleep(500);

		logger.info("4 ===================");	
		serverOperations.send(io.u2ware.ocpp.v2_0_1.messaging.CSMSCommand.ALL.DataTransfer.build("hello"));
		Thread.sleep(500);
	}


	@Test
	void context21Loads() throws Exception {


		/////////////////////////////////////////////////////
		// Test without I/O by MockWebSocketHandlerInvoker
		/////////////////////////////////////////////////////
		io.u2ware.ocpp.v2_1.messaging.CSMSCommandTemplate serverOperations = new io.u2ware.ocpp.v2_1.messaging.CSMSCommandTemplate("Mock1");
		io.u2ware.ocpp.v2_1.messaging.ChargingStationCommandTemplate clientOperations = new  io.u2ware.ocpp.v2_1.messaging.ChargingStationCommandTemplate("Mock2");

		MockWebSocketHandlerInvoker.of(ac).connect(serverOperations, clientOperations);
		Thread.sleep(1000);

		////////////////////////////
		/// 
		////////////////////////////
		logger.info("1 ===================");		
		clientOperations.send(io.u2ware.ocpp.v2_1.messaging.ChargingStationCommand.ALL.Authorize.build());
		Thread.sleep(500);

		logger.info("2 ===================");	
		serverOperations.send(io.u2ware.ocpp.v2_1.messaging.CSMSCommand.ALL.TriggerMessage.build("hello"));
		Thread.sleep(500);


		logger.info("3 ===================");	
		clientOperations.send(io.u2ware.ocpp.v2_1.messaging.ChargingStationCommand.ALL.DataTransfer.build("hello"));
		Thread.sleep(500);

		logger.info("4 ===================");	
		serverOperations.send(io.u2ware.ocpp.v2_1.messaging.CSMSCommand.ALL.DataTransfer.build("hello"));
		Thread.sleep(500);
	}


}