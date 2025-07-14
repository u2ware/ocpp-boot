package io.u2ware.ocpp.core;

public enum OCPPVersion {

    V1_6,//("io.u2ware.ocpp.specification.v1_6"),
    V2_0_1,//("io.u2ware.ocpp.specification.v2_0_1"),
    V2_1,//("io.u2ware.ocpp.specification.v2_1"),
    ;

    // private String rootPackage;
    // OCPPVersion(String rootPackage){
    //     this.rootPackage = rootPackage;
    // }

    // private String requestTypeName(String name) {
    //    return rootPackage+".model."+name+"Request";
    // }

    // private String responseTypeName(String name) {
    //    return rootPackage+".model."+name+"Response";
    // }

    // private String errorTypeName(String name) {
    //    return rootPackage+".exception.ErrorCode";
    // }

    // private String clientTypeName(String name) {
    //    return rootPackage+".usecase."+name+".Client";
    // }

    // private String serverTypeName(String name) {
    //    return rootPackage+".usecase."+name+".Server";
    // }

    // private String actionOfferTypeName(String name) {
    //    return rootPackage+".actions."+name+"Offer";
    // }

    // private String actionAnswerTypeName(String name) {
    //    return rootPackage+".actions."+name+"Answer";
    // }

    // private String usecaseOfferTypeName(String name) {
    //    return rootPackage+".usecase."+name+".Offer";
    // }

    // private String usecaseAnswerTypeName(String name) {
    //    return rootPackage+".usecase."+name+".Answer";
    // }

    // private Class<?> resolve(String name) {
    //     try{
    //         return ClassUtils.forName(name, getClass().getClassLoader());
    //     }catch(Exception e){
    //         return null;
    //     }
    // }

    // public Class<?> requestType(String name) {
    //     return resolve(requestTypeName(name));
    // }
    // public Class<?> responseType(String name) {
    //     return resolve(responseTypeName(name));
    // }
    // public Class<?> errorType(String name) {
    //     return resolve(errorTypeName(name));
    // }
    // public Class<?> clientType(String name) {
    //     return resolve(clientTypeName(name));
    // }
    // public Class<?> serverType(String name) {
    //     return resolve(serverTypeName(name));
    // }



    // public Class<?> actionOfferType(String name) {
    //     return resolve(actionOfferTypeName(name));
    // }
    // public Class<?> actionAnswerType(String name) {
    //     return resolve(actionAnswerTypeName(name));
    // }
    // public Class<?> usecaseOfferType(String name) {
    //     return resolve(usecaseOfferTypeName(name));
    // }
    // public Class<?> usecaseAnswerType(String name) {
    //     return resolve(usecaseAnswerTypeName(name));
    // }

    // public boolean isRequestType(String name, Object target) {
    //     return ClassUtils.isAssignableValue(requestType(name), target);
    // }
    // public boolean isResponseType(String name, Object target) {
    //     return ClassUtils.isAssignableValue(responseType(name), target);
    // }
    // public boolean isErrorType(String name, Object target) {
    //     return ClassUtils.isAssignableValue(errorType(name), target);
    // }
    // // public boolean isActionOfferType(String name, Object target) {
    // //     return ClassUtils.isAssignableValue(actionOfferType(name), target);
    // // }
    // // public boolean isActionAnswerType(String name, Object target) {
    // //     return ClassUtils.isAssignableValue(actionAnswerType(name), target);
    // // }
    // // public boolean isUsecaseOfferType(String name, Object target) {
    // //     return ClassUtils.isAssignableValue(usecaseOfferType(name), target);
    // // }
    // // public boolean isUsecaseReceiverType(String name, Object target) {
    // //     return ClassUtils.isAssignableValue(usecaseAnswerType(name), target);
    // // }


    // public boolean isClientType(String name, Object target) {
    //     return ClassUtils.isAssignableValue(clientType(name), target);
    // }
    // public boolean isServerType(String name, Object target) {
    //     return ClassUtils.isAssignableValue(serverType(name), target);
    // }



 

}