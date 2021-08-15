package com.gitlab.johnjvester.marqeta.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;

@Slf4j
public final class HttpUtils {
    private HttpUtils() { }

    public static void checkResponse(HttpResponse httpResponse) throws Exception {
        log.debug("httpResponse.getStatusLine().getStatusCode()={}", httpResponse.getStatusLine().getStatusCode());

        // Simple validation to make sure the response is 2xx.
        if (httpResponse.getStatusLine().getStatusCode() < 200
                || httpResponse.getStatusLine().getStatusCode() > 299) {
            throw new Exception(httpResponse.getStatusLine().getReasonPhrase());
        }
    }

    public static String createBaseUrl(String hostname, boolean isSecure) {
        StringBuilder stringBuilder = new StringBuilder();

        if (isSecure) {
            stringBuilder.append("https://");
        } else {
            stringBuilder.append("http://");
        }

        stringBuilder.append(hostname);

        log.debug("createBaseUrl={}", stringBuilder);
        return stringBuilder.toString();
    }
}

