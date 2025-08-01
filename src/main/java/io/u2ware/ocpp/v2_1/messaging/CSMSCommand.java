package io.u2ware.ocpp.v2_1.messaging;

import java.util.HashMap;
import java.util.Map;

import io.u2ware.ocpp.OCPPCommand;

public class CSMSCommand extends OCPPCommand{

    private CSMSCommand(){ }

    public interface Builder {
        
        public String usecase(); 
        public String action();

        default CSMSCommand build() {
            return build(Long.toString(System.currentTimeMillis()), new HashMap<>());
        }

        default CSMSCommand build(String identifier) {
            return build(identifier, new HashMap<>());
        }
    
        default CSMSCommand build(String identifier, Map<String,Object> attributes) {
            return create(usecase(), action(), identifier, attributes);
        }

        default CSMSCommand buildWith(String feature) {
            return buildWith(feature, Long.toString(System.currentTimeMillis()), new HashMap<>());
        }

        default CSMSCommand buildWith(String feature, String identifier) {
            return buildWith(feature, identifier, new HashMap<>());
        }
    
        default CSMSCommand buildWith(String feature, String identifier, Map<String,Object> attributes) {
            return create(feature, action(), identifier, attributes);
        }

        private static CSMSCommand create(String usecase, String action, String identifier, Map<String,Object> attributes){
            CSMSCommand u = new CSMSCommand();
            u.setIdentifier(identifier+usecase);
            u.setUsecase(usecase);
            u.setAction(action);
            u.setAttributes(attributes);
            return u;
        }

    }


    public enum ALL implements Builder {
        
        ;

        @Override
        public String usecase() {
            return "";
        }

        @Override
        public String action() {
            return name();            
        }
    }

    public enum Security implements Builder {


        ;

        @Override
        public String usecase() {
            return "";
        }

        @Override
        public String action() {
            return name();            
        }
    }

    public enum A1 implements Builder {

        ;

        @Override
        public String usecase() {
            return "";
        }

        @Override
        public String action() {
            return name();            
        }
    }
}
