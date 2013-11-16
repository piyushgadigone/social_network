use ece356db_pgadigon;

--INSERT INTO Authentication VALUES ("test", "test");

INSERT INTO Authentication VALUES ("doc_john", "doc_john_pass");
INSERT INTO Authentication VALUES ("doc_mark", "doc_mark_pass");
INSERT INTO Authentication VALUES ("doc_bob", "doc_bob_pass");
INSERT INTO Authentication VALUES ("doc_julie", "doc_julie_pass"); 
INSERT INTO Doctor VALUES ("doc_mark", "Mark", "J", "Johnson", "m", "19680512", "20010614");
INSERT INTO Doctor VALUES ("doc_bob", "Bob", NULL, "Davidson", "m", "19711120", "20040901");
INSERT INTO Doctor VALUES ("doc_john", "John", "M", "Spencer", "m", "19700128", "20000412");
INSERT INTO Doctor VALUES ("doc_julie", "Julie", "K", "Fenshaw", "f", "19741021", "20050114");



INSERT INTO Specialisation VALUES ("doc_mark", "Orthopedic");
INSERT INTO Specialisation VALUES ("doc_john", "General Practioner");
INSERT INTO Specialisation VALUES ("doc_bob", "Cardiologist");
INSERT INTO Specialisation VALUES ("doc_julie", "Psychotherapy");
INSERT INTO Specialisation VALUES ("doc_julie", "Neurophysiology");
INSERT INTO Specialisation VALUES ("doc_julie", "Psychotherapy");
INSERT INTO Specialisation VALUES ("doc_julie", "Neurophysiology");

INSERT INTO Address VALUES ("doc_mark", "32", "Lester St.", "2", "N2L3K1", "Toronto", "Ontario", "House");
INSERT INTO Address VALUES ("doc_julie", "10", "Willowgrove Parkway", "13", "M4K5J1", "Montreal", "Quebec", "Work");
INSERT INTO Address VALUES ("doc_bob", "4", "Pearson Boulevard", "45", "H2KO9K", "Vancouver", "British Columbia", "Work");
INSERT INTO Address VALUES ("doc_john", "1", "Albert Street", "644", "S1B8K1", "Calgary", "Alberta", "House");
INSERT INTO Address VALUES ("doc_mark", "56", "Privet Drive", "32", "P1K3H3", "London", "Ontario", "Work");

SELECT * FROM Authentication;
SELECT * FROM Doctor;
SELECT * FROM Specialisation;