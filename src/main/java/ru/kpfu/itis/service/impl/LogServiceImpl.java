package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Action;
import ru.kpfu.itis.repository.LoggerRepository;
import ru.kpfu.itis.service.LogService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by vlad on 15.11.15.
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LoggerRepository loggerRepository;

    @Override
    @Transactional
    public void save(Action action) {
        loggerRepository.save(action);
    }

    @Override
    public List<Action> findAll() {
        return loggerRepository.findAll();
    }

    @Override
    @Transactional
    public void save(List<Action> actions) {
        loggerRepository.save(actions);
    }
}
