package com.lolmaxlevel.weblab4server.service.attempt;

import com.lolmaxlevel.weblab4server.dto.AddAttemptRequest;
import com.lolmaxlevel.weblab4server.model.Attempt;

import java.util.List;

public interface AttemptService {
    Attempt addAttempt(AddAttemptRequest addAttemptRequest);

    void removeAll();

    List<Attempt> getPartAttempts(int offset, int size);
    int getAttemptsCount();
}

