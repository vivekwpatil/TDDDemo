package com.java.engineering.tdddemo.resource;

import com.java.engineering.tdddemo.model.SumRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.WebMethod;

@RestController
public class SumController {

    @RequestMapping(value = "/sum", method = RequestMethod.POST)
    public Integer sum(SumRequest sumRequest) {
        return sumRequest.getNumber1()+ sumRequest.getNumber2();
    }


}
