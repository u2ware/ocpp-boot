package io.u2ware.ocpp.test.base20;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.simp.stomp.StompSessionHandler;

import io.u2ware.ocpp.client.WebsocketStompClient;
import io.u2ware.ocpp.test.append2.TestCentralSystemCommandOperations;
import io.u2ware.ocpp.test.append2.TestChargePointCommandOperations;
import io.u2ware.ocpp.v1_6.messaging.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ApplicationTests {

	protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired ApplicationContext ac;
    protected @LocalServerPort int port;

	@Test
	void contextLoads() throws Exception {


		CentralSystem cs = new CentralSystem();
        cs.registerDefaultFeatures();


		ChargePoint cp = new ChargePoint();
        cp.registerDefaultFeatures();

		///////////////////////////////////////
		// StompClient with I/O
		///////////////////////////////////////
		CentralSystemCommandOperations serverOperations = new TestCentralSystemCommandOperations(cs,  "/topic/test");
		ChargePointCommandOperations clientOperations = new TestChargePointCommandOperations(cp,  "/topic/test");

		String stompUri = String.format("ws://localhost:%d/console", port);
		WebsocketStompClient.withSockJS()
			.connect(stompUri, (StompSessionHandler)clientOperations)
			.whenComplete((c1, u1)->{});
		Thread.sleep(1000);	

		WebsocketStompClient.withSockJS()
			.connect(stompUri, (StompSessionHandler)serverOperations)
			.whenComplete((c1, u1)->{});
		Thread.sleep(1000);	

		////////////////////////////
		// 
		////////////////////////////		
		logger.info("1 ===================");		
		clientOperations.send(ChargePointCommand.ALL.Authorize.build("hello"));
		Thread.sleep(2000);

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