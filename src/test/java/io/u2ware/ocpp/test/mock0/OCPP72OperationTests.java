package io.u2ware.ocpp.test.mock0;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;

import io.u2ware.ocpp.core.*;
import io.u2ware.ocpp.v1_6.messaging.*;
import io.u2ware.ocpp.v1_6.exception.*;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.*;


public class OCPP72OperationTests {
    

    protected final Log logger = LogFactory.getLog(getClass());


    @Test
    public void contextLoads()  throws Exception{


        CentralSystem cs = new CentralSystem();
        ChargePoint cp = new ChargePoint();

        SimpleMessageTransfer transfer = new SimpleMessageTransfer(cs, cp);

        cs.registerUsecase(Specification.InitiatedByCentralSystem.Usecase.GetDiagnostics, new Offer(cs, transfer.getServerCallback()));
        cp.registerUsecase(Specification.InitiatedByCentralSystem.Usecase.GetDiagnostics, new Answer(cp, transfer.getClientCallback()));


        //////////////////////////////////////////////


        SpecificationAction ca = Specification.InitiatedByCentralSystem.Usecase.GetDiagnostics.message();
        logger.info(ca);

        cs.offer(ca, transfer.getServerCallback()); 
        Thread.sleep(3000);
    }



    public static class Offer implements GetDiagnostics.ServerHandler {

        protected final Log logger = LogFactory.getLog(getClass());

        protected CentralSystem operation;
        protected OCPPConsumer<OCPPMessage<?>> callback;

        public Offer(CentralSystem operation, OCPPConsumer<OCPPMessage<?>> callback) {
            this.operation = operation;
            this.callback = callback;
        }

        @Override
        public GetDiagnosticsRequest sendGetDiagnosticsRequest(String id, Map<String,Object> req) {
            logger.info(comment(this, Comment.sendGetDiagnosticsRequest, id));
            return new GetDiagnosticsRequest();
        }

        @Override
        public void receivedGetDiagnosticsResponse(String id, GetDiagnosticsResponse res, ErrorCode err) {
            logger.info(comment(this, Comment.receivedGetDiagnosticsResponse, id));
        }

        @Override
        public DiagnosticsStatusNotificationResponse receivedDiagnosticsStatusNotificationRequest(String id, DiagnosticsStatusNotificationRequest req) {
            logger.info(comment(this, Comment.receivedDiagnosticsStatusNotificationRequest, id));
            return new DiagnosticsStatusNotificationResponse();
        }

        @Override
        public void sendDiagnosticsStatusNotificationResponse(String id, DiagnosticsStatusNotificationResponse res,  ErrorCode err) {
            logger.info(comment(this, Comment.sendDiagnosticsStatusNotificationResponse, id));
        }
    }

    public static class Answer implements GetDiagnostics.ClientHandler {

        protected final Log logger = LogFactory.getLog(getClass());

        protected ChargePoint operation;
        protected OCPPConsumer<OCPPMessage<?>> callback;

        public Answer(ChargePoint operation, OCPPConsumer<OCPPMessage<?>> callback) {
            this.operation = operation;
            this.callback = callback;
        }


        @Override
        public GetDiagnosticsResponse receivedGetDiagnosticsRequest(String id, GetDiagnosticsRequest req) {
            logger.info(comment(this, Comment.receivedGetDiagnosticsRequest, id));
            return new GetDiagnosticsResponse();
        }

        @Override
        public void sendGetDiagnosticsResponse(String id, GetDiagnosticsResponse res, ErrorCode err) {
            logger.info(comment(this, Comment.sendGetDiagnosticsResponse, id));


            SpecificationAction a = Specification.InitiatedByCentralSystem.GetDiagnostics.DiagnosticsStatusNotification.message("aaa");
            operation.offer(a, callback);
        }

        @Override
        public DiagnosticsStatusNotificationRequest sendDiagnosticsStatusNotificationRequest(String id, Map<String,Object> req) {
            logger.info(comment(this, Comment.sendDiagnosticsStatusNotificationRequest, id));
            return new DiagnosticsStatusNotificationRequest();
        }

        @Override
        public void receivedDiagnosticsStatusNotificationResponse(String id, DiagnosticsStatusNotificationResponse res, ErrorCode err) {
            logger.info(comment(this, Comment.receivedDiagnosticsStatusNotificationResponse, id));
        }
    }    

}
