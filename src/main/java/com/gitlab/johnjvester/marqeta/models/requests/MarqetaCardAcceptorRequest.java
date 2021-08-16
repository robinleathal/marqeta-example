package com.gitlab.johnjvester.marqeta.models.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MarqetaCardAcceptorRequest {
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
}
