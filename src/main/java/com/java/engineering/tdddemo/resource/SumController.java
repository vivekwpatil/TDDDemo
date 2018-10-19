package com.java.engineering.tdddemo.resource;

import com.java.engineering.tdddemo.model.SumRequest;
import com.java.engineering.tdddemo.model.SumResponse;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SumController {

    @PostMapping(value = "/sum", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    SumResponse sum(@RequestBody SumRequest sumRequest) {

        return new SumResponse((StringUtils.isEmpty(sumRequest.getNumber1())?0 :sumRequest.getNumber1()) +( StringUtils.isEmpty(sumRequest.getNumber2())?0 :sumRequest.getNumber2()));
    }


}
