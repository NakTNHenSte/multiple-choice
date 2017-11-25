INSERT INTO USER VALUES (1234, 'Hans', 'password', 'Petersen', 'S', 'hans.petersen');
INSERT INTO USER VALUES (1235, 'Diecke', 'password', 'Lübberstadt', 'S', 'diecke.luebber');
INSERT INTO USER VALUES (1236, 'Chris', 'password', 'West', 'S', 'christ.west');
INSERT INTO USER VALUES (1237, 'Schtiewn', 'password', 'Hens', 'S', 'schtiewn.hens');
INSERT INTO USER VALUES (1238, 'Daniela', 'password', 'Katzenburger', 'S', 'daniela.katzenburger');

INSERT INTO USER VALUES (4321, 'Uwe', 'nimda', 'Mayer', 'D', 'uwe.mayer');
INSERT INTO USER VALUES (1000, 'Karl', '', 'Karlson', 'D', '');

INSERT INTO EXAM VALUES (1234, 1, 30, '2017-12-12', 30, 'Allgemeine Betriebswirtschaftslehre', '2017-09-17','Pruefung zum Seminar',4321);
INSERT INTO EXAM VALUES (1235, 0.5, 30, '2017-09-30', 40, 'Controlling', '2017-10-10','Pruefung zum Seminar',4321);
INSERT INTO EXAM VALUES (1236, 2, 30, '2017-10-31', 30, 'Wissenschaftliches Arbeiten', '2017-10-10','Pruefung zum Seminar',4321);
INSERT INTO EXAM VALUES (1237, 4, 60, '2017-10-31', 30, 'Selbstbewusst fuehren', '2017-10-10','BWL',4321);
INSERT INTO EXAM VALUES (1238, 2, 90, '2017-10-31', 30, 'Malen mit Zahlen', '2017-10-10','CSS & HTML',4321);

INSERT INTO QUESTION VALUES (1001, 'Hier steht eine Frage', 'multiple', 1, -0.5, 0,  1234);
INSERT INTO QUESTION VALUES (1002, 'Die ist §§ein Test für den Lückentext%%, um zu sehen ob er funktioniert.', 'gap', 4, -1, 0,  1234);
INSERT INTO QUESTION VALUES (1003, 'Wirtschaftsinformatik ist die Kombination aus §§Betriebswirtschaftslehre%% und §§Informatik%%.', 'gap', 6, 0, 0,  1234);
INSERT INTO QUESTION VALUES (1004, 'Wie heißt die Hauptstadt von China?', 'multiple', 1, 0, 0,  1234);
INSERT INTO QUESTION VALUES (1005, 'Was kann ein Wirtschaftsinformatiker alles nach seiner Ausbildung?', 'multiple,' 1, -1, -0.5,  1234);

INSERT INTO ANSWER VALUES (100, 'Softwaretechnik existiert seit 1969.', 1, 'false', 1001);
INSERT INTO ANSWER VALUES (200, 'Das ist die richtige Antwort.', 2, 'true', 1001);
INSERT INTO ANSWER VALUES (300, 'Das ist die falsche Antwort.', 3, 'true', 1001);
INSERT INTO ANSWER VALUES (400, 'ein Test für den Lückentext', 1, 'true', 1002);
INSERT INTO ANSWER VALUES (500, 'Betriebswirtschaftslehre', 1, 'true', 1003);
INSERT INTO ANSWER VALUES (510, 'Informatik', 2, 'true', 1003);
INSERT INTO ANSWER VALUES (600, 'Paris', 1, 'false', 1004);
INSERT INTO ANSWER VALUES (700, 'New York', 2, 'false', 1004);
INSERT INTO ANSWER VALUES (800, 'Peking', 3, 'true', 1004);
INSERT INTO ANSWER VALUES (900, 'Elmshorn', 4, 'false', 1004);
INSERT INTO ANSWER VALUES (1000, 'Programmieren', 1, 'true', 1005);
INSERT INTO ANSWER VALUES (1100, 'Programmieren', 2, 'true', 1005);
INSERT INTO ANSWER VALUES (1200, 'Software entwickeln', 3, 'true', 1005);
INSERT INTO ANSWER VALUES (1300, 'Geschäftsprozesse modellieren', 4, 'true', 1005);
INSERT INTO ANSWER VALUES (1400, 'echt leckeren Kuchen backen', 5, 'false', 1005);

INSERT INTO PARTICIPATION VALUES (1, 'a', TRUE,1234, 1234);
INSERT INTO PARTICIPATION VALUES (2, '40e02bb7-860b-46e4-aa19-39088bf57d9a', TRUE,1235, 1235);

