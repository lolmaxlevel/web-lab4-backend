package com.lolmaxlevel.weblab4server.service.logic;

import com.lolmaxlevel.weblab4server.dto.AddAttemptRequest;
import com.lolmaxlevel.weblab4server.model.Attempt;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AttemptConvertor {
    public static Attempt convertToEntity(AddAttemptRequest addAttemptRequest, boolean result) {
        return new Attempt(addAttemptRequest.x(), addAttemptRequest.y(), addAttemptRequest.r(), result);
    }
}
