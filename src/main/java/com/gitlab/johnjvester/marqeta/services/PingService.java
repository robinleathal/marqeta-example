package com.gitlab.johnjvester.marqeta.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gitlab.johnjvester.marqeta.configs.MarqetaConfigurationProperties;
import com.gitlab.johnjvester.marqeta.models.responses.MarqetaPingResponse;
import com.gitlab.johnjvester.marqeta.utils.MarqetaUtils;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PingService {
    private final MarqetaConfigurationProperties marqetaConfigurationProperties;
    private final ObjectMapper objectMapper;

    public MarqetaPingResponse ping() throws Exception {
        try (CloseableHttpResponse closeableHttpResponse = MarqetaUtils.marqetaGet(marqetaConfigurationProperties, "/ping", null)) {
            HttpEntity httpEntity = closeableHttpResponse.getEntity();

            if (httpEntity != null) {
                return objectMapper.readValue(EntityUtils.toString(httpEntity), MarqetaPingResponse.class);
            }

            throw new Exception("An error occurred attempting to ping the Marqeta service");
        }
    }
}
