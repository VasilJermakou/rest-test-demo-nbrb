package com.vaer.springboot.resttestdemo.exception;

import lombok.*;

/**
 * @created 25/01/2022 - 19:43 by VAER
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RateErrorResponse {

    /* class fields */
    private int status;
    private String message;
    private long timeStamp;
}
