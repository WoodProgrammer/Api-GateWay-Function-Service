package com.apigateway.function.apigateway.function;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class FunctionTriggerImpl implements FunctionTrigger {


    public List functioTrigger(String functionName, String functionRequestBody){

        List listA = new ArrayList();
        listA.add(functionName);

        listA.add(functionRequestBody);


        return listA;
    }


}
