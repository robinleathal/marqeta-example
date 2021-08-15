package com.gitlab.johnjvester.marqeta.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class GeneralPurposeAccountOrder extends Base {
    private BigDecimal amount;

    @JsonAlias(value = "transaction_token")
    private String transactionToken;

    private String state;
    private TransactionResponse response;
    private Funding funding;

    @JsonAlias(value = "funding_source_token")
    private String fundingSourceToken;

    @JsonAlias(value = "user_token")
    private String userToken;

    @JsonAlias(value = "currency_code")
    private String currencyCode;
}
