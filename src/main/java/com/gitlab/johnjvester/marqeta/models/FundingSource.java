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
public class FundingSource extends Base {
    private String type;
    private boolean active;
    private String name;

    @JsonAlias(value = "is_default_account")
    private boolean defaultAccount;
}
