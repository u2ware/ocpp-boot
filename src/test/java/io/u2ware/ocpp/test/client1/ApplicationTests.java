package io.u2ware.ocpp.test.client1;

import java.net.URI;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.util.UriComponentsBuilder;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ApplicationTests {

	protected Log logger = LogFactory.getLog(getClass());

    
    private @LocalServerPort int port;
	private @Autowired ApplicationContext ac;
	private @Autowired SimpMessageSendingOperations simpOperations;

	
	private @Autowired(required = false) io.u2ware.ocpp.v1_6.messaging.ChargePoint chargePoint16;
	private @Autowired(required = false) io.u2ware.ocpp.v1_6.messaging.CentralSystem centralSystem16;
	private @Autowired(required = false) io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations ocppOperations16;	

	private @Autowired(required = false) io.u2ware.ocpp.v2_0_1.messaging.ChargingStation chargingStation201;
	private @Autowired(required = false) io.u2ware.ocpp.v2_0_1.messaging.CSMS csms201;
	private @Autowired(required = false) io.u2ware.ocpp.v2_0_1.messaging.SpecificationSendingOperations ocppOperations201;	
	

	@Test
	void contextLoads() throws Exception {


		logger.info("===================");		
		logger.info(StringUtils.arrayToCommaDelimitedString(ac.getBeanNamesForType(SimpMessageSendingOperations.class)));
		logger.info("SimpMessageSendingOperations: "+simpOperations);

		logger.info("(v1.6)chargePoint: "+chargePoint16);
		logger.info("(v1.6)centralSystem: "+centralSystem16);
		logger.info("(v1.6)SpecificationSendingOperations: "+ocppOperations16);

		logger.info("(v2.1)chargingStation: "+chargingStation201);
		logger.info("(v2.1)csms: "+csms201);
		logger.info("(v2.1)SpecificationSendingOperations: "+ocppOperations201);


		logger.info("===================");		

		RestTemplateXhrTransport t = new RestTemplateXhrTransport();

		URI uri1 = UriComponentsBuilder.fromUriString(String.format("http://localhost:%d/console/info", port)).build().toUri();
		String result1 = t.executeInfoRequest(uri1, null);
		Assertions.assertNotNull(result1);
		logger.info(result1);

		URI uri2 = UriComponentsBuilder.fromUriString(String.format("http://localhost:%d/ocpp/info", port)).build().toUri();
		try{
			String result2 = t.executeInfoRequest(uri2, null);
			Assertions.assertNull(result2);
			logger.info(result2);

		}catch(Exception e){
			logger.info("", e);
		}
	}
}