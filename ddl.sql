use ece356db_s52gupta;
-- -----------------------------------------------------
-- Table `Authentication`
-- -----------------------------------------------------

SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `Authentication` ;

CREATE TABLE IF NOT EXISTS `Authentication` (
  `login` VARCHAR(128) NOT NULL,
  `hashed_password` VARCHAR(64) NULL,
  PRIMARY KEY (`login`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Address`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `Doctor` ;

CREATE TABLE IF NOT EXISTS `Doctor` (
  `login` VARCHAR(128) NOT NULL,
  `first_name` VARCHAR(128) NULL,
  `middle_name` VARCHAR(128) NULL,
  `last_name` VARCHAR(128) NULL,
  `gender` VARCHAR(6) NULL,
  `date_of_birth` DATE NULL,
  `license_year` DATE NULL,
  PRIMARY KEY (`login`),
  CONSTRAINT `fk_Doctor_Authentication1`
    FOREIGN KEY (`login`)
    REFERENCES `Authentication` (`login`)
    ON DELETE CASCADE
    ON UPDATE CASCADE )
  --CONSTRAINT 'check_license_year'
--	CHECK ('license_year' > DATE())
ENGINE = InnoDB;

DROP TABLE IF EXISTS `Address` ;

CREATE TABLE IF NOT EXISTS `Address` (
  `login` VARCHAR(128) NOT NULL,
  `street_number` INT NOT NULL,
  `street_name` VARCHAR(128) NOT NULL,
  `house_number` VARCHAR(32) NOT NULL,
  `postal_code` VARCHAR(6) NOT NULL,
  `city` VARCHAR(128) NULL,
  `province` VARCHAR(64) NULL,
  `type` VARCHAR(64) NULL,
  PRIMARY KEY (`login`,  `street_number`,`street_name`,`house_number`,`postal_code`, `city`, `province`),
 --INDEX `fk_ Address_Doctor1_idx` (`login` ASC),
 CONSTRAINT `fk_Address_Doctor1`
    FOREIGN KEY (`login`)
    REFERENCES `Doctor` (`login`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
 )

ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Specialisation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Specialisation` ;

CREATE TABLE IF NOT EXISTS `Specialisation` (
    `login` VARCHAR(128) NOT NULL,
    `area_of_specialisation` VARCHAR(256) NOT NULL,
    PRIMARY KEY(`login`, `area_of_specialisation`),
    INDEX `fk_Specialisation_login1_idx` (`login` ASC),
    INDEX `fk_Specialisation_area_of_specialisation1_idx` (`area_of_specialisation`),
    CONSTRAINT `fk_Specialisation_login1`
        FOREIGN KEY (`login`)
        REFERENCES `Doctor` (`login`)
        ON DELETE CASCADE
        ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Patient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Patient` ;

CREATE TABLE IF NOT EXISTS `Patient` (
  `login` VARCHAR(128) NOT NULL,
  `first_name` VARCHAR(128) NULL,
  `middle_name` VARCHAR(128) NULL,
  `last_name` VARCHAR(128) NULL,
  `email_address` VARCHAR(254) NULL,
  PRIMARY KEY (`login`),
  INDEX `fk_Admin_Authentication1_idx` (`login` ASC),
  CONSTRAINT `fk_Patient_Authentication1`
    FOREIGN KEY (`login`)
    REFERENCES `Authentication` (`login`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Admin` ;

CREATE TABLE IF NOT EXISTS `Admin` (
  `first_name` VARCHAR(128) NULL,
  `middle_name` VARCHAR(128) NULL,
  `last_name` VARCHAR(128) NULL,
  `login` VARCHAR(128) NULL,
  INDEX `fk_Admin_Authentication1_idx` (`login` ASC),
  CONSTRAINT `fk_Admin_Authentication1`
    FOREIGN KEY (`login`)
    REFERENCES `Authentication` (`login`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Reviews`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Reviews` ;

CREATE TABLE IF NOT EXISTS `Reviews` (
  `patient_login` VARCHAR(128) NOT NULL,
  `doctor_login` VARCHAR(128) NOT NULL,
  `datetime` DATETIME NOT NULL,
  `rating` INT NULL,
  `comments` VARCHAR(256) NULL,
  PRIMARY KEY (`patient_login`,`doctor_login`,`datetime`),
  INDEX `fk_Reviews_Patient1_idx` (`patient_login` ASC),
  INDEX `fk_Reviews_Doctor1_idx` (`doctor_login` ASC),
  CONSTRAINT `fk_Reviews_Patient1`
    FOREIGN KEY (`patient_login`)
    REFERENCES `Patient` (`login`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Reviews_Doctor1`
    FOREIGN KEY (`doctor_login`)
    REFERENCES `Doctor` (`login`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Friend`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Friend` ;

CREATE TABLE IF NOT EXISTS `Friend` (
  `patient_login` VARCHAR(128) NOT NULL,
  `friend_login` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`patient_login`, `friend_login`),
  INDEX `fk_Patient_has_Patient_Patient2_idx` (`friend_login` ASC),
  INDEX `fk_Patient_has_Patient_Patient1_idx` (`patient_login` ASC),
  CONSTRAINT `fk_Patient_has_Patient_Patient1`
    FOREIGN KEY (`patient_login`)
    REFERENCES `Patient` (`login`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Patient_has_Patient_Patient2`
    FOREIGN KEY (`friend_login`)
    REFERENCES `Patient` (`login`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;
SET FOREIGN_KEY_CHECKS=1;

