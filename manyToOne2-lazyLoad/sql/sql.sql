create database test;
use test;

DROP TABLE student;
CREATE TABLE student (id int(5) NOT NULL AUTO_INCREMENT, name varchar(50), age int(3), score double, PRIMARY KEY (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO student (id, name, age, score) VALUES (1, '张三', 23, 93.5);
INSERT INTO student (id, name, age, score) VALUES (2, '李四', 24, 94.5);
INSERT INTO student (id, name, age, score) VALUES (3, '王五', 25, 95.5);
