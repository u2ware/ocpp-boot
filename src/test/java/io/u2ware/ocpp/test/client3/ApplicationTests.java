package io.u2ware.ocpp.test.client3;

import java.util.concurrent.atomic.AtomicReference;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.simp.SimpMessageSendingOperations;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.u2ware.ocpp.client.MockWebSocketHandlerInvoker;
import io.u2ware.ocpp.client.WebsocketStompClient;
import io.u2ware.ocpp.client.WebsocketStompLoggingHandler;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommand;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommandTemplate;
import io.u2ware.ocpp.v1_6.messaging.ChargePoint;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommand;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommandTemplate;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {

	protected Log logger = LogFactory.getLog(getClass());

    protected @LocalServerPort int port;
	protected @Autowired ApplicationContext ac;
    protected @Autowired ObjectMapper mapper;
    protected @Autowired SimpMessageSendingOperations simpOperations;

	protected @Autowired ChargePoint client;
	protected @Autowired ChargePointCommandTemplate clientTemplate;

	@Test
	void contextLoads() throws Exception {

		client.registerDefaultFeatures();

		/////////////////////////////////////
		// UX
		/////////////////////////////////////
		AtomicReference<WebsocketStompClient> ux = new AtomicReference<>();
		WebsocketStompClient.withSockJS()
			.connect(String.format("ws://localhost:%d/ocpp-boot", port), new WebsocketStompLoggingHandler("UX"))
			.whenComplete((c1, u1)->{
				c1.sleep(100).subscribe("/topic/console")
					.whenComplete((c2,u2)->{
						ux.set(c2);
					});
			});
		Thread.sleep(1000);	
		
		/////////////////////////////////////
		//  (1) Test without I/O 
		/////////////////////////////////////	
		CentralSystemCommandTemplate mockServerTemplate1 = new CentralSystemCommandTemplate(simpOperations);
		MockWebSocketHandlerInvoker.of(ac).connect(clientTemplate, mockServerTemplate1);
		Thread.sleep(1000);	
		
		logger.info("1 ===================");		
		clientTemplate.send(ChargePointCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);

		logger.info("2 ===================");		
		String command = mapper.writeValueAsString(CentralSystemCommand.ALL.DataTransfer.build());
		ux.get().send("/app/channel."+clientTemplate.getFirstSessionId(), command);
		Thread.sleep(1000);


		logger.info("3 ===================");		
		mockServerTemplate1.send(CentralSystemCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);


		/////////////////////////////////////
		//  (2) Test with Websocket I/O 
		/////////////////////////////////////
		//No exists !!!!!!!


		/////////////////////////////////////
		//  (3) Test with Stomp I/O
		/////////////////////////////////////
		CentralSystemCommandTemplate mockServerTemplate3 = new CentralSystemCommandTemplate(simpOperations);
		WebsocketStompClient.withSockJS()
			.connect(String.format("ws://localhost:%d/ocpp-boot", port), mockServerTemplate3)
			.whenComplete((c1, u1)->{
				c1.sleep(100).subscribe("/topic/channel")
					.whenComplete((c2,u2)->{
					});
			});
		Thread.sleep(1000);	

		logger.info("1 ===================");		
		clientTemplate.send("/topic/channel", ChargePointCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);

		logger.info("3 ===================");		
		mockServerTemplate3.send("/app/channel", CentralSystemCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);

	}
}