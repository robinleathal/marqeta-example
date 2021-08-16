package com.gitlab.johnjvester.marqeta.models.responses;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gitlab.johnjvester.marqeta.models.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MarqetaTransactionPostResponse {
    private Transaction transaction;

    @JsonProperty(value = "raw_iso8583")
    @JsonAlias(value = "raw_iso8583")
    private Object rawIso8583;
}
