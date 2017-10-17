SHOW DATABASES ;
show variables like'%character%';
# 16次运行跨3天 213次跨2天 1647次跨1天 8819次当天
SELECT count(DISTINCT(train_number)) FROM train.train_number_stations_info ;
SELECT * FROM formal_train_number_stations_info ORDER BY total_distance DESC LIMIT 20;