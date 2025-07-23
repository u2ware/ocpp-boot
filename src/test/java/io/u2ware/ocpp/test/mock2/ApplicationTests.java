package io.u2ware.ocpp.test.mock2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import io.u2ware.ocpp.client.WebsocketStompClient;
import io.u2ware.ocpp.test.mock2.messaging.WebsocketStompSendingTemplate;
import io.u2ware.ocpp.v1_6.messaging.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ApplicationTests {

	protected Log logger = LogFactory.getLog(getClass());

    
    private @LocalServerPort int port;
	


	@Test
	void contextLoads() throws Exception {

		CentralSystem cs = new CentralSystem();
		cs.registerDefaultUsecases();
		WebsocketStompSendingTemplate serverOperations = new WebsocketStompSendingTemplate(cs, "/topic/test");

		ChargePoint cp = new ChargePoint();
		cp.registerDefaultUsecases();
		WebsocketStompSendingTemplate clientOperations = new WebsocketStompSendingTemplate(cp, "/topic/test");

		////////////////////////////
		//
		////////////////////////////
		String stompUri = String.format("ws://localhost:%d/console", port);
		logger.info("===================");	
		WebsocketStompClient.withSockJS()
			.connect(stompUri, clientOperations)
			.whenComplete((c1, u1)->{
			});
		Thread.sleep(1000);	


		logger.info("===================");	
		WebsocketStompClient.withSockJS()
			.connect(stompUri, serverOperations)
			.whenComplete((c1, u1)->{
			});
		Thread.sleep(1000);	

		////////////////////////////
		// 
		////////////////////////////		
		logger.info("===================");	
		clientOperations.convertAndSend(Specification.InitiatedByChargePoint.Authorize.message("hello"));
		Thread.sleep(2000);

		logger.info("2 ===================");	
		serverOperations.convertAndSend(Specification.InitiatedByCentralSystem.TriggerMessage.message("hello"));
		Thread.sleep(2000);


		logger.info("3 ===================");	
		clientOperations.convertAndSend(Specification.InitiatedByChargePoint.DataTransfer.message("hello"));
		Thread.sleep(2000);

		logger.info("4 ===================");	
		serverOperations.convertAndSend(Specification.InitiatedByCentralSystem.DataTransfer.message("hello"));
		Thread.sleep(2000);



	}
}