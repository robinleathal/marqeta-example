package com.gitlab.johnjvester.marqeta.models.responses;

import com.gitlab.johnjvester.marqeta.models.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MarqetaTransactionPostResponse {
    private Transaction transaction;
    private Object raw_iso8583;
}
