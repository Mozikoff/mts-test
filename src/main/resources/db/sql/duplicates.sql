-- duplicates exists
DELETE FROM CHECK_OBJECT;
INSERT INTO CHECK_OBJECT(LOAD_DATE, ID, INT_VALUE, FLOAT_VALUE, CHAR_VALUE, DATE_VALUE)
VALUES(CURDATE(), 1, 1, 3.0, 'B', CURDATE()),
(CURDATE(), 1, 1, 6.0, 'С', CURDATE()-1),
(CURDATE(), 1, 1, 7.5, 'DF', CURDATE()-2),
(CURDATE()-1, 1, 1, 6.0, 'С', CURDATE()-1),
(CURDATE()-2, 1, 1, 7.5, 'DF', CURDATE()-2);