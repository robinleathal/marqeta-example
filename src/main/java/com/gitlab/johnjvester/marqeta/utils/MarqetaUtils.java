package com.gitlab.johnjvester.marqeta.utils;

import com.gitlab.johnjvester.marqeta.configs.MarqetaConfigurationProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.MediaType;

import java.util.List;

@Slf4j
public final class MarqetaUtils {
    private MarqetaUtils() { }

    public static CloseableHttpResponse marqetaGet(MarqetaConfigurationProperties marqetaConfigurationProperties, String contextUrl, List<NameValuePair> nameValuePairs) throws Exception {
        CloseableHttpClient closeableHttpClient = getCloseableHttpClient(marqetaConfigurationProperties);
        URIBuilder uriBuilder = createUriBuilder(marqetaConfigurationProperties, contextUrl, nameValuePairs);

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        httpGet.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet);
        HttpUtils.checkResponse(closeableHttpResponse);
        return closeableHttpResponse;
    }

    public static CloseableHttpResponse marqetaPost(MarqetaConfigurationProperties marqetaConfigurationProperties, String contextUrl, List<NameValuePair> nameValuePairs, String requestBody) throws Exception {
        CloseableHttpClient closeableHttpClient = getCloseableHttpClient(marqetaConfigurationProperties);
        URIBuilder uriBuilder = createUriBuilder(marqetaConfigurationProperties, contextUrl, nameValuePairs);

        HttpPost httpPost = new HttpPost(uriBuilder.build());
        httpPost.setHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        httpPost.setEntity(new StringEntity(requestBody));

        CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpPost);
        HttpUtils.checkResponse(closeableHttpResponse);
        return closeableHttpResponse;
    }

    private static CloseableHttpClient getCloseableHttpClient(MarqetaConfigurationProperties marqetaConfigurationProperties) {
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(marqetaConfigurationProperties.getApplicationToken(),
                marqetaConfigurationProperties.getAdminAccessToken());
        credentialsProvider.setCredentials(AuthScope.ANY, credentials);

        HttpClientBuilder httpClientBuilder = HttpClients.custom();
        httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);

        return httpClientBuilder.build();
    }

    private static URIBuilder createUriBuilder(MarqetaConfigurationProperties marqetaConfigurationProperties, String contextUrl, List<NameValuePair> nameValuePairs) throws Exception {
        URIBuilder uriBuilder = new URIBuilder(HttpUtils.createBaseUrl(marqetaConfigurationProperties.getHostname(), marqetaConfigurationProperties.isSecure()));
        uriBuilder.setPath(marqetaConfigurationProperties.getBaseUri() + contextUrl);

        if (CollectionUtils.isNotEmpty(nameValuePairs)) {
            uriBuilder.setParameters(nameValuePairs);
        }

        log.debug("uriBuilder.build()={}", uriBuilder.build().toString());
        return uriBuilder;
    }
}
