drop table action;
drop table scenario;
drop table user;

CREATE TABLE IF NOT EXISTS `user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'User Id',
  `email` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `user_name` VARCHAR(15) NOT NULL,
  `password` VARCHAR(15) NOT NULL,
  `created_on` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `updated_on` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `updated_on_UNIQUE` (`updated_on` ASC) VISIBLE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `scenario` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL,
  `scenario_name` VARCHAR(45) NULL COMMENT 'Some meaningfull description or name',
  `invested_amount` DECIMAL(16,2) NULL,
  `created_on` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `updated_on` DATETIME ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_scenario_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_scenario_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `horse2`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `horse2`.`action` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `scenario_id` BIGINT NOT NULL,
  `symbol` VARCHAR(15) NOT NULL COMMENT 'Stock symbol',
  `quantity` INT NOT NULL COMMENT 'Number of shares',
  `activity` VARCHAR(6) NOT NULL COMMENT 'Actions Buy or Sell',
  `price` DECIMAL(16,2) NOT NULL COMMENT 'Price of the action: buy or sell',
  `commisions` DECIMAL(6,2) NULL,
  `currency` VARCHAR(3) NULL COMMENT 'Currency CAD, US, EUR',
  `activity_date` DATETIME NULL COMMENT 'When sold or bought',
  `created_on` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_action_scenario1_idx` (`scenario_id` ASC) VISIBLE,
  CONSTRAINT `fk_action_scenario1`
    FOREIGN KEY (`scenario_id`)
    REFERENCES `horse2`.`scenario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

