package com.gitlab.johnjvester.marqeta.models.responses;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public abstract class MarqetaResponse {
    private int count;

    @JsonAlias(value = "start_index")
    private int startIndex;

    @JsonAlias(value = "end_index")
    private int endIndex;

    @JsonAlias(value = "is_more")
    private boolean more;
}
