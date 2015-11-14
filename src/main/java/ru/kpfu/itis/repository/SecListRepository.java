package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.SecList;

@Repository
public interface SecListRepository extends JpaRepository<SecList, Long>{

}
