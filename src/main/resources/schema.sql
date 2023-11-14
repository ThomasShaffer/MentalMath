DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS run CASCADE;


CREATE TABLE users (
    id BIGINT AUTO_INCREMENT,
    userName VARCHAR(50),
    userPassword VARCHAR(50));

CREATE TABLE run (
    runId BIGINT AUTO_INCREMENT,
    userId BIGINT,
    category VARCHAR(50),
    firstDigit BIGINT,
    secondDigit BIGINT,
    correct BOOLEAN,
    timeElapsed FLOAT);
