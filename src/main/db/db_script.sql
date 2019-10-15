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


INSERT INTO `bank_list_db`.`user` (`user_id`, `name`, `sure_Name`) VALUES (1, 'Ivan', 'Ivanov');
INSERT INTO `bank_list_db`.`user` (`user_id`, `name`, `sure_Name`) VALUES (2, 'Sidor', 'Sidorov');
INSERT INTO `bank_list_db`.`user` (`user_id`, `name`, `sure_Name`) VALUES (3, 'Petr', 'Petrov');
INSERT INTO `bank_list_db`.`user` (`user_id`, `name`, `sure_Name`) VALUES (4, 'Sergei', 'Levkovets');
INSERT INTO `bank_list_db`.`user` (`user_id`, `name`, `sure_Name`) VALUES (5, 'Tom', 'Thompson');
INSERT INTO `bank_list_db`.`user` (`user_id`, `name`, `sure_Name`) VALUES (6, 'Bob', 'Barret');
INSERT INTO `bank_list_db`.`user` (`user_id`, `name`, `sure_Name`) VALUES (7, 'Michael', 'Smith');
INSERT INTO `bank_list_db`.`user` (`user_id`, `name`, `sure_Name`) VALUES (8, 'Rob', 'Davis');
INSERT INTO `bank_list_db`.`user` (`user_id`, `name`, `sure_Name`) VALUES (9, 'Doug', 'Lee');
INSERT INTO `bank_list_db`.`user` (`user_id`, `name`, `sure_Name`) VALUES (10, 'Adam', 'Clark');

INSERT INTO `bank_list_db`.`account` (account_id, `account`, `fk_user_id`) VALUES (1, 200, 1 );
INSERT INTO `bank_list_db`.`account` (account_id, `account`, `fk_user_id`) VALUES (2, 153, 2 );
INSERT INTO `bank_list_db`.`account` (account_id, `account`, `fk_user_id`) VALUES (3, 235, 3 );
INSERT INTO `bank_list_db`.`account` (account_id, `account`, `fk_user_id`) VALUES (4, 825, 4 );
INSERT INTO `bank_list_db`.`account` (account_id, `account`, `fk_user_id`) VALUES (5, 274, 5 );
INSERT INTO `bank_list_db`.`account` (account_id, `account`, `fk_user_id`) VALUES (6, 423, 6 );
INSERT INTO `bank_list_db`.`account` (account_id, `account`, `fk_user_id`) VALUES (7, 741, 7 );
INSERT INTO `bank_list_db`.`account` (account_id, `account`, `fk_user_id`) VALUES (8, 459, 8 );
INSERT INTO `bank_list_db`.`account` (account_id, `account`, `fk_user_id`) VALUES (9, 178, 9 );
INSERT INTO `bank_list_db`.`account` (account_id, `account`, `fk_user_id`) VALUES (10, 189, 10 );
INSERT INTO `bank_list_db`.`account` (account_id, `account`, `fk_user_id`) VALUES (11, 357, 1 );
INSERT INTO `bank_list_db`.`account` (account_id, `account`, `fk_user_id`) VALUES (12, 753, 2 );
INSERT INTO `bank_list_db`.`account` (account_id, `account`, `fk_user_id`) VALUES (13, 159, 3 );
INSERT INTO `bank_list_db`.`account` (account_id, `account`, `fk_user_id`) VALUES (14, 469, 4 );
INSERT INTO `bank_list_db`.`account` (account_id, `account`, `fk_user_id`) VALUES (15, 752, 5 );
INSERT INTO `bank_list_db`.`account` (account_id, `account`, `fk_user_id`) VALUES (16, 299, 6 );
INSERT INTO `bank_list_db`.`account` (account_id, `account`, `fk_user_id`) VALUES (17, 698, 7 );
INSERT INTO `bank_list_db`.`account` (account_id, `account`, `fk_user_id`) VALUES (18, 123, 8 );
INSERT INTO `bank_list_db`.`account` (account_id, `account`, `fk_user_id`) VALUES (19, 375, 9 );
INSERT INTO `bank_list_db`.`account` (account_id, `account`, `fk_user_id`) VALUES (20, 789, 10 );
INSERT INTO `bank_list_db`.`account` (account_id, `account`, `fk_user_id`) VALUES (21, 358, 1 );
INSERT INTO `bank_list_db`.`account` (account_id, `account`, `fk_user_id`) VALUES (22, 712, 2 );
INSERT INTO `bank_list_db`.`account` (account_id, `account`, `fk_user_id`) VALUES (23, 687, 3 );
INSERT INTO `bank_list_db`.`account` (account_id, `account`, `fk_user_id`) VALUES (24, 831, 4 );


