INSERT INTO USER VALUES (1234, 'Hans', 'password', 'Petersen', 'S', 'hans.petersen');
INSERT INTO USER VALUES (4321, 'Uwe', 'nimda', 'Mayer', 'D', 'uwe.mayer');

INSERT INTO EXAM VALUES (1234, 1, 30, '2017-10-31', 30, 'Allgemeine Betriebswirtschaftslehre', '2017-10-10','Pruefung zum Seminar',4321);
INSERT INTO EXAM VALUES (1235, 0.5, 30, '2017-09-30', 40, 'Controlling', '2017-10-10','Pruefung zum Seminar',4321);
INSERT INTO EXAM VALUES (1236, 2, 30, '2017-10-31', 30, 'Wissenschaftliches Arbeiten', '2017-10-10','Pruefung zum Seminar',4321);
INSERT INTO EXAM VALUES (1237, 4, 60, '2017-10-31', 30, 'Selbstbewusst fuehren', '2017-10-10','BWL',4321);
INSERT INTO EXAM VALUES (1238, 2, 90, '2017-10-31', 30, 'Malen mit Zahlen', '2017-10-10','CSS & HTML',4321);

INSERT INTO QUESTION VALUES (1001, 'Hier steht eine Frage', 1, -0.5, 0,  1234);

INSERT INTO ANSWER VALUES (1001, 'Softwaretechnik existiert seit 1969', TRUE, 1001 );