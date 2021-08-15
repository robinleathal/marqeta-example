package com.gitlab.johnjvester.marqeta.utils;

import com.gitlab.johnjvester.marqeta.configs.MarqetaConfigurationProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.MediaType;

import java.util.List;

@Slf4j
public final class MarqetaUtils {
    private MarqetaUtils() { }

    public static HttpResponse marqetaGet(MarqetaConfigurationProperties marqetaConfigurationProperties, String contextUrl, List<NameValuePair> nameValuePairs) throws Exception {
        CloseableHttpClient closeableHttpClient = getCloseableHttpClient(marqetaConfigurationProperties);

        URIBuilder uriBuilder = new URIBuilder(HttpUtils.createBaseUrl(marqetaConfigurationProperties.getHostname(), marqetaConfigurationProperties.isSecure()));
        uriBuilder.setPath(marqetaConfigurationProperties.getBaseUri() + contextUrl);

        if (CollectionUtils.isNotEmpty(nameValuePairs)) {
            uriBuilder.setParameters(nameValuePairs);
        }

        log.debug("GET url={}", uriBuilder.build().toString());

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        httpGet.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
        HttpUtils.checkResponse(httpResponse);

        return httpResponse;
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
}
