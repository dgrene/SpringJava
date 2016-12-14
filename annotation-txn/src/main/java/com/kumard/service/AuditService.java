package com.kumard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by deepak on 14/12/16.
 */
public class AuditService {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void writeAuditLog(String message) {
        String query = "insert into auditlogs(logmessage) values(?) ";

        jdbcTemplate.update(query, message);
    }
}
