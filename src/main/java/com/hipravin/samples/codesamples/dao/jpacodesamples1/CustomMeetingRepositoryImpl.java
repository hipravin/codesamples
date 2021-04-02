package com.hipravin.samples.codesamples.dao.jpacodesamples1;

import org.springframework.jdbc.core.JdbcTemplate;

public class CustomMeetingRepositoryImpl implements CustomMeetingRepository {

    final JdbcTemplate jdbcTemplate;

    public CustomMeetingRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int some() {

        return jdbcTemplate.queryForObject("select count(1) from meetings", Long.class).intValue();
//        return 578;
    }
}
