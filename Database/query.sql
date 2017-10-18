SHOW DATABASES ;
show variables like'%character%';
# 16次运行跨3天 213次跨2天 1647次跨1天 8819次当天
SELECT count(DISTINCT(train_number)) FROM train.train_number_stations_info ;
# 里程最长的车次
SELECT * FROM train.formal_train_number_stations_info ORDER BY total_distance DESC LIMIT 1;
# 有多少个车站 2823
SELECT count(DISTINCT(stations_name)) FROM train.formal_train_number_stations_info;

SELECT *
FROM
  (SELECT *
   FROM train.formal_train_number_stations_info
   WHERE stations_name = '北京') a LEFT JOIN
  (SELECT *
   FROM train.formal_train_number_stations_info
   WHERE stations_name = '长沙') b ON a.train_number = b.train_number
WHERE a.sequence_number < b.sequence_number;
