package com.gitlab.johnjvester.marqeta.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends Base {
    private boolean active;

    @JsonAlias(value = "first_name")
    private String firstName;

    @JsonAlias(value = "last_name")
    private String lastName;

    @JsonAlias(value = "uses_parent_account")
    private boolean usersParentAccount;

    @JsonAlias(value = "corporate_card_holder")
    private boolean corporateCardHolder;

    @JsonAlias(value = "account_holder_group_token")
    private String accountHolderGroupToken;

    private String status;
}
