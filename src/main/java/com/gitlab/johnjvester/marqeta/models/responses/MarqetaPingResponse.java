package com.gitlab.johnjvester.marqeta.models.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MarqetaPingResponse {
    private boolean success;
    private String version;
    private String revision;
    private String timestamp;
    private String env;
    private String id;
}
