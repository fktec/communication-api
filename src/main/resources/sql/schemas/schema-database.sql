-- -----------------------------------------------------
-- Table `communication`.`scheduling`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `communication`.`scheduling`(
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `title` VARCHAR(50) NOT NULL,
  `amountPages` INT NOT NULL);
  
-- -----------------------------------------------------
-- Table `communication`.`target`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `communication`.`target`(
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL;
  
-- -----------------------------------------------------
-- Table `communication`.`owner`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `communication`.`owner`(
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL;
