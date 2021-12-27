package com.gitlab.johnjvester.marqeta.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gitlab.johnjvester.marqeta.configs.MarqetaConfigurationProperties;
import com.gitlab.johnjvester.marqeta.models.User;
import com.gitlab.johnjvester.marqeta.models.responses.MarqetaUserResponse;
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
public class UserService {
    private final MarqetaConfigurationProperties marqetaConfigurationProperties;
    private final ObjectMapper objectMapper;

    public List<User> getAllUsers() throws Exception {
        try (CloseableHttpResponse closeableHttpResponse = MarqetaUtils.marqetaGet(marqetaConfigurationProperties, "/users", null)) {
            HttpEntity httpEntity = closeableHttpResponse.getEntity();

            if (httpEntity != null) {
                MarqetaUserResponse marqetaUserResponse = objectMapper.readValue(EntityUtils.toString(httpEntity), MarqetaUserResponse.class);

                if (marqetaUserResponse != null) {
                    return marqetaUserResponse.getUsers();
                }
            }

            return new ArrayList<>();
        }
    }

    public User getUserByToken(String userToken) throws Exception {
        try (CloseableHttpResponse closeableHttpResponse = MarqetaUtils.marqetaGet(marqetaConfigurationProperties, "/users/" + userToken, null)) {
            HttpEntity httpEntity = closeableHttpResponse.getEntity();

            if (httpEntity != null) {
                return objectMapper.readValue(EntityUtils.toString(httpEntity), User.class);
            }

            throw new NoSuchElementException("Could not locate userToken=" + userToken);
        }
    }
}
