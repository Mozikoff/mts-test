package test.repository;

import com.verification.Application;
import com.verification.entity.CheckStatus;
import com.verification.repository.CheckObjectRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@JdbcTest
@SpringBootTest(classes = Application.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class CheckObjectRepositoryTests {

    private static final Logger log = LoggerFactory.getLogger(CheckObjectRepositoryTests.class);
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private CheckObjectRepository repository;
    private JdbcTemplate jdbcTemplate;
    private EmbeddedDatabase db;


    private final String CREATE_DB_SQL = "db/sql/create-db.sql";
    private final String AVERAGE_TEST_SQL = "db/sql/average.sql";
    private final String DUPLICATES_TEST_SQL = "db/sql/duplicates.sql";
    private final String NULL_TEST_SQL = "db/sql/nulls.sql";
    private final String ZEROS_TEST_SQL = "db/sql/zeros.sql";
    private final String NO_DATA_SQL = "db/sql/no-data.sql";

    @Before
    public void setUp() {
        db = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript(CREATE_DB_SQL)
                .build();
        jdbcTemplate = new JdbcTemplate(db);
        repository = new CheckObjectRepository(jdbcTemplate);
    }

    @Test
    public void getStatisticsAverageTest() throws SQLException {
        ScriptUtils.executeSqlScript(jdbcTemplate.getDataSource().getConnection(), new ClassPathResource(AVERAGE_TEST_SQL));
        CheckStatus actual = repository.getStatistics();
        log.info("Statistics from DB:");
        log.info(actual.toString());
        assertTrue("Averages test failed!",
                actual.equals(CheckStatus.newBuilder()
                .setNotUniqueCnt(1)
                .setRowCount(3)
                .setIntValNullCnt(0)
                .setFloatValNullCnt(0)
                .setCharValNullCnt(0)
                .setDateValNullCnt(0)
                .setIntValZeroCnt(0)
                .setFloatValZeroCnt(0)
                .setIntValAvg(2.67f)
                .setFloatValAvg(3.61f)
                .build()));
    }

    @Test
    public void getStatisticsDuplicateTest() throws SQLException {
        ScriptUtils.executeSqlScript(jdbcTemplate.getDataSource().getConnection(), new ClassPathResource(DUPLICATES_TEST_SQL));
        CheckStatus actual = repository.getStatistics();
        log.info("Statistics from DB:");
        log.info(actual.toString());
        assertTrue("Duplicates test failed!",
                actual.equals(CheckStatus.newBuilder()
                .setNotUniqueCnt(1)
                .setRowCount(3)
                .setIntValNullCnt(0)
                .setFloatValNullCnt(0)
                .setCharValNullCnt(0)
                .setDateValNullCnt(0)
                .setIntValZeroCnt(0)
                .setFloatValZeroCnt(0)
                .setIntValAvg(1f)
                .setFloatValAvg(5.5f)
                .build()));
    }

    @Test
    public void getStatisticsNullTest() throws SQLException {
        ScriptUtils.executeSqlScript(jdbcTemplate.getDataSource().getConnection(), new ClassPathResource(NULL_TEST_SQL));
        CheckStatus actual = repository.getStatistics();
        log.info("Statistics from DB:");
        log.info(actual.toString());
        assertTrue("Null test failed!",
                actual.equals(CheckStatus.newBuilder()
                .setNotUniqueCnt(1)
                .setRowCount(3)
                .setIntValNullCnt(2)
                .setFloatValNullCnt(3)
                .setCharValNullCnt(1)
                .setDateValNullCnt(1)
                .setIntValZeroCnt(0)
                .setFloatValZeroCnt(0)
                .setIntValAvg(0.33f)
                .setFloatValAvg(0f)
                .build()));
    }

    @Test
    public void getStatisticsZeroTest() throws SQLException {
        ScriptUtils.executeSqlScript(jdbcTemplate.getDataSource().getConnection(), new ClassPathResource(ZEROS_TEST_SQL));
        CheckStatus actual = repository.getStatistics();
        log.info("Statistics from DB:");
        log.info(actual.toString());
        assertTrue("Zeros test failed!",
                actual.equals(CheckStatus.newBuilder()
                .setNotUniqueCnt(0)
                .setRowCount(3)
                .setIntValNullCnt(0)
                .setFloatValNullCnt(0)
                .setCharValNullCnt(0)
                .setDateValNullCnt(0)
                .setIntValZeroCnt(1)
                .setFloatValZeroCnt(2)
                .setIntValAvg(4.33f)
                .setFloatValAvg(0.73f)
                .build()));
    }

    @Test
    public void getStatisticsNoDataForCurrentPeriodTest() throws SQLException {
        ScriptUtils.executeSqlScript(jdbcTemplate.getDataSource().getConnection(), new ClassPathResource(NO_DATA_SQL));
        CheckStatus actual = repository.getStatistics();
        log.info("Statistics from DB:");
        log.info(actual.toString());
        assertTrue("No-data test failed!",
                actual.equals(CheckStatus.newBuilder()
                        .setNotUniqueCnt(0)
                        .setRowCount(0)
                        .setIntValNullCnt(0)
                        .setFloatValNullCnt(0)
                        .setCharValNullCnt(0)
                        .setDateValNullCnt(0)
                        .setIntValZeroCnt(0)
                        .setFloatValZeroCnt(0)
                        .setIntValAvg(0f)
                        .setFloatValAvg(0f)
                        .build()));
    }

    @After
    public void tearDown() {
        db.shutdown();
    }
}
