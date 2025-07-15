package io.u2ware.ocpp.test.handler1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import io.u2ware.ocpp.client.WebsocketStandardClient;

import io.u2ware.ocpp.v1_6.messaging.ChargePoint;
import io.u2ware.ocpp.v1_6.messaging.Specification;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingTemplate;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ApplicationTests {

	protected Log logger = LogFactory.getLog(getClass());

    
    private @LocalServerPort int port;


	// private @Autowired OcppSendingOperations serverOperations;
	// private @Autowired CustomHandler customHandler;

	@Test
	void contextLoads() throws Exception {

		// CentralSystem cs = new CentralSystem();
		// cs.registerDefaultUsecase();
		// SpecificationSendingTemplate serverOperations = new SpecificationSendingTemplate(cs);

		ChargePoint cp = new ChargePoint();
		cp.registerDefaultUsecases();
		SpecificationSendingTemplate clientOperations1 = new SpecificationSendingTemplate(cp);
		SpecificationSendingTemplate clientOperations2 = new SpecificationSendingTemplate(cp);

		String ocppUri = String.format("ws://localhost:%d/ocpp", port);

		/////////////////////////////////////
		// 
		/////////////////////////////////////
		logger.info("2===================");	
		WebsocketStandardClient.withSockJS()
			.connect(ocppUri, clientOperations1)
			.whenComplete((c1, u1)->{
				// c1.sleep(1000).disconnect();
			});
		Thread.sleep(2000);	


		/////////////////////////////////////
		// 
		/////////////////////////////////////
		logger.info("2===================");	
		WebsocketStandardClient.withSockJS()
			.connect(ocppUri, clientOperations2)
			.whenComplete((c1, u1)->{
				// c1.sleep(1000).disconnect();
			});
		Thread.sleep(2000);	


		
		////////////////////////////
		// 
		////////////////////////////	
		logger.info("===================");	
		clientOperations1.convertAndSend(Specification.InitiatedByChargePoint.Usecase.StartTransaction.message("hello"));
		Thread.sleep(3000);

		
	}
}