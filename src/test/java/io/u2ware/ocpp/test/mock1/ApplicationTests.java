package io.u2ware.ocpp.test.mock1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.v1_6.messaging.*;
import io.u2ware.ocpp.test.mock1.messaging.EventBusSendingTemplate;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ApplicationTests {

	protected Log logger = LogFactory.getLog(getClass());

    
    private @LocalServerPort int port;
	

    private @Autowired ApplicationContext ac;


	@Test
	void contextLoads() throws Exception {


		CentralSystem cs = new CentralSystem();
		cs.registerDefaultUsecases();
		SpecificationSendingOperations serverOperation = new EventBusSendingTemplate(cs, ac);

		ChargePoint cp = new ChargePoint();
		cp.registerDefaultUsecases();
		SpecificationSendingOperations clientOperation = new EventBusSendingTemplate(cp, ac);

		
		////////////////////////////
		/// 
		////////////////////////////
		logger.info("1 ===================");		
		clientOperation.convertAndSend(Specification.InitiatedByChargePoint.Authorize.message("hello"));
		Thread.sleep(2000);

		logger.info("2 ===================");	
		serverOperation.convertAndSend(Specification.InitiatedByCentralSystem.TriggerMessage.message("hello"));
		Thread.sleep(2000);


		logger.info("3 ===================");	
		clientOperation.convertAndSend(Specification.InitiatedByChargePoint.DataTransfer.message("hello"));
		Thread.sleep(2000);

		logger.info("4 ===================");	
		serverOperation.convertAndSend(Specification.InitiatedByCentralSystem.DataTransfer.message("hello"));
		Thread.sleep(2000);

	}
}