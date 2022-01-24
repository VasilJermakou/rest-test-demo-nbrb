package com.vaer.springboot.resttestdemo.controller;

import com.vaer.springboot.resttestdemo.model.Rate;
import com.vaer.springboot.resttestdemo.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @created 18/01/2022 - 21:39 by VAER
 */

@RestController
@RequestMapping("/api/v1/")
public class RateContrloller {

    /**
     * http://localhost:9966/api/v1/rates
     * */

    /* class fields */
    @Autowired
    private RateService rateService;

    /* class methods */

    @GetMapping("/rates")
    public List<Rate> getRates(){
        //this.rateService.printCurrencyCode();
        //return "getRates() on action";

        List<Rate> rates = this.rateService.getRates().getBody();
        return rates;
    }

    @GetMapping("/rates/{code}")
    public Rate getRateByInternalCode(@PathVariable("code") String internalCode){
        Rate resultRate = this.rateService.getRateByInternalCode(internalCode).getBody();
        return resultRate;
    }

    @GetMapping("/currencies")
    public String getAllCurrenciesData(){
        return this.rateService.getAllCurrenciesData();
    }
}
