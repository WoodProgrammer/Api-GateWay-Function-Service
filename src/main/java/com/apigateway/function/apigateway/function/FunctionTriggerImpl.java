package com.apigateway.function.apigateway.function;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FunctionTriggerImpl implements FunctionTrigger {

    @Autowired
    FunctionRequestTemplateService functionRequestTemplateService;

    @Autowired
    public MessageService messageService;


    public List functioTrigger(String functionName, String functionRequestBody){

        List listA = new ArrayList();
        boolean status ;

        JSONObject trustedTemplate = functionRequestTemplateService.getTemplateWithName(functionName);
        JSONObject currentfunctionRequestTemplate = new JSONObject(functionRequestBody);

        if(trustedTemplate.keys() == currentfunctionRequestTemplate.keys()) {
            status = messageService.produceFunctionMessage(functionName, functionRequestBody);
        }else{
            status = false ;
        }

        listA.add("status : " + status);
        return listA ;


    }


}
