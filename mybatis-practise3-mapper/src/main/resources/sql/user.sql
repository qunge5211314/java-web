CREATE TABLE IF NOT EXISTS user
(
    id     INT(11) PRIMARY KEY AUTO_INCREMENT,
    name   VARCHAR(30)
) ENGINE = INNODB
  AUTO_INCREMENT = 1;
alter table user add last_name varchar(50);
alter table user add enterprise_id int(11);