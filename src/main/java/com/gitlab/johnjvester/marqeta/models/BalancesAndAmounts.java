package com.gitlab.johnjvester.marqeta.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.math.BigDecimal;

@Data
public abstract class BalancesAndAmounts {
    @JsonAlias(value = "ledger_balance")
    private BigDecimal ledgerBalance;

    @JsonAlias(value = "available_balance")
    private BigDecimal availableBalance;

    @JsonAlias(value = "credit_balance")
    private BigDecimal creditBalance;

    @JsonAlias(value = "pending_credits")
    private BigDecimal pendingCredits;

    @JsonAlias(value = "impacted_amount")
    private BigDecimal impactedAmount;
}
