DROP SCHEMA IF EXISTS `test_db`;

CREATE SCHEMA IF NOT EXISTS test_db
    CHARACTER SET `utf8`;

USE test_db;

CREATE TABLE test_db.`user` (
    `user_id` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `sure_Name` VARCHAR(255) NOT NULL
);

CREATE TABLE test_db.`account` (
    account_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `account` INT NOT NULL,
    `fk_user_id` INT NOT NULL,
    CONSTRAINT `fk_to_user` FOREIGN KEY (`fk_user_id`) REFERENCES user (`user_id`)
);

INSERT INTO `test_db`.`user` (`user_id`, `name`, `sure_Name`)
VALUES (1, 'Ivan', 'Ivanov'),
       (2, 'Sidor', 'Sidorov'),
       (3, 'Petr', 'Petrov');

INSERT INTO `test_db`.`account` (account_id, `account`, `fk_user_id`)
VALUES (1, 50, 1),
       (2, 100, 2),
       (3, 150, 3),
       (4, 200, 1),
       (5, 250, 2);
