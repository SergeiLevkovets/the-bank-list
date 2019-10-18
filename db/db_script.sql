DROP SCHEMA IF EXISTS `bank_list_db`;

CREATE SCHEMA IF NOT EXISTS `bank_list_db`
    CHARACTER SET `utf8`;

USE `bank_list_db`;

CREATE TABLE `bank_list_db`.`user` (
    `user_id` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `sure_Name` VARCHAR(255) NOT NULL
);

CREATE TABLE `bank_list_db`.`account` (
    account_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `account` INT NOT NULL,
    `fk_user_id` INT NOT NULL,
    CONSTRAINT `fk_to_user` FOREIGN KEY (`fk_user_id`) REFERENCES user (`user_id`)
);


INSERT INTO `bank_list_db`.`user` (`user_id`, `name`, `sure_Name`)
VALUES (1, 'Ivan', 'Ivanov'),
       (2, 'Sidor', 'Sidorov'),
       (3, 'Petr', 'Petrov'),
       (4, 'Sergei', 'Levkovets'),
       (5, 'Tom', 'Thompson'),
       (6, 'Bob', 'Barret'),
       (7, 'Michael', 'Smith'),
       (8, 'Rob', 'Davis'),
       (9, 'Doug', 'Lee'),
       (10, 'Adam', 'Clark');

INSERT INTO `bank_list_db`.`account` (account_id, `account`, `fk_user_id`)
VALUES (1, 200, 1),
       (2, 153, 2),
       (3, 235, 3),
       (4, 825, 4),
       (5, 274, 5),
       (6, 423, 6),
       (7, 741, 7),
       (8, 459, 8),
       (9, 178, 9),
       (10, 189, 10),
       (11, 357, 1),
       (12, 753, 2),
       (13, 159, 3),
       (14, 469, 4),
       (15, 752, 5),
       (16, 299, 6),
       (17, 698, 7),
       (18, 123, 8),
       (19, 375, 9),
       (20, 789, 10),
       (21, 358, 1),
       (22, 712, 2),
       (23, 687, 3),
       (24, 831, 4);


