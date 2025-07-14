package io.u2ware.ocpp.v2_0_1.exception;

public enum ISO15118Abbreviations {
    

    EIM("External Identification Means"),
    EMAID("E-Mobility Account Identifier"),
    EVCC("EV Communication Controller"),
    HLC("High Level Communication"),
    HMI("Human Machine Interface"),
    LAN("Local Area Network"),
    MO("Mobility Operator"),
    OEM("Original Equipment Manufacturer"),
    OCSP("Online Certificate Status Protocol"),
    PWM("Pulse Width Modulation"),
    SA("Secondary Actor"),
    SECC("Supply Equipment Communication Controller"),
    V2G("Vehicle to Grid"),

    ;

    private String description;
    ISO15118Abbreviations(String description) {
        this.description = description;
    }

    public String description(){
        return description;
    }    
}
