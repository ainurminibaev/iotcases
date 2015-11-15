package ru.kpfu.itis.service;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.model.Action;
import ru.kpfu.itis.model.helper.ActionJson;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by vlad on 15.11.15.
 */
public interface LogService {

    public void save(Action action);

    public List<Action> findAll();
}
