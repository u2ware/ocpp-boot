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
import io.u2ware.ocpp.v1_6.messaging.Specification;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingTemplate;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ApplicationTests {

	protected Log logger = LogFactory.getLog(getClass());
    
    protected @LocalServerPort int port;


	protected @Autowired ApplicationContext ac;
	protected @Autowired SpecificationSendingTemplate serverTemplate;
	

	@Test
	void contextLoads() throws Exception {

		// CentralSystem cs = new CentralSystem();
		// cs.registerDefaultUsecase();
		// SpecificationSendingTemplate serverTemplate = new SpecificationSendingTemplate(cs);

		ChargePoint cp = new ChargePoint();
		cp.registerDefaultUsecases();
		SpecificationSendingTemplate clientTemplate = new SpecificationSendingTemplate(cp);


		/////////////////////////////////////
		// OCPP Test Server without I/O
		/////////////////////////////////////
		// logger.info("2===================");	
		// WebsocketStandardHandlerInvoker.of(ac).connect(serverTemplate, clientTemplate);
		// Thread.sleep(2000);

		
		/////////////////////////////////////
		// OCPP Test Client with I/O
		/////////////////////////////////////
		logger.info("2===================");	
		String ocppUri = String.format("ws://localhost:%d/ocpp", port);
		WebsocketStandardClient.withSockJS()
			.connect(ocppUri, clientTemplate)
			.whenComplete((c1, u1)->{
				// c1.sleep(1000).disconnect();
			});
		Thread.sleep(2000);	

		/////////////////////////////////////
		//
		/////////////////////////////////////
		logger.info("1 ===================");		
		serverTemplate.convertAndSend(Specification.InitiatedByCentralSystem.DataTransfer.message());
		Thread.sleep(2000);
		serverTemplate.convertAndSend(Specification.InitiatedByChargePoint.DataTransfer.message());
		Thread.sleep(2000);
	}
}