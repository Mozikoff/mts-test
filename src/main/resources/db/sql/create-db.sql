-- -----------------------------------------------------
-- Table `mts_test`.`CHECK_OBJECT`
-- -----------------------------------------------------
CREATE TABLE CHECK_OBJECT (
  TEST_ID INT PRIMARY KEY AUTO_INCREMENT,
  LOAD_DATE DATE NULL,
  ID INT NULL,
  INT_VALUE INT NULL,
  FLOAT_VALUE FLOAT NULL,
  CHAR_VALUE VARCHAR(10) NULL,
  DATE_VALUE DATE NULL);

-- -----------------------------------------------------
-- Table `mts_test`.`CHECK_STATUS`
-- -----------------------------------------------------
CREATE TABLE CHECK_STATUS (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  DATE DATE NOT NULL,
  NOT_UNIQUE_CNT INT NOT NULL,
  ROW_COUNT INT NOT NULL,
  INT_VAL_NULL_CNT INT NOT NULL,
  FLOAT_VAL_NULL_CNT INT NOT NULL,
  CHAR_VAL_NULL_CNT INT NOT NULL,
  DATE_VAL_NULL_CNT INT NOT NULL,
  INT_VAL_ZERO_CNT INT NOT NULL,
  FLOAT_VAL_ZERO_CNT INT NOT NULL,
  INT_VAL_AVG DOUBLE NOT NULL,
  FLOAT_VAL_AVG DOUBLE NOT NULL);