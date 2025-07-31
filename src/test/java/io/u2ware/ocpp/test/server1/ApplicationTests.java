package io.u2ware.ocpp.test.server1;

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
	private @Autowired(required = false) io.u2ware.ocpp.v1_6.messaging.ChargePointCommandOperations chargePoint16Operations;	
	private @Autowired(required = false) io.u2ware.ocpp.v1_6.messaging.ChargePointInitializer chargePoint16Initializer;	

	private @Autowired(required = false) io.u2ware.ocpp.v1_6.messaging.CentralSystem centralSystem16;
	private @Autowired(required = false) io.u2ware.ocpp.v1_6.messaging.CentralSystemCommandOperations centralSystem16Operations;
	private @Autowired(required = false) io.u2ware.ocpp.v1_6.messaging.CentralSystemInitializer centralSystem16Initializer;	

	private @Autowired(required = false) io.u2ware.ocpp.v2_0_1.messaging.ChargingStation chargingStation201;
	private @Autowired(required = false) io.u2ware.ocpp.v2_0_1.messaging.ChargingStationCommandOperations chargingStation201Operations;
	private @Autowired(required = false) io.u2ware.ocpp.v2_0_1.messaging.ChargingStationInitializer chargingStation201Initializer;	
	

	private @Autowired(required = false) io.u2ware.ocpp.v2_0_1.messaging.CSMS csms201;
	private @Autowired(required = false) io.u2ware.ocpp.v2_0_1.messaging.CSMSCommandOperations csms201Operations;
	private @Autowired(required = false) io.u2ware.ocpp.v2_0_1.messaging.CSMSInitializer csms201Initializer;	
	

	@Test
	void contextLoads() throws Exception {


		logger.info("===================");		
		logger.info(StringUtils.arrayToCommaDelimitedString(ac.getBeanNamesForType(SimpMessageSendingOperations.class)));
		logger.info("SimpMessageSendingOperations: "+simpOperations);

		logger.info("(v1.6)chargePoint16            : "+chargePoint16);
		logger.info("(v1.6)chargePoint16Operations  : "+chargePoint16Operations);
		logger.info("(v1.6)chargePoint16Initializer : "+chargePoint16Initializer);

		logger.info("(v1.6)centralSystem16            : "+centralSystem16);
		logger.info("(v1.6)centralSystem16Operations  : "+centralSystem16Operations);
		logger.info("(v1.6)centralSystem16Initializer : "+centralSystem16Initializer);


		logger.info("(v2.0.1)chargingStation201            : "+chargingStation201);
		logger.info("(v2.0.1)chargingStation201Operations  : "+chargingStation201Operations);
		logger.info("(v2.0.1)chargingStation201Initializer : "+chargingStation201Initializer);

		logger.info("(v2.0.1)csms201            : "+csms201);
		logger.info("(v2.0.1)csms201Operations  : "+csms201Operations);
		logger.info("(v2.0.1)csms201Initializer : "+csms201Initializer);
		logger.info("===================");		



		RestTemplateXhrTransport t = new RestTemplateXhrTransport();

		URI uri1 = UriComponentsBuilder.fromUriString(String.format("http://localhost:%d/console/info", port)).build().toUri();
		String result1 = t.executeInfoRequest(uri1, null);
		Assertions.assertNotNull(result1);
		logger.info(result1);

		URI uri2 = UriComponentsBuilder.fromUriString(String.format("http://localhost:%d/ocpp/info", port)).build().toUri();
		String result2 = t.executeInfoRequest(uri2, null);
		Assertions.assertNotNull(result2);
		logger.info(result2);

	}
}