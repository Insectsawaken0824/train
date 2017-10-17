SHOW DATABASES ;
show variables like'%character%';
# 16次运行跨3天 213次跨2天 1663次跨1天 9032次当天
SELECT count(DISTINCT(train_number)) FROM train.train_number_stations_info WHERE other_day = 0 ;
