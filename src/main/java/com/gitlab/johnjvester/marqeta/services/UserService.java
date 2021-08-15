package com.gitlab.johnjvester.marqeta.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gitlab.johnjvester.marqeta.configs.MarqetaConfigurationProperties;
import com.gitlab.johnjvester.marqeta.models.User;
import com.gitlab.johnjvester.marqeta.models.responses.MarqetaUserResponse;
import com.gitlab.johnjvester.marqeta.utils.MarqetaUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    private final MarqetaConfigurationProperties marqetaConfigurationProperties;
    private final ObjectMapper objectMapper;

    public List<User> getAllUsers() throws Exception {
        HttpResponse httpResponse = MarqetaUtils.marqetaGet(marqetaConfigurationProperties, "/users", null);
        HttpEntity httpEntity = httpResponse.getEntity();

        if (httpEntity != null) {
            MarqetaUserResponse marqetaUserResponse = objectMapper.readValue(EntityUtils.toString(httpEntity), MarqetaUserResponse.class);

            if (marqetaUserResponse != null) {
                return marqetaUserResponse.getUsers();
            }
        }

        return new ArrayList<>();
    }
}
