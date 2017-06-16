CREATE DATABASE student_manager DEFAULT CHARACTER SET utf8;

CREATE TABLE student(
   id INT PRIMARY KEY AUTO_INCREMENT,
   NAME VARCHAR(10),
   age INT,
   gender VARCHAR(1)
);

INSERT INTO student(NAME,age,gender) VALUES('张三',18,'男');
INSERT INTO student(NAME,age,gender) VALUES('李四',18,'男');
INSERT INTO student(NAME,age,gender) VALUES('王五',30,'女');
INSERT INTO student(NAME,age,gender) VALUES('赵六',27,'男');
INSERT INTO student(NAME,age,gender) VALUES('小张',18,'女');
INSERT INTO student(NAME,age,gender) VALUES('小明',32,'男');

SELECT * FROM student;




