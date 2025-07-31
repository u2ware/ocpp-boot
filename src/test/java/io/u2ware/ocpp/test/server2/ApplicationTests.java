package io.u2ware.ocpp.test.server2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.client.WebsocketStandardClient;
import io.u2ware.ocpp.v1_6.messaging.ChargePoint;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommand;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommandTemplate;
import io.u2ware.ocpp.v1_6.messaging.CentralSystem;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommand;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommandTemplate;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ApplicationTests {

	protected Log logger = LogFactory.getLog(getClass());
    
	protected @Autowired ApplicationContext ac;
    protected @LocalServerPort int port;

	protected @Autowired CentralSystem server;
	protected @Autowired CentralSystemCommandTemplate serverTemplate;
	

	@Test
	void contextLoads() throws Exception {

		server.registerDefaultFeatures();

		/////////////////////////////////////
		// Create Mock Client
		/////////////////////////////////////
		ChargePoint client = new ChargePoint();
		ChargePointCommandTemplate clientTemplate = new ChargePointCommandTemplate(client);
		
		client.registerDefaultFeatures();


		/////////////////////////////////////
		// OCPP Server Test  without I/O
		/////////////////////////////////////
		// WebSocketHandlerInvoker.of(ac).connect(serverTemplate, clientTemplate);
		// Thread.sleep(1000);	

		
		/////////////////////////////////////
		// OCPP Server Test with I/O
		/////////////////////////////////////
		WebsocketStandardClient.withSockJS()
			.connect(String.format("ws://localhost:%d/ocpp", port), clientTemplate)
			.whenComplete((c1, u1)->{});
		Thread.sleep(1000);	

		/////////////////////////////////////
		//
		/////////////////////////////////////
		logger.info("1 ===================");		
		serverTemplate.send(CentralSystemCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);

		logger.info("2 ===================");		
		clientTemplate.send(ChargePointCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);
	
	}
}