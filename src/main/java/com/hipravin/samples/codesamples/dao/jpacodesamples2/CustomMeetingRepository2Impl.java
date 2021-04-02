package com.hipravin.samples.codesamples.dao.jpacodesamples2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

public class CustomMeetingRepository2Impl implements CustomMeetingRepository2 {

    final JdbcTemplate jdbcTemplate;


    public CustomMeetingRepository2Impl(@Qualifier("jdbcTemplateCodesamples2") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long some2() {

        return jdbcTemplate.queryForObject("select count(1) from meetings", Long.class);
//        return 578;
    }
}
