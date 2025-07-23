package io.u2ware.ocpp.test.server2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.core.OCPPSessionConnectEvent;
import io.u2ware.ocpp.core.OCPPSessionDisconnectEvent;
import io.u2ware.ocpp.core.OCPPSessionErrorEvent;
import io.u2ware.ocpp.core.OCPPSessionReceivedEvent;
import io.u2ware.ocpp.core.OCPPSessionSendEvent;

@Component
public class ApplicationOcppHandler {
    
	protected Log logger = LogFactory.getLog(getClass());


    @EventListener
    public void handle(OCPPSessionConnectEvent e) {
        logger.info("ApplicationOcppHandler OCPPSessionConnectEvent: ");
    }

    @EventListener
    public void handle(OCPPSessionDisconnectEvent e) {
        logger.info("ApplicationOcppHandler OCPPSessionDisconnectEvent: ");
    }

    @EventListener
    public void handle(OCPPSessionSendEvent e) {
        logger.info("ApplicationOcppHandler OCPPSessionSendEvent: ");
    }

    @EventListener
    public void handle(OCPPSessionReceivedEvent e) {
        logger.info("ApplicationOcppHandler OCPPSessionReceivedEvent: ");
    }

    @EventListener
    public void handle(OCPPSessionErrorEvent e) {
        logger.info("ApplicationOcppHandler OCPPSessionErrorEvent: ");
    }
}
