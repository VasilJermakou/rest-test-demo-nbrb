package com.vaer.springboot.resttestdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * @created 18/01/2022 - 21:54 by VAER
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Rate {

    /* class fields */
    @JsonProperty(value = "Cur_ID")
    private String curId;

    @JsonProperty(value = "Date")
    private String date;

    @JsonProperty(value = "Cur_Abbreviation")
    private String curAbbreviation;

    @JsonProperty(value = "Cur_Scale")
    private String curScale;

    @JsonProperty(value = "Cur_Name")
    private String curName;

    @JsonProperty(value = "Cur_OfficialRate")
    private String curOfficialRate;
}
