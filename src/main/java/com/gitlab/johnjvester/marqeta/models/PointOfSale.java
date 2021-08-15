package com.gitlab.johnjvester.marqeta.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PointOfSale {
    @JsonAlias(value = "pin_present")
    private boolean pinPresent;

    @JsonAlias(value = "partial_approval_capable")
    private boolean partialApprovalCapable;

    @JsonAlias(value = "purchase_amount_only")
    private boolean purchaseAmountOnly;

    @JsonAlias(value = "is_recurring")
    private boolean recurring;

    @JsonAlias(value = "is_installment")
    private boolean installment;

}
