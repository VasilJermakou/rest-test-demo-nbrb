package com.vaer.springboot.resttestdemo.controller;

import com.vaer.springboot.resttestdemo.exception.RateErrorResponse;
import com.vaer.springboot.resttestdemo.exception.RateNotFoundException;
import com.vaer.springboot.resttestdemo.model.Rate;
import com.vaer.springboot.resttestdemo.service.RateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @created 18/01/2022 - 21:39 by VAER
 */

@RestController
@RequestMapping("/api/v1/")
@Slf4j
public class RateContrloller {

    /**
     * http://localhost:9966/api/v1/rates
     * */

    /* class fields */
    @Autowired
    private RateService rateService;

    @Autowired
    private Environment env;

    /* class methods */

    @GetMapping("/rates")
    public List<Rate> getRates(){
        List<Rate> rates = this.rateService.getRates().getBody();
        log.info(">> getRates() completed success");
        return rates;
    }

    @GetMapping("/rates/{code}")
    public Rate getRateByInternalCode(@PathVariable("code") String internalCode){

        int interCode = Integer.parseInt(internalCode);
        int tempUsd = Integer.parseInt(env.getProperty("internal.code.usd"));
        int tempEur = Integer.parseInt(env.getProperty("internal.code.eur"));
        int tempRur = Integer.parseInt(env.getProperty("internal.code.rur"));

        Rate resultRate = null;

        if(interCode == tempUsd || interCode == tempEur || interCode == tempRur){
            resultRate = this.rateService.getRateByInternalCode(internalCode).getBody();
            log.info(">> getRateByInternalCode() completed success. InternalCode = " + internalCode);
        }else{
            log.error("getRateByInternalCode() failed. InternalCode = " + internalCode);
            throw new RateNotFoundException("Rate not found: currency code - " + internalCode);
        }

        return resultRate;
    }

    @ExceptionHandler
    public ResponseEntity<RateErrorResponse> handleException(RateNotFoundException exception){

        RateErrorResponse response = new RateErrorResponse();
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(exception.getMessage());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/currencies")
    public String getAllCurrenciesData(){
        log.info(">> getAllCurrenciesData() completed success");
        return this.rateService.getAllCurrenciesData();
    }
}
