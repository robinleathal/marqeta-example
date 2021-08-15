package com.gitlab.johnjvester.marqeta.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.sql.Timestamp;

@Data
public abstract class Base {
    private String token;

    @JsonAlias(value = "created_time")
    private Timestamp createdTime;

    @JsonAlias(value = "last_modified_time")
    private Timestamp lastModifiedTime;

    private Object metadata;
}
