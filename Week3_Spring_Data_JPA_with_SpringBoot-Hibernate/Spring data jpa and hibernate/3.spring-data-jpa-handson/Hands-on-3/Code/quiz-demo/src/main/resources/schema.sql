DROP TABLE IF EXISTS attempt_option;
DROP TABLE IF EXISTS attempt_question;
DROP TABLE IF EXISTS attempt;
DROP TABLE IF EXISTS options;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS app_user;

CREATE TABLE app_user (
    id INT PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE question (
    id INT PRIMARY KEY,
    text VARCHAR(255),
    score DOUBLE
);

CREATE TABLE options (
    id INT PRIMARY KEY,
    question_id INT,
    text VARCHAR(255),
    score DOUBLE,
    is_correct BOOLEAN,
    FOREIGN KEY (question_id) REFERENCES question(id)
);

CREATE TABLE attempt (
    id INT PRIMARY KEY,
    at_us_id INT,
    attempted_date DATE,
    FOREIGN KEY (at_us_id) REFERENCES app_user(id)
);

CREATE TABLE attempt_question (
    id INT PRIMARY KEY,
    aq_am_id INT,
    aq_qt_id INT,
    FOREIGN KEY (aq_am_id) REFERENCES attempt(id),
    FOREIGN KEY (aq_qt_id) REFERENCES question(id)
);

CREATE TABLE attempt_option (
    id INT PRIMARY KEY,
    ao_aq_id INT,
    ao_op_id INT,
    ao_attempt_id INT,
    FOREIGN KEY (ao_aq_id) REFERENCES attempt_question(id),
    FOREIGN KEY (ao_op_id) REFERENCES options(id),
    FOREIGN KEY (ao_attempt_id) REFERENCES attempt(id)
);
