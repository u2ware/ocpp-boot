package io.u2ware.ocpp.v2_0_1.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v2_0_1.actions.*;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.messaging.Specification;
import io.u2ware.ocpp.v2_0_1.model.*;

public interface A03 {
    
    public static Specification.Section section = Specification.Security.Usecase.A03;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }




    public static enum Comment {
        
        sendSignCertificateRequest("generate new public / private key pair"),
        receivedSignCertificateRequest,
        receivedSignCertificateResponse,
        sendSignCertificateResponse("forward CSR", "sign certificate", "return Signed Certificate", "call next sendCertificateSignedRequest"),

        sendCertificateSignedRequest,
        receivedCertificateSignedRequest("Verify validity of signed certificate"),
        receivedCertificateSignedResponse,
        sendCertificateSignedResponse("Switch to new certificate")

        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }


    public interface ClientHandler extends A03, SignCertificateOffer, CertificateSignedAnswer{


        public static final ClientHandler DEFAULT = new ClientHandler() {

            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public SignCertificateRequest sendSignCertificateRequest(String id, Map<String,Object> req) {
                logger.info(comment(this, Comment.sendSignCertificateRequest, id));
                return new SignCertificateRequest();
            }

            @Override
            public void receivedSignCertificateResponse(String id, SignCertificateResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedSignCertificateResponse, id));
            }

            @Override
            public CertificateSignedResponse receivedCertificateSignedRequest(String id, CertificateSignedRequest req) {
                logger.info(comment(this, Comment.receivedCertificateSignedRequest, id));
                return new CertificateSignedResponse();
            }
            @Override
            public void sendCertificateSignedResponse(String id, CertificateSignedResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendCertificateSignedResponse, id));
            }
        };
    }

    public interface ServerHandler extends A03, SignCertificateAnswer, CertificateSignedOffer {


        public static final ServerHandler DEFAULT = new ServerHandler() {

            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public SignCertificateResponse receivedSignCertificateRequest(String id, SignCertificateRequest req) {
                logger.info(comment(this, Comment.receivedSignCertificateRequest, id));
                return new SignCertificateResponse();
            }

            @Override
            public void sendSignCertificateResponse(String id, SignCertificateResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendSignCertificateResponse, id));
            }

            @Override
            public CertificateSignedRequest sendCertificateSignedRequest(String id, Map<String,Object> req) {
                logger.info(comment(this, Comment.sendCertificateSignedRequest, id));
                return new CertificateSignedRequest();
            }

            @Override
            public void receivedCertificateSignedResponse(String id, CertificateSignedResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedCertificateSignedResponse, id));
            }
        };
    }

}
