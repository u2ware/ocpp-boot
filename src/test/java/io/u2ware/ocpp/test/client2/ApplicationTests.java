package io.u2ware.ocpp.test.client2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.client.MockWebSocketHandlerInvoker;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommand;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommandTemplate;
import io.u2ware.ocpp.v1_6.messaging.ChargePoint;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommand;
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
		// OCPP Test without I/O
		/////////////////////////////////////
		CentralSystemCommandTemplate mockServerTemplate = new CentralSystemCommandTemplate();
		
		MockWebSocketHandlerInvoker.of(ac).connect(clientTemplate, mockServerTemplate);
		Thread.sleep(1000);

		
		/////////////////////////////////////
		//
		/////////////////////////////////////
		logger.info("1 ===================");		
		clientTemplate.send(ChargePointCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);

		logger.info("2 ===================");		
		mockServerTemplate.send(CentralSystemCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);		
	}
}
