package com.lolmaxlevel.weblab4server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AttemptsCountResponse (
    @JsonProperty("count") int count)
{
}

