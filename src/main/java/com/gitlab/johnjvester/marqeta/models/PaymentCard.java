package com.gitlab.johnjvester.marqeta.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class PaymentCard extends Base {
    private String type;
    private boolean active;

    @JsonAlias(value = "user_token")
    private String userToken;

    @JsonAlias(value = "account_suffix")
    private String accountSuffix;

    @JsonAlias(value = "account_type")
    private String accountType;

    @JsonAlias(value = "exp_date")
    private String expDate;

    @JsonAlias(value = "is_default_account")
    private boolean defaultAccount;
}
