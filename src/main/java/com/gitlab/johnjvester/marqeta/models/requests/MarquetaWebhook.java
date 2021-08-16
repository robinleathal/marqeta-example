package com.gitlab.johnjvester.marqeta.models.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MarquetaWebhook {
    private String endpoint;
    private String username;
    private String password;
}
