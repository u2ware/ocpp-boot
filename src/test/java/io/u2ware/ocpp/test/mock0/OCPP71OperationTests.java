package io.u2ware.ocpp.test.mock0;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;

import io.u2ware.ocpp.core.OCPPConversion;
import io.u2ware.ocpp.v1_6.messaging.*;

public class OCPP71OperationTests {


    protected final Log logger = LogFactory.getLog(getClass());


    @Test
    public void contextLoads()  throws Exception{

        CentralSystem cs = new CentralSystem();
        cs.registerDefaultUsecase(Specification.InitiatedByChargePoint.Usecase.Authorize);

        ChargePoint cp = new ChargePoint();
        cp.registerDefaultUsecase(Specification.InitiatedByChargePoint.Usecase.Authorize);


        //////////////////////////////////////////////
        OCPPConversion conversion = new OCPPConversion();

        SpecificationAction o1 = Specification.InitiatedByChargePoint.Usecase.Authorize.message("Authorize");
        String o2 = conversion.comfortableWriteValue(o1);
        
        //////////////////////////////////////////////
        // Core
        //////////////////////////////////////////////
        //Only Message,,,,
        // cp.offer(m1, (r1,u1)->{
        //     if(t1 == null) return;
        //     cs.answer(r1, (r2, u2)->{
        //         if(r2 == null) return;
        //         cp.answer(r2, (r3,u3)->{
                    
        //         });
        //     });
        // });


        // Complex..
        // cp.offer(m1, (r1,u1)->{
        //     if(t1 == null) return;
        //     cs.answer(conversion.convertMessage(r1), (r2, u2)->{
        //         if(r2 == null) return;
        //         cp.answer(r2, (r3,u3)->{
        //         });
        //     });
        // });

        //Only Text,,,,
        // cp.offer(t1, (r1,u1)->{
        //     if(t1 == null) return;
        //     cs.answer(r1, (r2, u2)->{
        //         if(r2 == null) return;
        //         cp.answer(r2, (r3,u3)->{
        //         });
        //     });
        // });

        //////////////////////////////////////////////
        //  SimpleMessageEvent
        //////////////////////////////////////////////

        // SimpleMessageEvent event = new SimpleMessageEvent();
        // event.subscribeServer((e)->{
        //     String t = (String)e.getSource();
        //     cp.answer(t, (r, u)->{
        //         if(r == null) return;
        //         event.publishClient(new ClientEvent(r));
        //     });
        // });
        // event.subscribeClient((e)->{
        //     String t = (String)e.getSource();
        //     cs.answer(t, (r, u)->{
        //         if(r == null) return;
        //         event.publishServer(new ServerEvent(r));
        //     });
        // });

        // cp.offer(o1, (r,u)->{
        //     if(r == null) return;
        //     event.publishClient(new ClientEvent(conversion.convertMessage(r)));
        // });
        // Thread.sleep(1000);

        // cp.offer(o2, (r,u)->{
        //     if(r == null) return;
        //     event.publishClient(new ClientEvent(r));
        // });
        // Thread.sleep(1000);
        

        //////////////////////////////////////////////
        //  SimpleMessageTransfer
        //////////////////////////////////////////////

        SimpleMessageTransfer transfer = new SimpleMessageTransfer(cs, cp);
        cp.offer(o1, transfer.getClientCallback());
        Thread.sleep(1000);

        cp.offer(o2, transfer.getClientCallback());
        Thread.sleep(1000);
    }


    
}
