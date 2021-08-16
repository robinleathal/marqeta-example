package com.gitlab.johnjvester.marqeta.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gitlab.johnjvester.marqeta.configs.MarqetaConfigurationProperties;
import com.gitlab.johnjvester.marqeta.models.requests.MarqetaTransactionRequest;
import com.gitlab.johnjvester.marqeta.models.responses.MarqetaTransactionPostResponse;
import com.gitlab.johnjvester.marqeta.utils.MarqetaUtils;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthorizationService {
    private final MarqetaConfigurationProperties marqetaConfigurationProperties;
    private final ObjectMapper objectMapper;

    public MarqetaTransactionPostResponse postTransaction(MarqetaTransactionRequest request) throws Exception {
        try (CloseableHttpResponse closeableHttpResponse = MarqetaUtils.marqetaPost(marqetaConfigurationProperties, "/simulate/authorization", null, objectMapper.writeValueAsString(request))) {
            HttpEntity httpEntity = closeableHttpResponse.getEntity();

            if (httpEntity != null) {
                return objectMapper.readValue(EntityUtils.toString(httpEntity), MarqetaTransactionPostResponse.class);
            }

            return null;
        }
    }
}
