DROP DATABASE IF EXISTS demodb;

CREATE DATABASE IF NOT EXISTS demodb;

USE demodb;

CREATE TABLE usr (
    name                VARCHAR(20),
    account				VARCHAR(20) NOT NULL,
    password			VARCHAR(20),
    permission			TINYINT,
    PRIMARY KEY (account)
);