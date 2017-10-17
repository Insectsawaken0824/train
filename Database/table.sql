# 车次信息表
Drop table train_number_info;
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
Drop table train.train_number_stations_info;
CREATE TABLE train.train_number_stations_info(
  id INT PRIMARY KEY AUTO_INCREMENT,
  train_number VARCHAR(20) NOT NULL COMMENT '车次' ,
  sequence_number INT COMMENT '到站序列号' ,
  stations_name VARCHAR(20) NOT NULL COMMENT '站名',
  distance INT COMMENT '距离' ,
  total_distance INT COMMENT '总距离' ,
  arrive_time VARCHAR(20) NOT NULL COMMENT '到达时间' ,
  leave_time VARCHAR(20) NOT NULL COMMENT '离开时间' ,
  runtime LONG NOT NULL COMMENT '行驶时间' ,
  total_runtime LONG NOT NULL COMMENT '总行驶时间' ,
  other_day INT COMMENT '0 当天 1 第二天 ..' ,
  bak1 VARCHAR(255),
  bak2 VARCHAR(255),
  bak3 VARCHAR(255)
)CHARACTER SET utf8 COLLATE utf8_general_ci;
truncate table train.train_number_stations_info;