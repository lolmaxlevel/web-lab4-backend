package com.lolmaxlevel.weblab4server.service.attempt;

import com.lolmaxlevel.weblab4server.repository.AttemptsRepository;
import com.lolmaxlevel.weblab4server.service.logic.AttemptConvertor;
import com.lolmaxlevel.weblab4server.dto.AddAttemptRequest;
import com.lolmaxlevel.weblab4server.model.Attempt;
import com.lolmaxlevel.weblab4server.service.logic.AreaChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AttemptServiceImpl implements AttemptService {
    private static final Logger log = LoggerFactory.getLogger(AttemptServiceImpl.class);

    private final AttemptsRepository attemptsRepository;

    public AttemptServiceImpl(AttemptsRepository attemptsRepository) {
        this.attemptsRepository = attemptsRepository;
    }

    @Override
    public Attempt addAttempt(AddAttemptRequest addAttemptRequest) {
        final long startProcessingTime = System.nanoTime();
        final Attempt attempt = AttemptConvertor.convertToEntity(addAttemptRequest, AreaChecker.checkArea(addAttemptRequest));
        attempt.setAttemptTime(LocalDateTime.now());
        attempt.setProcessingTimeNanos(System.nanoTime() - startProcessingTime);
        // save the attempt and return the newly added entity
        return attemptsRepository.save(attempt);
    }

    @Override
    public void removeAll() {
        attemptsRepository.deleteAll();
    }

    @Override
    public List<Attempt> getPartAttempts(int offset, int size) {
        try {
            return attemptsRepository.getPartAttempts(offset, size);
        } catch (Exception e) {
            log.error("Error while getting part of attempts", e);
            return List.of();
        }
    }
    @Override
    public int getAttemptsCount() {
        return attemptsRepository.getAttemptsCount();
    }

}

