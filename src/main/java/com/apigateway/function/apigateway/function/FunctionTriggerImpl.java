package com.apigateway.function.apigateway.function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FunctionTriggerImpl implements FunctionTrigger {

    @Autowired
    public MessageService messageService;


    public List functioTrigger(String functionName, String functionRequestBody){

        List listA = new ArrayList();
        boolean statusOfTriggering = messageService.produceFunctionMessage(functionName, functionRequestBody);

        if (statusOfTriggering == true ){
            listA.add("{'status': 'Ok'}");

        }else{
            listA.add("{'status': 'Error'}");


        }
        return listA ;


    }


}
