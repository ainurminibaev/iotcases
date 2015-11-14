package ru.jblab.iotcases.util;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class DataSourceAdapter extends JdbcDaoSupport {

    public DataSourceAdapter() {
    }

    public <T> T query(String sql, ResultSetExtractor<T> rse) throws DataAccessException {
        return getJdbcTemplate().query(sql, rse);
    }

    public void query(String sql, RowCallbackHandler rch) throws DataAccessException {
        getJdbcTemplate().query(sql, rch);
    }

    public <T> List<T> query(String sql, RowMapper<T> rowMapper) throws DataAccessException {
        return getJdbcTemplate().query(sql, rowMapper);
    }
}