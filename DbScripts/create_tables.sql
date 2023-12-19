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


CREATE TABLE `horse`.`user_data` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'Record Id',
  `user_id` INT NOT NULL,
  `invested_amount` DECIMAL(12,2) NULL,
  `available_cash` DECIMAL(12,2) NULL,
  `updated_on` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
COMMENT = 'User current data';


CREATE TABLE IF NOT EXISTS `horse2`.`user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'User Id',
  `email` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `created_on` DATETIME(6) NULL,
  `updated_on` DATETIME(6) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

INSERT INTO `horse2`.`user` (`email`, `first_name`, `last_name`, `created_on`) VALUES ('jim.moris@gmail.com', 'Jimmy', 'Moris', '2023-12-17');
INSERT INTO `horse2`.`user` (`email`, `first_name`, `last_name`, `created_on`) VALUES ('ofra.gaza@gmail.com', 'Ofra', 'Gaza', '2023-12-17');
INSERT INTO `horse2`.`user` (`email`, `first_name`, `last_name`, `created_on`) VALUES ('jerom@gotohome.com', 'Jerom', 'Liver', '2023-12-17');




CREATE TABLE IF NOT EXISTS `horse2`.`scenario` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL,
  `scenario_name` VARCHAR(45) NULL COMMENT 'Some meaningfull description or name',
  `invested_amount` DECIMAL(16,2) NULL,
  `available_cash` DECIMAL(16,2) NULL,
  `created_on` DATETIME(6) NULL,
  `updated_on` DATETIME(6) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_scenarios_users_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_scenarios_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `horse2`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `horse2`.`scenario` (`user_id`, `scenario_name`, `invested_amount`, `available_cash`, `created_on`) VALUES ('1', 'Canadian Deptors', '178340.36', '18277.66', '2023-12-17');


drop table horse2.scenario_details;

CREATE TABLE IF NOT EXISTS `horse2`.`scenario_details` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `scenario_id` BIGINT NOT NULL,
  `symbol` VARCHAR(15) NOT NULL COMMENT 'Stock symbol',
  `shares` INT NOT NULL,
  `action` VARCHAR(6) NOT NULL COMMENT 'Actions BOUGHT or SOLD',
  `price` DECIMAL(16,2) NOT NULL COMMENT 'Average Price of shares bought',
  `commisions` DECIMAL(6,2) NULL,
  `action_date` DATETIME(6) NULL COMMENT 'When sold or bought',
  `created_on` DATETIME(6) NULL,
  `updated_on` DATETIME(6) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_scenario_details_scenario_idx` (`scenario_id` ASC) VISIBLE,
  CONSTRAINT `fk_scenario_details_scenarios1`
    FOREIGN KEY (`scenario_id`)
    REFERENCES `horse2`.`scenario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `horse2`.`scenario_details` (`scenario_id`, `symbol`, `shares`, `action`, `price`, `commisions`, `action_date`, `created_on`) VALUES ('1', 'RY.TO', '300', 'Buy', '131.25', '9.95', '2023-12-18', '2023-12-18');
INSERT INTO `horse2`.`scenario_details` (`scenario_id`, `symbol`, `shares`, `action`, `price`, `commisions`, `action_date`, `created_on`) VALUES ('1', 'BMO.TO', '1250', 'Sell', '86.95', '9.95', '2023-12-18', '2023-12-18');
INSERT INTO `horse2`.`scenario_details` (`scenario_id`, `symbol`, `shares`, `action`, `price`, `commisions`, `action_date`, `created_on`) VALUES ('2', 'SU.TO', '2500', 'Hold', '46.25', '9.95', '2023-12-18', '2023-12-18');




