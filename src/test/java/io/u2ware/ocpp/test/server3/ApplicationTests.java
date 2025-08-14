package io.u2ware.ocpp.test.server3;

import java.util.concurrent.CompletableFuture;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaders;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.u2ware.ocpp.Call;
import io.u2ware.ocpp.CallError;
import io.u2ware.ocpp.CallException;
import io.u2ware.ocpp.CallResult;
import io.u2ware.ocpp.OCPPCommand;
import io.u2ware.ocpp.OCPPConversion;
import io.u2ware.ocpp.client.MockWebSocketHandlerInvoker;
import io.u2ware.ocpp.client.WebsocketStandardClient;
import io.u2ware.ocpp.client.WebsocketStompClient;
import io.u2ware.ocpp.client.WebsocketStompGenericHandler;
import io.u2ware.ocpp.client.WebsocketStompLoggingHandler;
import io.u2ware.ocpp.v1_6.messaging.CentralSystem;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommand;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommandTemplate;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommand;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommandTemplate;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ApplicationTests {

	protected Log logger = LogFactory.getLog(getClass());
    
    protected @LocalServerPort int port;
	protected @Autowired ApplicationContext ac;
    protected @Autowired ObjectMapper mapper;
    protected @Autowired SimpMessageSendingOperations simpOperations;

	protected @Autowired CentralSystem server;
	protected @Autowired CentralSystemCommandTemplate serverTemplate;
	

	@Test
	void contextLoads() throws Exception {

		server.registerDefaultHandlers();

		/////////////////////////////////////
		// serverTemplate
		/////////////////////////////////////
		CompletableFuture<WebsocketStompClient> ux = WebsocketStompClient.withSockJS()
			.connect(String.format("ws://localhost:%d/ocpp-boot", port), new WebsocketStompLoggingHandler("serverTemplate"))
			.whenComplete((c1, u1)->{
				c1.sleep(100).subscribe("/topic/console");
			});
		Thread.sleep(1000);	




		/////////////////////////////////////
		//  (1) Test without I/O 
		/////////////////////////////////////
		ChargePointCommandTemplate mockClientTemplate1 = new ChargePointCommandTemplate("mockClientTemplate1");
		MockWebSocketHandlerInvoker.of(ac).connect(serverTemplate, mockClientTemplate1);
		Thread.sleep(1000);	
		
		logger.info("1 ===================");		
		serverTemplate.send(CentralSystemCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);

		logger.info("2 ===================");		
		String send = mapper.writeValueAsString(CentralSystemCommand.ALL.DataTransfer.build());
		ux.get().send("/app/channel."+serverTemplate.getFirstStandardSessionId(), send);
		Thread.sleep(1000);


		logger.info("3 ===================");		
		mockClientTemplate1.send(ChargePointCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);



		/////////////////////////////////////
		//  (2) Test with Stomp I/O
		/////////////////////////////////////
		ChargePointCommandTemplate mockClientTemplate2 = new ChargePointCommandTemplate("/app/channel.aaa", simpOperations);
		WebsocketStompClient.withSockJS()
			.connect(String.format("ws://localhost:%d/ocpp-boot", port), mockClientTemplate2)
			.whenComplete((c1, u1)->{
				c1.sleep(100).subscribe("/topic/channel.aaa");
			});
		Thread.sleep(1000);	

		logger.info("1 ===================");		
		serverTemplate.send("/topic/channel.aaa", CentralSystemCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);

		logger.info("2 ===================");		
		mockClientTemplate2.send("/app/channel.aaa", ChargePointCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);


		///////////////////////////////////
		//  (3) Test with Stomp Broker I/O
		///////////////////////////////////
		ChargePointCommandTemplate mockClientTemplate3 = new ChargePointCommandTemplate("/topic/channel.outbound", simpOperations);
		WebsocketStompClient.withSockJS()
			.connect(String.format("ws://localhost:%d/ocpp-boot", port), mockClientTemplate3)
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
		serverTemplate.send("/topic/channel.broker", CentralSystemCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);


		logger.info("2 ===================");		
		mockClientTemplate3.send("/topic/channel.outbound", ChargePointCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);



		/////////////////////////////////////
		//  (4) Test with Websocket I/O 
		/////////////////////////////////////
		ChargePointCommandTemplate mockClientTemplate4 = new ChargePointCommandTemplate("mockClientTemplate4");
		WebsocketStandardClient.withSockJS()
			.connect(String.format("ws://localhost:%d/ocpp", port), mockClientTemplate4)
			.whenComplete((c1, u1)->{
			});
		;
		Thread.sleep(1000);	

		logger.info("1 ===================");		
		serverTemplate.send(CentralSystemCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);

		logger.info("2 ===================");		
		mockClientTemplate4.send(ChargePointCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);


		/////////////////////////////////////
		//  (5) Test with Websocket I/O 
		/////////////////////////////////////
		ChargePointCommandTemplate mockClientTemplate = new ChargePointCommandTemplate("/app/channel.hello", simpOperations);
		CompletableFuture<WebsocketStompClient> mockClient = WebsocketStompClient.withSockJS()
			.connect(String.format("ws://localhost:%d/ocpp-boot", port), mockClientTemplate)
			.whenComplete((c1, u1)->{
				c1.sleep(100).subscribe("/topic/channel.hello");
			});
		Thread.sleep(1000);	

		////////////////////////////////////////////
		OCPPCommand ca = ChargePointCommand.ALL.DataTransfer.build();

		Call<String> cc = new Call<String>();
		cc.setAction("DataTransfer");
		cc.setId("hello");

		CallResult<String> cr = new CallResult<String>();
		cr.setId("hello");

		CallError<CallException> ce = new CallError<>();
		ce.setId("hello");
		ce.setPayload(new CallException("a", "b", "c") {});


		final String command = new OCPPConversion().comfortableWriteValue(ca);
		final String call = new OCPPConversion().convertMessage(cc);
		final String callResult = new OCPPConversion().convertMessage(cr);			
		final String callError = new OCPPConversion().convertMessage(ce);			

		mockClient.get().send("/app/channel.world", command);
		Thread.sleep(1000);	

		mockClient.get().send("/app/channel.world", call);
		Thread.sleep(1000);

		mockClient.get().send("/app/channel.world", callResult);
		Thread.sleep(1000);		

		mockClient.get().send("/app/channel.world", callError);
		Thread.sleep(1000);		

		mockClient.get().send("/app/channel.world", "hello world");
		Thread.sleep(1000);		

	}
}