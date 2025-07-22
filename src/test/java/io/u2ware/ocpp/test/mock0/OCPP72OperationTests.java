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


        ServerHanlder serverHanlder = new ServerHanlder(cs, transfer.getServerCallback());
        cs.registerUsecase(Specification.InitiatedByCentralSystem.Usecase.GetDiagnostics, serverHanlder);
        cs.registerUsecase(Specification.InitiatedByChargePoint.Usecase.DiagnosticsStatusNotification, serverHanlder);


        ClientHandler clientHandler = new ClientHandler(cp, transfer.getClientCallback());
        cp.registerUsecase(Specification.InitiatedByCentralSystem.Usecase.GetDiagnostics, clientHandler);
        cp.registerUsecase(Specification.InitiatedByChargePoint.Usecase.DiagnosticsStatusNotification, clientHandler);


        //////////////////////////////////////////////
        SpecificationAction ca = Specification.InitiatedByCentralSystem.Usecase.GetDiagnostics.message();
        logger.info(ca);

        cs.offer(ca, transfer.getServerCallback()); 
        Thread.sleep(3000);
    }



    public static class ServerHanlder implements GetDiagnostics.ServerHandler, DiagnosticsStatusNotification.ServerHandler {

        protected final Log logger = LogFactory.getLog(getClass());

        protected CentralSystem operation;
        protected OCPPConsumer<OCPPMessage<?>> callback;

        public ServerHanlder(CentralSystem operation, OCPPConsumer<OCPPMessage<?>> callback) {
            this.operation = operation;
            this.callback = callback;
        }

        @Override
        public GetDiagnosticsRequest sendGetDiagnosticsRequest(String id, Map<String,Object> req) {
            logger.info(comment(this, GetDiagnostics.Comment.sendGetDiagnosticsRequest, id));
            return new GetDiagnosticsRequest();
        }

        @Override
        public void receivedGetDiagnosticsResponse(String id, GetDiagnosticsResponse res, ErrorCode err) {
            logger.info(comment(this, GetDiagnostics.Comment.receivedGetDiagnosticsResponse, id));
        }

        @Override
        public DiagnosticsStatusNotificationResponse receivedDiagnosticsStatusNotificationRequest(String id, DiagnosticsStatusNotificationRequest req) {
            logger.info(comment(this, DiagnosticsStatusNotification.Comment.receivedDiagnosticsStatusNotificationRequest, id));
            return new DiagnosticsStatusNotificationResponse();
        }

        @Override
        public void sendDiagnosticsStatusNotificationResponse(String id, DiagnosticsStatusNotificationResponse res,  ErrorCode err) {
            logger.info(comment(this, DiagnosticsStatusNotification.Comment.sendDiagnosticsStatusNotificationResponse, id));
        }
    }

    public static class ClientHandler implements GetDiagnostics.ClientHandler, DiagnosticsStatusNotification.ClientHandler {

        protected final Log logger = LogFactory.getLog(getClass());

        protected ChargePoint operation;
        protected OCPPConsumer<OCPPMessage<?>> callback;

        public ClientHandler(ChargePoint operation, OCPPConsumer<OCPPMessage<?>> callback) {
            this.operation = operation;
            this.callback = callback;
        }


        @Override
        public GetDiagnosticsResponse receivedGetDiagnosticsRequest(String id, GetDiagnosticsRequest req) {
            logger.info(comment(this, GetDiagnostics.Comment.receivedGetDiagnosticsRequest, id));
            return new GetDiagnosticsResponse();
        }

        @Override
        public void sendGetDiagnosticsResponse(String id, GetDiagnosticsResponse res, ErrorCode err) {
            logger.info(comment(this, GetDiagnostics.Comment.sendGetDiagnosticsResponse, id));


            SpecificationAction a = Specification.InitiatedByChargePoint.Usecase.DiagnosticsStatusNotification.message("aaa");
            operation.offer(a, callback);
        }

        @Override
        public DiagnosticsStatusNotificationRequest sendDiagnosticsStatusNotificationRequest(String id, Map<String,Object> req) {
            logger.info(comment(this, DiagnosticsStatusNotification.Comment.sendDiagnosticsStatusNotificationRequest, id));
            return new DiagnosticsStatusNotificationRequest();
        }

        @Override
        public void receivedDiagnosticsStatusNotificationResponse(String id, DiagnosticsStatusNotificationResponse res, ErrorCode err) {
            logger.info(comment(this, DiagnosticsStatusNotification.Comment.receivedDiagnosticsStatusNotificationResponse, id));
        }
    }    

}
