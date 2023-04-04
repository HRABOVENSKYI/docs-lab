INSERT INTO insurance (active_period_in_days, name, price) VALUES (30, 'Basic Coverage', 50.00);
INSERT INTO insurance (active_period_in_days, name, price) VALUES (90, 'Comprehensive Plan', 150.00);
INSERT INTO insurance (active_period_in_days, name, price) VALUES (365, 'Full Coverage', 500.00);
INSERT INTO insurance (active_period_in_days, name, price) VALUES (180, 'Premium Plan', 250.00);
INSERT INTO insurance (active_period_in_days, name, price) VALUES (60, 'Limited Liability', 75.00);

INSERT INTO `user` (email, first_name, is_banned, last_name, password, role) VALUES ('john.doe@example.com', 'John', 0, 'Doe', 'pass123', 'USER');
INSERT INTO `user` (email, first_name, is_banned, last_name, password, role) VALUES ('jane.doe@example.com', 'Jane', 0, 'Doe', 'pass456', 'USER');
INSERT INTO `user` (email, first_name, is_banned, last_name, password, role) VALUES ('admin@example.com', 'Admin', 0, 'User', 'adminpass', 'ADMIN');
INSERT INTO `user` (email, first_name, is_banned, last_name, password, role) VALUES ('jim.smith@example.com', 'Jim', 1, 'Smith', 'pass789', 'USER');
INSERT INTO `user` (email, first_name, is_banned, last_name, password, role) VALUES ('sara.hill@example.com', 'Sara', 0, 'Hill', 'pass321', 'USER');

INSERT INTO `order` (active_until, created_at, insurance_id, user_id) VALUES ('2023-05-01 00:00:00.000000', '2023-04-04 12:00:00.000000', 1, 1);
INSERT INTO `order` (active_until, created_at, insurance_id, user_id) VALUES ('2023-06-15 00:00:00.000000', '2023-04-04 09:00:00.000000', 2, 2);
INSERT INTO `order` (active_until, created_at, insurance_id, user_id) VALUES ('2023-12-31 23:59:59.999999', '2023-04-03 18:00:00.000000', 3, 3);
INSERT INTO `order` (active_until, created_at, insurance_id, user_id) VALUES ('2023-06-01 00:00:00.000000', '2023-04-04 15:30:00.000000', 1, 4);
INSERT INTO `order` (active_until, created_at, insurance_id, user_id) VALUES ('2023-07-15 00:00:00.000000', '2023-04-02 10:00:00.000000', 2, 5);
INSERT INTO `order` (active_until, created_at, insurance_id, user_id) VALUES ('2023-06-30 00:00:00.000000', '2023-04-04 11:45:00.000000', 4, 2);
INSERT INTO `order` (active_until, created_at, insurance_id, user_id) VALUES ('2023-05-10 00:00:00.000000', '2023-04-01 14:00:00.000000', 5, 1);
INSERT INTO `order` (active_until, created_at, insurance_id, user_id) VALUES ('2023-07-31 23:59:59.999999', '2023-04-04 08:15:00.000000', 3, 4);
