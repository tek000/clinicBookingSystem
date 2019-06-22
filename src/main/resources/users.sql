INSERT INTO user_roles (id, role) VALUES (1, 'ROLE_USER');
INSERT INTO users (id, login, password) VALUES (1, 'user', '$2a$10$iNWL3dCpWChiBQGU6HAUxOs6iq6ev2nOk6TqlG1T24rX7DFdDvpi.');
INSERT INTO users_roles (user_id, roles_id) VALUES (1, 1);


INSERT INTO `visit` (`id`,`created_on`,`plan_length`,`specialization`,`status`,`created_by`,`visit_date`,`doctor_id`,`patient_id`) VALUES (10,'2019-05-28 00:00:00',15,'okulista',1,1,'2019-06-01 00:00:00',1,1);
INSERT INTO `visit` (`id`,`created_on`,`plan_length`,`specialization`,`status`,`created_by`,`visit_date`,`doctor_id`,`patient_id`) VALUES (11,'2019-05-28 00:00:00',15,'okulista',1,1,'2019-06-01 00:00:00',1,2);
INSERT INTO `visit` (`id`,`created_on`,`plan_length`,`specialization`,`status`,`created_by`,`visit_date`,`doctor_id`,`patient_id`) VALUES (12,'2019-05-28 00:00:00',15,'internista',1,1,'2019-06-01 00:00:00',2,1);
INSERT INTO `visit` (`id`,`created_on`,`plan_length`,`specialization`,`status`,`created_by`,`visit_date`,`doctor_id`,`patient_id`) VALUES (13,'2019-05-28 00:00:00',15,'internista',1,1,'2019-06-01 00:00:00',2,2);
INSERT INTO `visit` (`id`,`created_on`,`plan_length`,`specialization`,`status`,`created_by`,`visit_date`,`doctor_id`,`patient_id`) VALUES (21,'2019-06-21 16:23:43',15,'internista',0,1,'2018-12-31 23:00:00',2,1);
INSERT INTO `visit` (`id`,`created_on`,`plan_length`,`specialization`,`status`,`created_by`,`visit_date`,`doctor_id`,`patient_id`) VALUES (25,'2019-06-21 16:28:29',15,'dentysta',0,1,'2018-12-31 23:00:00',24,2);
INSERT INTO `visit` (`id`,`created_on`,`plan_length`,`specialization`,`status`,`created_by`,`visit_date`,`doctor_id`,`patient_id`) VALUES (23,'2019-06-21 16:26:09',15,'okulista',0,1,'2010-12-31 23:00:00',3,2);
INSERT INTO `visit` (`id`,`created_on`,`plan_length`,`specialization`,`status`,`created_by`,`visit_date`,`doctor_id`,`patient_id`) VALUES (22,'2019-06-21 16:24:09',15,'internista',0,1,'2014-12-31 23:00:00',2,2);


INSERT INTO `patient` (`id`,`first_name`,`last_name`,`pesel`) VALUES (1,'Tomasz','Karolak',7744562115);
INSERT INTO `patient` (`id`,`first_name`,`last_name`,`pesel`) VALUES (2,'Wojciech','Szczęsny',95124536554);
INSERT INTO `patient` (`id`,`first_name`,`last_name`,`pesel`) VALUES (3,'Zbigniew','Boniek',88447525551);


INSERT INTO `doctor` (`id`,`first_name`,`last_name`,`specialization`) VALUES (2,'Ryszard','Nawałka','internista');
INSERT INTO `doctor` (`id`,`first_name`,`last_name`,`specialization`) VALUES (1,'Maciej','Zębaty','okulista');
INSERT INTO `doctor` (`id`,`first_name`,`last_name`,`specialization`) VALUES (3,'Ryszard','Ochódzki','okulista');
INSERT INTO `doctor` (`id`,`first_name`,`last_name`,`specialization`) VALUES (4,'Karol','Witkowski','internista');
