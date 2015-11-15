package ru.kpfu.itis.service;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Action;

import java.util.List;

/**
 * Created by vlad on 15.11.15.
 */
@Service
public interface LogService {

    public void save(Action action);

    public List<Action> findAll();

    void save(List<Action> actions);
}
