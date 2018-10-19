package com.java.engineering.tdddemo.resource;

import com.java.engineering.tdddemo.model.SumRequest;
import com.java.engineering.tdddemo.model.SumResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SumController {

    @PostMapping(value = "/sum", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity sum(@RequestBody SumRequest sumRequest) {

        Integer number1 = sumRequest.getNumber1();
        Integer number2 = sumRequest.getNumber2();


        if (!StringUtils.isEmpty(number1) && number1 < 0 || !StringUtils.isEmpty(number2)&& number2 < 0) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(new SumResponse((StringUtils.isEmpty(number1) ? 0 : number1) + (StringUtils.isEmpty(number2) ? 0 : number2)));
    }


}
