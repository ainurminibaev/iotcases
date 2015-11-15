package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.Action;

/**
 * Created by vlad on 15.11.15.
 */
@Repository
public interface Logger extends JpaRepository<Action, Long> {


}
