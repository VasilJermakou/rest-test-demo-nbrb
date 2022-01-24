package com.vaer.springboot.resttestdemo.service.impl;

import com.vaer.springboot.resttestdemo.model.Rate;
import com.vaer.springboot.resttestdemo.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

/**
 * @created 18/01/2022 - 22:04 by VAER
 */
@Service
public class RateServiceImpl implements RateService {

    /* class fields */
    @Value("${code.usd}")
    private String codeUsd;

    @Value("${code.eur}")
    private String codeEur;

    @Value("${code.rus}")
    private String codeRus;

    @Value("${all.currency.nbrb.url}")
    private String allCurrencyNbrbUrl;

    @Value("${internal.code.currency.rate.url}")
    private String internalCodeCurrencyRateUrl;

    @Value("${currency.data.url}")
    private String currenciesDataUrl;

    @Autowired
    private RestTemplate restTemplate;

    /* class methods */
    /**
     * urlWithInternalCode - https://www.nbrb.by/api/exrates/rates/ + internalCode
     * internalCode: 431 - USD, 451 - UER, 456 - RUR
     * */
    @Override
    public ResponseEntity<Rate> getRateByInternalCode(String internalCode) {

        String urlWithInternalCode = this.internalCodeCurrencyRateUrl + internalCode;
        ResponseEntity<Rate> responseEntity =this.restTemplate.exchange(urlWithInternalCode, HttpMethod.GET, null, new ParameterizedTypeReference<Rate>() {});
        return responseEntity;
    }

    /**
     * exchange method params:
     * allCurrencyNbrbUrl - the URL of REST API of National Bank of RB, get all currency rates
     * HttpMethod.GET - set which Http method we use
     * RequestEntity<T> - use this param when we want to add body to HTTPRequest
     * ParameterizedTypeReference<List<Rate>>() {} - without overriding, this is utility class, the main object of it is to transfer generic type,
     * in our case it`s a List of Rate
     * */
    @Override
    public ResponseEntity<List<Rate>> getRates() {

        ResponseEntity<List<Rate>> responseEntity = this.restTemplate.exchange(this.allCurrencyNbrbUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Rate>>() {});
        return responseEntity;
    }

    @Override
    public String getAllCurrenciesData() {
        ResponseEntity<String> responseEntity = this.restTemplate.exchange(currenciesDataUrl, HttpMethod.GET,null, new ParameterizedTypeReference<String>() {});
        return responseEntity.getBody();
    }

}
