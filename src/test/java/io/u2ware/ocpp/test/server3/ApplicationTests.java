package io.u2ware.ocpp.test.server3;

import java.util.concurrent.atomic.AtomicReference;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.simp.SimpMessageSendingOperations;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.u2ware.ocpp.client.MockWebSocketHandlerInvoker;
import io.u2ware.ocpp.client.WebsocketStandardClient;
import io.u2ware.ocpp.client.WebsocketStompClient;
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

		server.registerDefaultFeatures();

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
		ChargePointCommandTemplate mockClientTemplate1 = new ChargePointCommandTemplate();
		MockWebSocketHandlerInvoker.of(ac).connect(serverTemplate, mockClientTemplate1);
		Thread.sleep(1000);	
		
		logger.info("1 ===================");		
		serverTemplate.send(CentralSystemCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);

		logger.info("2 ===================");		
		String command1 = mapper.writeValueAsString(CentralSystemCommand.ALL.DataTransfer.build());
		ux.get().send("/app/channel."+serverTemplate.getFirstSessionId(), command1);
		Thread.sleep(1000);


		logger.info("3 ===================");		
		mockClientTemplate1.send(ChargePointCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);


		/////////////////////////////////////
		//  (2) Test with Websocket I/O 
		/////////////////////////////////////
		ChargePointCommandTemplate mockClientTemplate2 = new ChargePointCommandTemplate();
		WebsocketStandardClient.withSockJS()
			.connect(String.format("ws://localhost:%d/ocpp", port), mockClientTemplate2)
			.whenComplete((c1, u1)->{
			});
		;
		Thread.sleep(1000);	

		logger.info("1 ===================");		
		serverTemplate.send(CentralSystemCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);

		logger.info("2 ===================");		
		String command2 = mapper.writeValueAsString(CentralSystemCommand.ALL.DataTransfer.build());
		ux.get().send("/app/channel."+serverTemplate.getFirstSessionId(), command2);
		Thread.sleep(1000);		

		logger.info("3 ===================");		
		mockClientTemplate2.send(ChargePointCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);


		/////////////////////////////////////
		//  (3) Test with Stomp I/O
		/////////////////////////////////////
		ChargePointCommandTemplate mockClientTemplate3 = new ChargePointCommandTemplate(simpOperations);
		WebsocketStompClient.withSockJS()
			.connect(String.format("ws://localhost:%d/ocpp-boot", port), mockClientTemplate3)
			.whenComplete((c1, u1)->{
				c1.sleep(100).subscribe("/topic/channel")
					.whenComplete((c2,u2)->{
					});
			});
		Thread.sleep(1000);	

		logger.info("1 ===================");		
		serverTemplate.send("/topic/channel", CentralSystemCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);

		logger.info("3 ===================");		
		mockClientTemplate3.send("/app/channel", ChargePointCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);

	}
}