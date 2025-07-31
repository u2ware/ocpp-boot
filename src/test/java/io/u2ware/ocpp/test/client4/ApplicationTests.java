package io.u2ware.ocpp.test.client4;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.config.WebSocketHandlerInvoker;
import io.u2ware.ocpp.v1_6.messaging.CentralSystem;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommandTemplate;
import io.u2ware.ocpp.v1_6.messaging.ChargePoint;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommand;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommandTemplate;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ApplicationTests {

	protected Log logger = LogFactory.getLog(getClass());

	protected @Autowired ApplicationContext ac;
    
	protected @Autowired ChargePoint client;
	protected @Autowired ChargePointCommandTemplate clientTemplate;

	@Test
	void contextLoads() throws Exception {

		/////////////////////////////////////
		// Create Mock Server
		/////////////////////////////////////
		CentralSystem server = new CentralSystem();
		CentralSystemCommandTemplate serverTemplate = new CentralSystemCommandTemplate(server);
        server.registerDefaultFeatures();

		/////////////////////////////////////
		// OCPP Client Test  without I/O
		/////////////////////////////////////
		WebSocketHandlerInvoker.of(ac).connect(serverTemplate, clientTemplate);
		Thread.sleep(1000);	

		/////////////////////////////////////
		// 
		/////////////////////////////////////
		Assertions.assertNull(client.resolveFeature("Authorize"));
		Assertions.assertNotNull(client.resolveFeature("DataTransfer"));
		Assertions.assertNotNull(client.resolveFeature("MyCustomHandler"));


		logger.info("===================");	
		clientTemplate.send(ChargePointCommand.ALL.Heartbeat.buildWith("MyCustomHandler"));
		Thread.sleep(1000);		
	}
}