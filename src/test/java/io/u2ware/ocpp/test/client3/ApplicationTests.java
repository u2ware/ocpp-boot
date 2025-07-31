package io.u2ware.ocpp.test.client3;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.test.append2.TestCentralSystemCommandOperations;
import io.u2ware.ocpp.v1_6.messaging.CentralSystem;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommandOperations;
import io.u2ware.ocpp.v1_6.messaging.ChargePoint;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommandTemplate;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {

	protected Log logger = LogFactory.getLog(getClass());

	protected @Autowired ApplicationContext ac;
    protected @LocalServerPort int port;

	protected @Autowired ChargePoint client;
	protected @Autowired ChargePointCommandTemplate clientTemplate;

	@Test
	void contextLoads() throws Exception {

		client.registerDefaultFeatures();

		/////////////////////////////////////
		// Create Mock Server
		/////////////////////////////////////
		CentralSystem server = new CentralSystem();
		CentralSystemCommandOperations serverTemplate = new TestCentralSystemCommandOperations(server, "/topic/mock");

		server.registerDefaultFeatures();


	
		// /////////////////////////////////////
		// // OCPP Client Test with Stomp I/O
		// /////////////////////////////////////
		// WebsocketStompClient.withSockJS()
		// 	.connect(String.format("ws://localhost:%d/console", port), (StompSessionHandler)serverTemplate)
		// 	.whenComplete((c1, u1)->{});
		// Thread.sleep(1000);	

	
		/////////////////////////////////////
		//
		/////////////////////////////////////
		// logger.info("1 ===================");		
		// clientTemplate.send(ChargePointCommand.ALL.DataTransfer.build());
		// Thread.sleep(1000);

		// logger.info("2 ===================");		
		// serverTemplate.send(CentralSystemCommand.ALL.DataTransfer.build());
		// Thread.sleep(1000);		
	}
}