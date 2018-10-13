package com.apigateway.function.apigateway.function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.lang.annotation.ElementType;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

@RestController
@RequestMapping("/function")
public class FunctionController {


    @Autowired
    public FunctionTriggerImpl functionTrigger;

    @PostMapping(value = "/run/{id}")
    public List runFunction(@PathVariable String id, @RequestBody Map<String, String> body) {


        return functionTrigger.functioTrigger(body.get("functionName"), body.get("functionRequestBodyTemplate"));
    }


}
