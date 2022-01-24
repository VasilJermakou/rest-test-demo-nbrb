package com.vaer.springboot.resttestdemo.service.impl;

import com.vaer.springboot.resttestdemo.model.Rate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @created 24/01/2022 - 22:30 by VAER
 */

class RateServiceImplTest {

    /**
     * this is article of unit test example
     * https://www.baeldung.com/java-spring-mockito-mock-mockbean
     * */

    @Test
    void getRateByInternalCode() {

        //given
        Rate rate = new Rate("431", "2022-01-24T00:00:00", "USD", "1", "Доллар США", "2.5752");

        //create mock, create response object, define what mock should return after calling method
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
        ResponseEntity<Rate> responseEntity = new ResponseEntity<Rate>(rate, HttpStatus.OK);
        Mockito.when(restTemplate.exchange("url", HttpMethod.GET, null,new ParameterizedTypeReference<Rate>() {})).thenReturn(responseEntity);

        //when
        ResponseEntity<Rate> temp =restTemplate.exchange("url", HttpMethod.GET, null,new ParameterizedTypeReference<Rate>() {});
        Rate expected = temp.getBody();

        //then
        Assertions.assertEquals(rate.getCurOfficialRate(), expected.getCurOfficialRate());
    }
}