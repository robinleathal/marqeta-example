package com.gitlab.johnjvester.marqeta.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CardAcceptor {
    private String mid;
    private String mcc;
    private String name;

    @JsonAlias(value = "street_address")
    private String streetAddress;

    private String city;
    private String state;
    private String zip;

    @JsonAlias(value = "country_code")
    private String countryCode;
}
