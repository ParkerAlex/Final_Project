-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema shops
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema shops
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `shops` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE `shops` ;

-- -----------------------------------------------------
-- Table `shops`.`categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shops`.`categories` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_t8o6pivur7nn124jehx7cygw5` (`name` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `shops`.`shops`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shops`.`shops` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_ar5yyuartm46e1brh920fpfiv` (`name` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `shops`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shops`.`products` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `categories_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_o61fmio5yukmmiqgnxf8pnavn` (`name` ASC),
  INDEX `FKgro094vh0dp0tly1225wk8u37` (`categories_id` ASC),
  CONSTRAINT `FKgro094vh0dp0tly1225wk8u37`
    FOREIGN KEY (`categories_id`)
    REFERENCES `shops`.`categories` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `shops`.`intermediates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shops`.`intermediates` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `products_id` BIGINT(20) NOT NULL,
  `shops_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKfdaop8krtm96frx6ofm3kvwft` (`products_id` ASC),
  INDEX `FKbj0jjw8sxjxl9nqfsxhyea7jn` (`shops_id` ASC),
  CONSTRAINT `FKbj0jjw8sxjxl9nqfsxhyea7jn`
    FOREIGN KEY (`shops_id`)
    REFERENCES `shops`.`shops` (`id`),
  CONSTRAINT `FKfdaop8krtm96frx6ofm3kvwft`
    FOREIGN KEY (`products_id`)
    REFERENCES `shops`.`products` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `shops`.`prices`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shops`.`prices` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `check_in` DATE NOT NULL,
  `cost` INT(11) NOT NULL,
  `intermediates_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKqjqglatedramyammos36as588` (`intermediates_id` ASC),
  CONSTRAINT `FKqjqglatedramyammos36as588`
    FOREIGN KEY (`intermediates_id`)
    REFERENCES `shops`.`intermediates` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `shops`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shops`.`user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `created_date` DATETIME(6) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `lastname` VARCHAR(255) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `password` VARCHAR(100) NULL DEFAULT NULL,
  `username` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_ob8kqyqqgmefl0aco34akdtpe` (`email` ASC),
  UNIQUE INDEX `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `shops`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shops`.`user_role` (
  `user_id` BIGINT(20) NOT NULL,
  `roles` INT(11) NULL DEFAULT NULL,
  INDEX `FK859n2jvi8ivhui0rl0esws6o` (`user_id` ASC),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o`
    FOREIGN KEY (`user_id`)
    REFERENCES `shops`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
