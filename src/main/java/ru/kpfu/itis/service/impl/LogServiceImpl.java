package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Action;
import ru.kpfu.itis.repository.Logger;
import ru.kpfu.itis.service.LogService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by vlad on 15.11.15.
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    Logger logger;

    @Override
    @Transactional
    public void save(Action action) {
        logger.save(action);
    }

    @Override
    public List<Action> findAll() {
        return logger.findAll();
    }

    @Override
    @Transactional
    public void save(List<Action> actions) {
        logger.save(actions);
    }
}
