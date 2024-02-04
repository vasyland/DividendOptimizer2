CREATE TABLE `watch_symbol` (
  `symbol` varchar(10) NOT NULL,
  `quoterly_dividend_amount` decimal(38,2) DEFAULT NULL COMMENT 'Quoterly dividend amount',
  `upper_yield` decimal(38,2) DEFAULT NULL COMMENT 'Upper dividend yield',
  `lower_yield` decimal(38,2) DEFAULT NULL COMMENT 'Lower dividend yield',
  `updated_on` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`symbol`),
  UNIQUE KEY `symbol_UNIQUE` (`symbol`),
  UNIQUE KEY `UK1eg9q32y95hn0r7gx0bemfd6k` (`symbol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='A list of symbol with divident payments';


drop table horse2.scenario_details;
drop table horse2.scenario;
drop table horse2.user;

CREATE TABLE IF NOT EXISTS `horse2`.`user` (
  `user_id` BIGINT NOT NULL COMMENT 'User Id',
  `email` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `user_name` VARCHAR(15) NOT NULL,
  `password` VARCHAR(15) NOT NULL,
  `created_on` DATETIME(6) NULL,
  `updated_on` DATETIME(6) NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `horse2`.`scenario` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL,
  `scenario_name` VARCHAR(45) NULL COMMENT 'Some meaningfull description or name',
  `invested_amount` DECIMAL(16,2) NULL,
  `created_on` DATETIME(6) NULL,
  `updated_on` DATETIME(6) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_scenarios_users_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_scenarios_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `horse2`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `horse2`.`actions` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `scenario_id` BIGINT NOT NULL,
  `symbol` VARCHAR(15) NOT NULL COMMENT 'Stock symbol',
  `quantity` INT NOT NULL COMMENT 'Number of shares',
  `activity` VARCHAR(6) NOT NULL COMMENT 'Actions Buy or Sell',
  `price` DECIMAL(16,2) NOT NULL COMMENT 'Price of the action: buy or sell',
  `commisions` DECIMAL(6,2) NULL,
  `currency` VARCHAR(3) NULL COMMENT 'Currency CAD, US, EUR',
  `activity_date` DATETIME(6) NULL COMMENT 'When sold or bought',
  `created_on` DATETIME(6) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_scenario_details_scenarios1_idx` (`scenario_id` ASC) VISIBLE,
  CONSTRAINT `fk_scenario_details_scenarios1`
    FOREIGN KEY (`scenario_id`)
    REFERENCES `horse2`.`scenario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

