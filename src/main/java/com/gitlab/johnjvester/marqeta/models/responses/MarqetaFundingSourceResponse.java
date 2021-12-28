package com.gitlab.johnjvester.marqeta.models.responses;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.gitlab.johnjvester.marqeta.models.FundingSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class MarqetaFundingSourceResponse extends MarqetaResponse {
    @JsonAlias(value = "data")
    private List<FundingSource> fundingSources = new ArrayList<>();
}
