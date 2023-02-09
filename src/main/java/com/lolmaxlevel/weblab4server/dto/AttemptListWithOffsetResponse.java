package com.lolmaxlevel.weblab4server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lolmaxlevel.weblab4server.model.Attempt;

import java.util.List;

public record AttemptListWithOffsetResponse(
        @JsonProperty("attempts") List<Attempt> attempts,
        @JsonProperty("has_more") boolean hasMore)
{
}

