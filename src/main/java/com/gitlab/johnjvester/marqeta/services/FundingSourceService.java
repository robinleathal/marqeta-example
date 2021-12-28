package com.gitlab.johnjvester.marqeta.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gitlab.johnjvester.marqeta.configs.MarqetaConfigurationProperties;
import com.gitlab.johnjvester.marqeta.models.PaymentCard;
import com.gitlab.johnjvester.marqeta.models.responses.MarqetaPaymentCardResponse;
import com.gitlab.johnjvester.marqeta.utils.MarqetaUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
@Service
public class FundingSourceService {
    private final MarqetaConfigurationProperties marqetaConfigurationProperties;
    private final ObjectMapper objectMapper;

    public List<PaymentCard> getPaymentCardsByUserToken(String userToken) throws Exception {
        try (CloseableHttpResponse closeableHttpResponse = MarqetaUtils.marqetaGet(marqetaConfigurationProperties, "/fundingsources/user/" + userToken, null)) {
            HttpEntity httpEntity = closeableHttpResponse.getEntity();

            if (httpEntity != null) {
                MarqetaPaymentCardResponse marqetaFundingSourceResponse = objectMapper.readValue(EntityUtils.toString(httpEntity), MarqetaPaymentCardResponse.class);

                if (marqetaFundingSourceResponse != null) {
                    return marqetaFundingSourceResponse.getPaymentCards();
                }
            }

            return new ArrayList<>();
        }
    }

    public PaymentCard getPaymentCardByPaymentCardToken(String paymentCardToken) throws Exception {
        try (CloseableHttpResponse closeableHttpResponse = MarqetaUtils.marqetaGet(marqetaConfigurationProperties, "/fundingsources/paymentcard/" + paymentCardToken, null)) {
            HttpEntity httpEntity = closeableHttpResponse.getEntity();

            if (httpEntity != null) {
                return objectMapper.readValue(EntityUtils.toString(httpEntity), PaymentCard.class);
            }

            throw new NoSuchElementException("Could not locate paymentCardToken=" + paymentCardToken);
        }
    }
}
