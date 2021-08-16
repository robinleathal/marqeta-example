package com.gitlab.johnjvester.marqeta.models.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class MarqetaTransactionRequest extends MarquetaRequest {
    private BigDecimal amount;
    private String mid;

    @JsonProperty(value = "card_token")
    private String cardToken;

    @JsonProperty(value = "card_acceptor")
    private MarqetaCardAcceptorRequest cardAcceptor;
}
