INSERT INTO users (id, email, password) VALUES (1, 'abc1@mail.com', 'qwert1');
INSERT INTO users (id, email, password) VALUES (2, 'abc2@mail.com', 'qwert2');
INSERT INTO users (id, email, password) VALUES (3, 'abc3@mail.com', 'qwert3');
INSERT INTO users (id, email, password) VALUES (4, 'abc4@mail.com', 'qwert4');
INSERT INTO users (id, email, password) VALUES (5, 'abc5@mail.com', 'qwert5');

INSERT INTO trainings VALUES (1, 'training1', 2, 20, 1);
INSERT INTO trainings VALUES (2, 'training2', 2, 20, 1);
INSERT INTO trainings VALUES (3, 'training3', 2, 20, 1);
INSERT INTO trainings VALUES (4, 'training4', 2, 20, 2);
INSERT INTO trainings VALUES (5, 'training5', 2, 20, 3);

INSERT INTO images VALUES (1, NULL);
INSERT INTO images VALUES (2, NULL);
INSERT INTO images VALUES (3, NULL);
INSERT INTO images VALUES (4, NULL);
INSERT INTO images VALUES (5, NULL);

INSERT INTO exercises VALUES (1, 'description', 'name1', 5);
INSERT INTO exercises VALUES (2, 'description', 'name2', 4);
INSERT INTO exercises VALUES (3, 'description', 'name3', 3);
INSERT INTO exercises VALUES (4, 'description', 'name4', 2);
INSERT INTO exercises VALUES (5, 'description', 'name5', 1);

INSERT INTO training_x_exercises VALUES (1, 2, 20, 2, 1);
INSERT INTO training_x_exercises VALUES (2, 1, 25, 3, 1);
INSERT INTO training_x_exercises VALUES (3, 3, 30, 4, 1);
INSERT INTO training_x_exercises VALUES (4, 1, 15, 1, 2);
INSERT INTO training_x_exercises VALUES (5, 2, 25, 2, 2);
INSERT INTO training_x_exercises VALUES (6, 1, 20, 1, 3);
INSERT INTO training_x_exercises VALUES (7, 1, 15, 5, 4);
INSERT INTO training_x_exercises VALUES (8, 1, 35, 4, 5);