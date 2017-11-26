INSERT INTO USER VALUES (123400, 'Hans', 'password', 'Petersen', 'S', 'hans.petersen');
INSERT INTO USER VALUES (123500, 'Diecke', 'password', 'Luebberstadt', 'S', 'diecke.luebberstedt');
INSERT INTO USER VALUES (123600, 'Chris', 'password', 'West', 'S', 'christ.west');
INSERT INTO USER VALUES (123700, 'Schtiewn', 'password', 'Hens', 'S', 'schtiewn.hens');
INSERT INTO USER VALUES (123800, 'Daniela', 'password', 'Katzenburger', 'S', 'daniela.katzenburger');

INSERT INTO USER VALUES (432100, 'Uwe', 'nimda', 'Mayer', 'D', 'uwe.mayer');
INSERT INTO USER VALUES (100000, 'Karl', '', 'Karlson', 'D', '');

INSERT INTO EXAM VALUES (123400, 1, 30, '2017-12-12', 30, 'Allgemeine Betriebswirtschaftslehre', '2017-09-17','Pruefung zum Seminar',432100);
INSERT INTO EXAM VALUES (123500, 0.5, 30, '2017-09-30', 40, 'Controlling', '2017-10-10','Pruefung zum Seminar',432100);
INSERT INTO EXAM VALUES (123600, 2, 30, '2017-10-31', 30, 'Wissenschaftliches Arbeiten', '2017-10-10','Pruefung zum Seminar',432100);
INSERT INTO EXAM VALUES (123700, 4, 60, '2017-10-31', 30, 'Selbstbewusst fuehren', '2017-10-10','BWL',432100);
INSERT INTO EXAM VALUES (123800, 2, 90, '2017-10-31', 30, 'Malen mit Zahlen', '2017-10-10','CSS & HTML',432100);

INSERT INTO QUESTION VALUES (100100, 'Hier steht eine Frage', 'multiple', 1, -0.5, 0,  123400);
INSERT INTO QUESTION VALUES (100200, 'Die ist die _%richtige%_ Antwort.', 'gap', 4, -1, 0,  123400);
INSERT INTO QUESTION VALUES (100300, 'Wirtschaftsinformatik ist die Kombination aus _%Betriebswirtschaftslehre%_ und _%Informatik%_.', 'gap', 6, 0, 0,  123400);
INSERT INTO QUESTION VALUES (100400, 'Wie heisst die Hauptstadt von China?', 'multiple', 1, 0, 0,  123400);
INSERT INTO QUESTION VALUES (100500, 'Was kann ein Wirtschaftsinformatiker alles nach seiner Ausbildung?', 'multiple,' 1, -1, -0.5,  123400);

INSERT INTO ANSWER VALUES (10000, 'Softwaretechnik existiert seit 1969.', 1, 'false', 100100);
INSERT INTO ANSWER VALUES (20000, 'Das ist die richtige Antwort.', 2, 'true', 100100);
INSERT INTO ANSWER VALUES (30000, 'Das ist die falsche Antwort.', 3, 'true', 100100);
INSERT INTO ANSWER VALUES (40000, 'luecke', 1, 'richtige', 100200);
INSERT INTO ANSWER VALUES (50000, 'luecke', 1, 'Betriebswirtschaftslehre', 100300);
INSERT INTO ANSWER VALUES (51000, 'luecke', 2, 'Informatik', 100300);
INSERT INTO ANSWER VALUES (60000, 'Paris', 1, 'false', 100400);
INSERT INTO ANSWER VALUES (70000, 'New York', 2, 'false', 100400);
INSERT INTO ANSWER VALUES (80000, 'Peking', 3, 'true', 100400);
INSERT INTO ANSWER VALUES (90000, 'Elmshorn', 4, 'false', 100400);
INSERT INTO ANSWER VALUES (100000, 'Programmieren', 1, 'true', 100500);
INSERT INTO ANSWER VALUES (110000, 'Programmieren', 2, 'true', 100500);
INSERT INTO ANSWER VALUES (120000, 'Software entwickeln', 3, 'true', 100500);
INSERT INTO ANSWER VALUES (130000, 'Geschaeftsprozesse modellieren', 4, 'true', 100500);
INSERT INTO ANSWER VALUES (140000, 'echt leckeren Kuchen backen', 5, 'false', 100500);

INSERT INTO PARTICIPATION VALUES (10000, 'a', TRUE,123400, 123400);
INSERT INTO PARTICIPATION VALUES (10000, '40e02bb7-860b-46e4-aa19-39088bf57d9a', TRUE,123500, 123500);

INSERT INTO TESTANSWER VALUES (10000, TRUE, 'richtige', 40000, 123400, 123400);
INSERT INTO TESTANSWER VALUES (20000, FALSE, 'Controlling', 50000,123400, 123400);
INSERT INTO TESTANSWER VALUES (30000, TRUE, 'Informatik', 51000, 123400, 123400);
