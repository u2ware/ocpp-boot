package io.u2ware.ocpp.test.base12;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.config.WebSocketHandlerInvoker;
import io.u2ware.ocpp.v1_6.messaging.CentralSystem;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommand;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommandTemplate;
import io.u2ware.ocpp.v1_6.messaging.ChargePoint;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommand;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommandTemplate;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ApplicationTests {

	protected Log logger = LogFactory.getLog(getClass());

    protected @Autowired ApplicationContext ac;

	@Test
	void contextLoads() throws Exception {


		CentralSystem cs = new CentralSystem();
        cs.registerDefaultFeatures();


		ChargePoint cp = new ChargePoint();
        cp.registerDefaultFeatures();

		///////////////////////////////////////
		// WebSocketHandlerInvoker without I/O
		///////////////////////////////////////
		CentralSystemCommandTemplate serverOperations = new CentralSystemCommandTemplate(cs);
		ChargePointCommandTemplate clientOperations = new ChargePointCommandTemplate(cp);

		WebSocketHandlerInvoker.of(ac).connect(serverOperations, clientOperations);
		Thread.sleep(1000);

		////////////////////////////
		/// 
		////////////////////////////
		logger.info("1 ===================");		
		clientOperations.send(ChargePointCommand.ALL.Authorize.build());
		Thread.sleep(500);

		logger.info("2 ===================");	
		serverOperations.send(CentralSystemCommand.ALL.TriggerMessage.build("hello"));
		Thread.sleep(500);


		logger.info("3 ===================");	
		clientOperations.send(ChargePointCommand.ALL.DataTransfer.build("hello"));
		Thread.sleep(500);

		logger.info("4 ===================");	
		serverOperations.send(CentralSystemCommand.ALL.DataTransfer.build("hello"));
		Thread.sleep(500);



	}
}