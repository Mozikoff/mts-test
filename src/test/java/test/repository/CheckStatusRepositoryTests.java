package test.repository;

import com.verification.entity.CheckStatus;
import com.verification.mapper.CheckStatusMapper;
import com.verification.repository.CheckStatusRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class CheckStatusRepositoryTests {

    private static final Logger log = LoggerFactory.getLogger(CheckObjectRepositoryTests.class);

    private CheckStatusRepository repository;
    private JdbcTemplate jdbcTemplate;
    private EmbeddedDatabase db;

    private final String CREATE_DB_SQL = "db/sql/create-db.sql";
    private final String SELECT_ALL = "SELECT * FROM CHECK_STATUS";

    @Before
    public void setUp() {
        db = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript(CREATE_DB_SQL)
                .build();
        jdbcTemplate = new JdbcTemplate(db);
        repository = new CheckStatusRepository(jdbcTemplate);
    }

    @Test
    public void addStatusPositiveTest() throws SQLException {
        log.info("Trying to insert data into DB:");
        CheckStatus expected = CheckStatus.newBuilder()
                .setNotUniqueCnt(1)
                .setRowCount(2)
                .setIntValNullCnt(3)
                .setFloatValNullCnt(4)
                .setCharValNullCnt(5)
                .setDateValNullCnt(6)
                .setIntValZeroCnt(7)
                .setFloatValZeroCnt(8)
                .setIntValAvg(9.9f)
                .setFloatValAvg(11.1f)
                .build();
        repository.addStatus(expected);
        log.info("Status row has been added. Comparing results:");
        CheckStatus actual = (CheckStatus) jdbcTemplate.queryForObject(SELECT_ALL, new CheckStatusMapper());
        assertTrue("Add status positive test failed!", actual.equals(expected));
    }

    @After
    public void tearDown() {
        db.shutdown();
    }
}
