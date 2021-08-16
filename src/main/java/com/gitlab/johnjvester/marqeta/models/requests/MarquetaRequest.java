package com.gitlab.johnjvester.marqeta.models.requests;

import lombok.Data;

@Data
public abstract class MarquetaRequest {
    private MarquetaWebhook webhook;
}
