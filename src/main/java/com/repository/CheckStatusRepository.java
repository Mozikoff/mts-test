package com.repository;

import com.entity.CheckStatus;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Date;
import java.util.Calendar;

public class CheckStatusRepository {

    private final JdbcTemplate jdbcTemplate;
    private final String sql = "INSERT INTO check_status(date, not_unique_cnt, row_count, " +
            "int_val_null_cnt, float_val_null_cnt, char_val_null_cnt, date_val_null_cnt," +
            "int_val_zero_cnt, float_val_zero_cnt, char_val_zero_cnt, date_val_zero_cnt," +
            "int_val_avg, float_val_avg, char_val_avg, date_val_avg) " +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public CheckStatusRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addStatus(CheckStatus checkStatus) {
        jdbcTemplate.update(sql, new Date(Calendar.getInstance().getTime().getTime()),
                checkStatus.getNotUniqueCnt(), checkStatus.getRowCount(),
                checkStatus.getIntValNullCnt(), checkStatus.getFloatValNullCnt(), checkStatus.getCharValNullCnt(), checkStatus.getDateValNullCnt(),
                checkStatus.getIntValZeroCnt(), checkStatus.getFloatValZeroCnt(), checkStatus.getCharValZeroCnt(), checkStatus.getDateValZeroCnt(),
                checkStatus.getIntValAvg(), checkStatus.getFloatValAvg(), checkStatus.getCharValAvg(), checkStatus.getDateValAvg());

    }
}
