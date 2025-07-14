package io.u2ware.ocpp.v2_0_1.exception;

public enum GeneralAbbreviations {

    AES("Advanced Encryption Standard. Original name for this block cipher was Rijndael named after its designers Vincent Rijmen and Joan Daemen."),
    BEV("Battery Electric Vehicle"),
    CMP("Certificate Management Protocol"),
    CS("Charging Station"),
    CSL("Comma Separated List"),
    CSMS("Charging Station Management System"),
    CSO("Charging Station Operator"),
    DHCP("Dynamic Host Configuration Protocol"),
    DNS("Domain Name System"),
    DSO("Distribution System Operator"),
    DST("Daylight Saving Time"),
    EC("Elliptic Curve. See also ENISA OCPP Security [1]"),
    ECDSA("Elliptic Curve Digital Signature Algorithm."),
    EMS("Energy Management System"),
    ENISA("European Union Agency for Network and Information Security."),
    EV("Electric Vehicle"),
    EVSE("EV Supply Equipment IEC61851-1"),
    FQDN(" Fully Qualified Domain Name"),
    FTP("(S) File Transport Protocol (Secure)"),
    HTTP("(S) HyperText Transport Protocol (Secure)"),
    ICCID(" Integrated Circuit Card Identifier"),
    IMSI(" International Mobile Subscription Identity"),
    JSON(" JavaScript Simple Object Notation"),
    MAC(" Message authentication code. Provides data integrity. Examples: CMAC, GMAC. See also ENISA OCPP Security [1]."),
    NAT(" Network Address Translation"),
    NIST(" National Institute of Standards and Technology."),
    NTP(" Network Time Protocol"),
    PDU(" Protocol Data Unit"),
    PHEV(" Plugin Hybrid Electric Vehicle"),
    RDN(" Relative Distinguished Name"),
    RSA(" Public-key cryptosystem named after its inventors Rivest, Shamir, and Adleman."),
    RSA_PSS("RSA-PSS is a new signature scheme that is based on the RSA cryptosystem and provides increased security assurance. It was added in version 2.1 of PKCS #1, following OCPP Security [23]"),
    RST(" 3 phase power connection, Standard Reference Phasing"),
    RTS(" 3 phase power connection, Reversed Reference Phasing"),
    SRT(" 3 phase power connection, Reversed 240 degree rotation"),
    STR(" 3 phase power connection, Standard 120 degree rotation"),
    TRS(" 3 phase power connection, Standard 240 degree rotation"),
    TSR(" 3 phase power connection, Reversed 120 degree rotation"),
    SC(" Smart Charging"),
    TLS(" Transport Layer Security"),
    TSO(" Transmission System Operator"),
    URI(" Uniform Resource Identifier RFC-3986 [RFC3986]"),
    URL(" Uniform Resource Locator - refers to the subset of URIs that, in addition to identifying a resource, provide a means of locating the resource by describing its primary access mechanism (e.g., its network \"location\")."),
    UTC(" Coordinated Universal Time"),
    WAN(" Wide Area Network."),


    ;

    private String description;
    GeneralAbbreviations(String description) {
        this.description = description;
    }

    public String description(){
        return description;
    }

}