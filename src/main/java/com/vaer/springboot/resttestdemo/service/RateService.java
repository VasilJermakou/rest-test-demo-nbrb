package com.vaer.springboot.resttestdemo.service;

import com.vaer.springboot.resttestdemo.model.Rate;
import org.springframework.http.ResponseEntity;
import java.util.List;

/**
 * @created 18/01/2022 - 22:01 by VAER
 */
public interface RateService {

    public ResponseEntity<Rate> getRateByInternalCode(String internalCode);
    public ResponseEntity<List<Rate>> getRates();
    public String getAllCurrenciesData();
}
