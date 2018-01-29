package com.verification.repository;

import com.verification.entity.CheckStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Calendar;

@Repository
public class CheckStatusRepository {

    private final JdbcTemplate jdbcTemplate;
    private final String SQL = "INSERT INTO CHECK_STATUS(DATE, NOT_UNIQUE_CNT, ROW_COUNT, " +
            "INT_VAL_NULL_CNT, FLOAT_VAL_NULL_CNT, CHAR_VAL_NULL_CNT, DATE_VAL_NULL_CNT," +
            "INT_VAL_ZERO_CNT, FLOAT_VAL_ZERO_CNT," +
            "INT_VAL_AVG, FLOAT_VAL_AVG) " +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

    public CheckStatusRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addStatus(CheckStatus checkStatus) {
        jdbcTemplate.update(SQL, new Date(Calendar.getInstance().getTime().getTime()),
                checkStatus.getNotUniqueCnt(), checkStatus.getRowCount(),
                checkStatus.getIntValNullCnt(), checkStatus.getFloatValNullCnt(), checkStatus.getCharValNullCnt(), checkStatus.getDateValNullCnt(),
                checkStatus.getIntValZeroCnt(), checkStatus.getFloatValZeroCnt(),
                checkStatus.getIntValAvg(), checkStatus.getFloatValAvg());

    }
}
