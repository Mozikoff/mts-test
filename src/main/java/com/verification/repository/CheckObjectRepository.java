package com.verification.repository;

import com.verification.entity.CheckStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Calendar;

@Repository
public class CheckObjectRepository {

    private final JdbcTemplate jdbcTemplate;
    private final Date currentDate = new Date(Calendar.getInstance().getTime().getTime());

    private final String NOT_UNIQUE_COUNT_SQL = "SELECT COUNT(*) FROM \n" +
            "\t(SELECT ID, INT_VALUE FROM CHECK_OBJECT\n" +
            "    WHERE LOAD_DATE = ?\n" +
            "    GROUP BY ID, INT_VALUE\n" +
            "    HAVING COUNT(*) > 1) A";
    private final String ROW_COUNT_SQL = "SELECT COUNT(*) FROM CHECK_OBJECT WHERE LOAD_DATE = ?";

    private final String INT_NULL_COUNT_SQL = "SELECT COUNT(*) FROM CHECK_OBJECT WHERE LOAD_DATE = ? AND INT_VALUE IS NULL";
    private final String FLOAT_NULL_COUNT_SQL = "SELECT COUNT(*) FROM CHECK_OBJECT WHERE LOAD_DATE = ? AND FLOAT_VALUE IS NULL";
    private final String CHAR_NULL_COUNT_SQL = "SELECT COUNT(*) FROM CHECK_OBJECT WHERE LOAD_DATE = ? AND CHAR_VALUE IS NULL";
    private final String DATE_NULL_COUNT_SQL = "SELECT COUNT(*) FROM CHECK_OBJECT WHERE LOAD_DATE = ? AND DATE_VALUE IS NULL";

    private final String INT_ZERO_COUNT_SQL = "SELECT COUNT(*) FROM CHECK_OBJECT WHERE LOAD_DATE = ? AND INT_VALUE = 0";
    private final String FLOAT_ZERO_COUNT_SQL = "SELECT COUNT(*) FROM CHECK_OBJECT WHERE LOAD_DATE = ? AND FLOAT_VALUE = 0";
    private final String CHAR_ZERO_COUNT_SQL = "SELECT COUNT(*) FROM CHECK_OBJECT WHERE LOAD_DATE = ? AND CHAR_VALUE  = 0";
    private final String DATE_ZERO_COUNT_SQL = "SELECT COUNT(*) FROM CHECK_OBJECT WHERE LOAD_DATE = ? AND DATE_VALUE = 0";

    private final String INT_AVG_SQL = "SELECT AVG(INT_VALUE) FROM CHECK_OBJECT WHERE LOAD_DATE = ?";
    private final String FLOAT_AVG_SQL = "SELECT AVG(FLOAT_VALUE) FROM CHECK_OBJECT WHERE LOAD_DATE = ?";
    private final String CHAR_AVG_SQL = "SELECT AVG(CHAR_VALUE) FROM CHECK_OBJECT WHERE LOAD_DATE = ?";
    private final String DATE_AVG_SQL = "SELECT AVG(DATE_VALUE) FROM CHECK_OBJECT WHERE LOAD_DATE = ?";

    public CheckObjectRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public CheckStatus getStatistics() {
        Integer notUniqueCount = jdbcTemplate.queryForObject(NOT_UNIQUE_COUNT_SQL, Integer.class, currentDate);
        Integer rowCount = jdbcTemplate.queryForObject(ROW_COUNT_SQL, Integer.class, currentDate);
        Integer intNullCount = jdbcTemplate.queryForObject(INT_NULL_COUNT_SQL, Integer.class, currentDate);
        Integer floatNullCount = jdbcTemplate.queryForObject(FLOAT_NULL_COUNT_SQL, Integer.class, currentDate);
        Integer charNullCount = jdbcTemplate.queryForObject(CHAR_NULL_COUNT_SQL, Integer.class, currentDate);
        Integer dateNullCount = jdbcTemplate.queryForObject(DATE_NULL_COUNT_SQL, Integer.class, currentDate);
        Integer intZeroCount = jdbcTemplate.queryForObject(INT_ZERO_COUNT_SQL, Integer.class, currentDate);
        Integer floatZeroCount = jdbcTemplate.queryForObject(FLOAT_ZERO_COUNT_SQL, Integer.class, currentDate);
        Integer charZeroCount = jdbcTemplate.queryForObject(CHAR_ZERO_COUNT_SQL, Integer.class, currentDate);
        Integer dateZeroCount = jdbcTemplate.queryForObject(DATE_ZERO_COUNT_SQL, Integer.class, currentDate);
        Integer intAvg = jdbcTemplate.queryForObject(INT_AVG_SQL, Integer.class, currentDate);
        Integer floatAvg = jdbcTemplate.queryForObject(FLOAT_AVG_SQL, Integer.class, currentDate);
        Integer charAvg = jdbcTemplate.queryForObject(CHAR_AVG_SQL, Integer.class, currentDate);
        Integer dateAvg = jdbcTemplate.queryForObject(DATE_AVG_SQL, Integer.class, currentDate);

        return CheckStatus.newBuilder()
                .setNotUniqueCnt(notUniqueCount)
                .setRowCount(rowCount)
                .setIntValNullCnt(intNullCount)
                .setFloatValNullCnt(floatNullCount)
                .setCharValNullCnt(charNullCount)
                .setDateValNullCnt(dateNullCount)
                .setIntValZeroCnt(intZeroCount)
                .setFloatValZeroCnt(floatZeroCount)
                .setCharValZeroCnt(charZeroCount)
                .setDateValZeroCnt(dateZeroCount)
                .setIntValAvg(intAvg)
                .setFloatValAvg(floatAvg)
                .setCharValAvg(charAvg)
                .setDateValAvg(dateAvg).build();
    }


}
