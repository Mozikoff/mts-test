package com.verification.mapper;

import com.verification.entity.CheckStatus;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckStatusMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        CheckStatus status = CheckStatus.newBuilder()
                .setNotUniqueCnt(rs.getInt("NOT_UNIQUE_CNT"))
                .setRowCount(rs.getInt("ROW_COUNT"))
                .setIntValNullCnt(rs.getInt("INT_VAL_NULL_CNT"))
                .setFloatValNullCnt(rs.getInt("FLOAT_VAL_NULL_CNT"))
                .setCharValNullCnt(rs.getInt("CHAR_VAL_NULL_CNT"))
                .setDateValNullCnt(rs.getInt("DATE_VAL_NULL_CNT"))
                .setIntValZeroCnt(rs.getInt("INT_VAL_ZERO_CNT"))
                .setFloatValZeroCnt(rs.getInt("FLOAT_VAL_ZERO_CNT"))
                .setIntValAvg(rs.getFloat("INT_VAL_AVG"))
                .setFloatValAvg(rs.getFloat("FLOAT_VAL_AVG"))
                .build();
        return status;
    }
}
