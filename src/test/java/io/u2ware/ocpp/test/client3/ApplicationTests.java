package io.u2ware.ocpp.test.client3;

import java.util.concurrent.CompletableFuture;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaders;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.u2ware.ocpp.client.MockWebSocketHandlerInvoker;
import io.u2ware.ocpp.client.WebsocketStompClient;
import io.u2ware.ocpp.client.WebsocketStompGenericHandler;
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

		client.registerDefaultHandlers();

		/////////////////////////////////////
		// clientTemplate
		/////////////////////////////////////
		CompletableFuture<WebsocketStompClient> ux = WebsocketStompClient.withSockJS()
			.connect(String.format("ws://localhost:%d/ocpp-boot", port), new WebsocketStompLoggingHandler("clientTemplate"))
			.whenComplete((c1, u1)->{
				c1.sleep(100).subscribe("/topic/console");
			});
		Thread.sleep(1000);	
		
		/////////////////////////////////////
		//  (1) Test without I/O 
		/////////////////////////////////////	
		CentralSystemCommandTemplate mockServerTemplate1 = new CentralSystemCommandTemplate("mockServerTemplate1", simpOperations);
		MockWebSocketHandlerInvoker.of(ac).connect(clientTemplate, mockServerTemplate1);
		Thread.sleep(1000);	
		
		logger.info("1 ===================");		
		clientTemplate.send(ChargePointCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);

		logger.info("2 ===================");		
		String send = mapper.writeValueAsString(CentralSystemCommand.ALL.DataTransfer.build());
		ux.get().send("/app/channel."+clientTemplate.getFirstStandardSessionId(), send);
		Thread.sleep(1000);


		logger.info("3 ===================");		
		mockServerTemplate1.send(CentralSystemCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);


		/////////////////////////////////////
		//  (2) Test with Stomp I/O
		/////////////////////////////////////
		CentralSystemCommandTemplate mockServerTemplate2 = new CentralSystemCommandTemplate("/app/channel.aaa", simpOperations);
		WebsocketStompClient.withSockJS()
			.connect(String.format("ws://localhost:%d/ocpp-boot", port), mockServerTemplate2)
			.whenComplete((c1, u1)->{
				c1.sleep(100).subscribe("/topic/channel.aaa")
					.whenComplete((c2,u2)->{
					});
			});
		Thread.sleep(1000);	

		logger.info("1 ===================");		
		clientTemplate.send("/topic/channel.aaa", ChargePointCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);

		logger.info("2 ===================");		
		mockServerTemplate2.send("/app/channel.aaa", CentralSystemCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);



		///////////////////////////////////
		//  (3) Test with Stomp Broker I/O
		///////////////////////////////////
		CentralSystemCommandTemplate mockServerTemplate3 = new CentralSystemCommandTemplate("/topic/channel.outbound", simpOperations);
		WebsocketStompClient.withSockJS()
			.connect(String.format("ws://localhost:%d/ocpp-boot", port), mockServerTemplate3)
			.whenComplete((c1, u1)->{
				c1.sleep(100).subscribe("/topic/channel.inbound");
			});
		Thread.sleep(1000);			
		
		
		WebsocketStompClient.withSockJS()
			.connect(String.format("ws://localhost:%d/ocpp-boot", port), new WebsocketStompLoggingHandler("Broker"))
			.whenComplete((c1, u1)->{
				c1.sleep(100).subscribe("/topic/channel.broker", new WebsocketStompGenericHandler<String>() {
					public void handle(StompHeaders header, String payload) {
						System.err.println("/topic/channel.broker -> /topic/channel.inbound");
						c1.send("/topic/channel.inbound", payload);
					}
				});

				c1.sleep(100).subscribe("/topic/channel.outbound", new WebsocketStompGenericHandler<String>() {
					public void handle(StompHeaders header, String payload) {
						System.err.println("/topic/channel.outbound ->  -> /app/channel.broker "+payload);
						c1.send("/app/channel.broker", payload);
					}
				});
			});
		Thread.sleep(2000);	


		logger.info("1 ===================");		
		clientTemplate.send("/topic/channel.broker", ChargePointCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);


		logger.info("2 ===================");		
		mockServerTemplate3.send("/topic/channel.outbound", CentralSystemCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);		
		





		/////////////////////////////////////
		//  (4) Test with Websocket I/O 
		/////////////////////////////////////
		// //No way !!!!!!!

	}
}