package io.u2ware.ocpp.test.server2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.client.MockWebSocketHandlerInvoker;
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
		// OCPP Test without I/O
		/////////////////////////////////////
		ChargePointCommandTemplate mockClientTemplate = new ChargePointCommandTemplate();

		MockWebSocketHandlerInvoker.of(ac).connect(serverTemplate, mockClientTemplate);
		Thread.sleep(1000);	
		

		/////////////////////////////////////
		//
		/////////////////////////////////////
		logger.info("1 ===================");		
		serverTemplate.send(CentralSystemCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);

		logger.info("2 ===================");		
		mockClientTemplate.send(ChargePointCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);
	
	}
}