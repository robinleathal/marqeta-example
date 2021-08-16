package com.gitlab.johnjvester.marqeta.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gitlab.johnjvester.marqeta.configs.MarqetaConfigurationProperties;
import com.gitlab.johnjvester.marqeta.models.Transaction;
import com.gitlab.johnjvester.marqeta.models.responses.MarqetaTransactionResponse;
import com.gitlab.johnjvester.marqeta.utils.MarqetaUtils;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TransactionService {
    private final MarqetaConfigurationProperties marqetaConfigurationProperties;
    private final ObjectMapper objectMapper;

    public List<Transaction> getTransactionsByUserToken(String userToken) throws Exception {
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("user_token", userToken));

        try (CloseableHttpResponse closeableHttpResponse = MarqetaUtils.marqetaGet(marqetaConfigurationProperties, "/transactions", nameValuePairs)) {
            HttpEntity httpEntity = closeableHttpResponse.getEntity();

            if (httpEntity != null) {
                MarqetaTransactionResponse marqetaTransactionResponse = objectMapper.readValue(EntityUtils.toString(httpEntity), MarqetaTransactionResponse.class);

                if (marqetaTransactionResponse != null) {
                    return marqetaTransactionResponse.getTransactions();
                }
            }

            return new ArrayList<>();
        }
    }

}
