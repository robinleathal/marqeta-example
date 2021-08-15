package com.gitlab.johnjvester.marqeta.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gitlab.johnjvester.marqeta.configs.MarqetaConfigurationProperties;
import com.gitlab.johnjvester.marqeta.models.Card;
import com.gitlab.johnjvester.marqeta.models.responses.MarqetaCardResponse;
import com.gitlab.johnjvester.marqeta.utils.MarqetaUtils;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CardService {
    private final MarqetaConfigurationProperties marqetaConfigurationProperties;
    private final ObjectMapper objectMapper;

    public List<Card> getCardsByUserToken(String userToken) throws Exception {
        HttpResponse httpResponse = MarqetaUtils.marqetaGet(marqetaConfigurationProperties, "/cards/user/" + userToken, null);
        HttpEntity httpEntity = httpResponse.getEntity();

        if (httpEntity != null) {
            MarqetaCardResponse marqetaCardResponse = objectMapper.readValue(EntityUtils.toString(httpEntity), MarqetaCardResponse.class);

            if (marqetaCardResponse != null) {
                return marqetaCardResponse.getCards();
            }
        }

        return new ArrayList<>();
    }
}
