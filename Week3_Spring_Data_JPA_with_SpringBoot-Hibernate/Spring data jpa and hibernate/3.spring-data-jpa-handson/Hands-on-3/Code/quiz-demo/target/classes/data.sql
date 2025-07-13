-- USERS
INSERT INTO app_user (id, name) VALUES (1, 'john_doe');

-- QUESTIONS
INSERT INTO question (id, text, score) VALUES 
(1, 'What is the extension of the hyper text markup language file?', 1.0),
(2, 'What is the maximum level of heading tag can be used in a HTML page?', 1.0),
(3, 'The HTML document itself begins with <html> and ends </html>. State True or False', 1.0),
(4, 'Choose the right option to store text value value in a variable', 1.0);

-- OPTIONS
INSERT INTO options (id, question_id, text, score, is_correct) VALUES 
(1, 1, '.xhtm', 0.0, FALSE),
(2, 1, '.ht', 0.0, FALSE),
(3, 1, '.html', 1.0, TRUE),
(4, 1, '.htmx', 0.0, FALSE),

(5, 2, '5', 0.0, FALSE),
(6, 2, '3', 1.0, TRUE),
(7, 2, '4', 0.0, FALSE),
(8, 2, '6', 0.0, FALSE),

(9, 3, 'false', 0.0, FALSE),
(10, 3, 'true', 1.0, TRUE),

(11, 4, '''John''', 0.5, TRUE), 
(12, 4, 'John', 0.0, FALSE), 
(13, 4, '"John"', 0.5, FALSE), 
(14, 4, '/John/', 0.0, FALSE);

-- ATTEMPT
INSERT INTO attempt (id, at_us_id, attempted_date) VALUES (100, 1, '2025-07-10');

-- ATTEMPT_QUESTION
INSERT INTO attempt_question (id, aq_am_id, aq_qt_id) VALUES 
(1000, 100, 1),
(1001, 100, 2),
(1002, 100, 3),
(1003, 100, 4);

-- ATTEMPT_OPTION (user's selected options)
INSERT INTO attempt_option (id, ao_aq_id, ao_op_id, ao_attempt_id) VALUES 
(10000, 1000, 3, 100),  -- .html
(10001, 1001, 6, 100),  -- 3
(10002, 1002, 10, 100), -- true
(10003, 1003, 11, 100); -- 'John'
