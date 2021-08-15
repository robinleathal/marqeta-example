package com.gitlab.johnjvester.marqeta.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Transaction extends Base {
    private String type;
    private String state;
    private String identifier;

    @JsonAlias(value = "user_token")
    private String userToken;

    @JsonAlias(value = "acting_user_token")
    private String actingUserToken;

    @JsonAlias(value = "card_token")
    private String cardToken;

    private GeneralPurposeAccount gpa;

    @JsonAlias(value = "gpa_order")
    private GeneralPurposeAccountOrder gpaOrder;

    private int duration;

    @JsonAlias(value = "user_transaction_time")
    private Timestamp userTransactionTime;

    @JsonAlias(value = "settlement_date")
    private Timestamp settlementDate;

    @JsonAlias(value = "request_amount")
    private BigDecimal requestAmount;

    private BigDecimal amount;

    @JsonAlias(value = "issuer_interchange_amount")
    private BigDecimal issuerInterchangeAmount;

    @JsonAlias(value = "issuer_received_time")
    private Timestamp issuerReceivedTime;

    @JsonAlias(value = "issuer_payment_node")
    private String issuerPaymentNode;

    @JsonAlias(value = "network_reference_id")
    private String networkReferenceId;

    @JsonAlias(value = "currency_code")
    private String currencyCode;

    @JsonAlias(value = "approval_code")
    private String approvalCode;

    private TransactionResponse response;
    private String network;
    private String subnetwork;
    private Acquirer acquirer;

    @JsonAlias(value = "acquirer_fee_amount")
    private BigDecimal acquirerFeeAmount;

    private TransactionUser user;
    private TransactionCard card;

    @JsonAlias(value = "card_acceptor")
    private CardAcceptor cardAcceptor;

    private PointOfSale pos;
}
