# 车次信息表
CREATE TABLE train_number_info(
  id INT PRIMARY KEY AUTO_INCREMENT,
  train_number VARCHAR(20) NOT NULL ,
  start_time VARCHAR(20) NOT NULL ,
  end_time VARCHAR(20) NOT NULL ,
  stations VARCHAR(255) NOT NULL,
  other_day INT ,
  bak1 VARCHAR(255),
  bak2 VARCHAR(255),
  bak3 VARCHAR(255)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

# 车次停靠站信息表
CREATE TABLE train_number_stations_info(
  id INT PRIMARY KEY AUTO_INCREMENT,
  train_number VARCHAR(20) NOT NULL ,
  sequence_number INT ,
  stations_name VARCHAR(20) NOT NULL,
  distance INT ,
  arrive_time VARCHAR(20) NOT NULL ,
  leave_time VARCHAR(20) NOT NULL ,
  other_day INT ,
  bak1 VARCHAR(255),
  bak2 VARCHAR(255),
  bak3 VARCHAR(255)
)CHARACTER SET utf8 COLLATE utf8_general_ci;