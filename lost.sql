DROP TABLE IF EXISTS lost;
DROP TABLE IF EXISTS last_known_location;
DROP TABLE IF EXISTS lost_person;

CREATE TABLE lost_person(
lost_person_pk int unsigned NOT NULL AUTO_INCREMENT,
lost_person_id VARCHAR(45) NOT NULL,
family_name VARCHAR(45) NOT NULL,
birthday DATETIME NOT NULL,
gender VARCHAR(10) NOT NULL,
missing_date DATETIME NOT NULL,
Home_state_id VARCHAR(40) NOT NULL,
PRIMARY KEY (lost_person_pk),
UNIQUE KEY (lost_person_id)
);
CREATE TABLE last_known_location(
last_known_location_pk int unsigned NOT NULL AUTO_INCREMENT,
last_known_location_id VARCHAR(45) NOT NULL,
last_known_location_date DATETIME NOT NULL,
last_known_location_State_id VARCHAR(40) NOT NULL,
PRIMARY KEY (last_known_location_pk),
UNIQUE KEY (last_known_location_id)
);
CREATE TABLE last_known_location(
lost_pk int unsigned NOT NULL AUTO_INCREMENT,
last_known_location_fk int unsigned NOT NULL,
lost_person_fk int unsigned NOT NULL,
PRIMARY KEY (lost_pk),
FOREIGN KEY (last_known_location_fk) REFERENCES last_known_location (last_known_location_pk) ON DELETE CASCADE,
FOREIGN KEY (lost_person_fk) REFERENCES lostperson (lost_person_pk) ON DELETE CASCADE
);