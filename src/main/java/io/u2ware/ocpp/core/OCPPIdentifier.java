package io.u2ware.ocpp.core;


class OCPPIdentifier {

    private String usecase;
    private String action;
    private String identifier;

    OCPPIdentifier(String usecase, String action, String identifier){
        this.usecase = usecase;
        this.action = action;
        this.identifier = identifier;
    }

    public String getUsecase() {
        return usecase;
    }
    public void setUsecase(String usecase) {
        this.usecase = usecase;
    }
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public String getIdentifier() {
        return identifier;
    }
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }


}