-- grades
INSERT INTO grades(id, grade_value, subject, grade_date, grade_type, has_taken, rate)
values (1, 5, 'HISTORY', current_timestamp, 'CLASS_GRADE', false, 0);

INSERT INTO grades(id, grade_value, subject, grade_date, grade_type, has_taken, rate)
values (2, 4, 'MATHEMATICS', current_timestamp, 'CLASS_GRADE', false, 1);

INSERT INTO grades(id, grade_value, subject, grade_date, grade_type, has_taken, rate)
values (3, 3, 'MATHEMATICS', current_timestamp, 'CLASS_GRADE', false, 3);

INSERT INTO grades(id, grade_value, subject, grade_date, grade_type, has_taken, rate)
values (4, 5, 'RUSSIAN_LANGUAGE', current_timestamp, 'CLASS_GRADE', false, 2);

INSERT INTO grades(id, grade_value, subject, grade_date, grade_type, has_taken, rate)
values (5, 5, 'RUSSIAN_LANGUAGE', current_timestamp, 'CLASS_GRADE', false, 2);

ALTER SEQUENCE grade_seq RESTART WITH 6;