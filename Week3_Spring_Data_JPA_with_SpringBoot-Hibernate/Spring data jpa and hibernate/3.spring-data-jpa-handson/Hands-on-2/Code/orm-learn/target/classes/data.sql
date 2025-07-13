INSERT INTO department (dp_id, dp_name) VALUES 
(1, 'Engineering'),
(2, 'Finance'),
(3, 'Human Resources'),
(4, 'Marketing');

INSERT INTO employee (id, name, salary, permanent, date_of_birth, em_dp_id) VALUES
(1, 'Amit Sharma', 85000.00, true, '1990-04-15', 1),
(2, 'Priya Verma', 78000.00, true, '1992-06-22', 1),
(3, 'Rahul Mehta', 72000.00, false, '1995-11-03', 2),
(4, 'Sneha Kapoor', 91000.00, true, '1989-09-18', 3),
(5, 'Ankit Rao', 67000.00, true, '1994-03-29', 2),
(6, 'Neha Sinha', 88000.00, true, '1991-12-12', 4);

INSERT INTO skill (id, name) VALUES
(1, 'Java'),
(2, 'Spring Boot'),
(3, 'SQL'),
(4, 'Leadership'),
(5, 'Communication'),
(6, 'Data Analysis');

INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES
(1, 1),
(1, 2),
(2, 1),
(2, 3),
(3, 3),
(3, 6),
(4, 4),
(4, 5),
(5, 3),
(6, 5),
(6, 6);