package com.apigateway.function.apigateway.function;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class FunctionRequestTemplateService {

    @Value("${function.requestBody.service}")
    private String serviceName;

    public JSONObject getTemplateWithName(String functionName) {

        RestTemplate restTemplate = new RestTemplate();
        JSONObject template = restTemplate.getForObject(serviceName+"/requestBodies/"+functionName, JSONObject.class);


        return template;


    }
}


