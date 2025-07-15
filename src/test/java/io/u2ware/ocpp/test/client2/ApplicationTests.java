package io.u2ware.ocpp.test.client2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.client.WebsocketStandardHandlerInvoker;
import io.u2ware.ocpp.v1_6.messaging.CentralSystem;
import io.u2ware.ocpp.v1_6.messaging.Specification;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingTemplate;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {

	protected Log logger = LogFactory.getLog(getClass());

    protected @LocalServerPort int port;


	protected @Autowired ApplicationContext ac;
	protected @Autowired SpecificationSendingTemplate clientTemplate;

	@Test
	void contextLoads() throws Exception {


		CentralSystem cs = new CentralSystem();
		cs.registerDefaultUsecases();
		SpecificationSendingTemplate serverTemplate = new SpecificationSendingTemplate(cs);

		// ChargePoint cp = new ChargePoint();
		// cp.registerDefaultUsecase();
		// SpecificationSendingTemplate clientTemplate = new SpecificationSendingTemplate(cp);


		/////////////////////////////////////
		// OCPP Test Server without I/O
		/////////////////////////////////////
		logger.info("2===================");	
		WebsocketStandardHandlerInvoker.of(ac).connect(serverTemplate, clientTemplate);
		Thread.sleep(2000);

	
		/////////////////////////////////////
		// OCPP Test Server with I/O
		/////////////////////////////////////
		// logger.info("2===================");	

		// no way !!!!! ㅠㅠ
		
		/////////////////////////////////////
		//
		/////////////////////////////////////
		logger.info("1 ===================");		
		clientTemplate.convertAndSend(Specification.InitiatedByChargePoint.Usecase.DataTransfer.message());
		Thread.sleep(2000);		
		clientTemplate.convertAndSend(Specification.InitiatedByCentralSystem.Usecase.DataTransfer.message());
		Thread.sleep(2000);		
	}
}
