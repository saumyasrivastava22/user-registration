CREATE TABLE IF NOT EXISTS PROFILE (
    ID INT NOT NULL AUTO_INCREMENT,
    FIRSTNAME VARCHAR(50) NOT NULL,
    LASTNAME VARCHAR(50) NOT NULL,
    USERNAME VARCHAR(25) NOT NULL,
    EMAIL VARCHAR(50) NOT NULL,
    MOBILE VARCHAR(12),
    STATE VARCHAR(10) DEFAULT 'INACTIVE',
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    LAST_MODIFIED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY(ID),
    UNIQUE(USERNAME),
    UNIQUE(EMAIL)
);