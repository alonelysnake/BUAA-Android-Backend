SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS admin;

create table admin (
    a_id int not null auto_increment,
    a_name varchar(10) unique ,
    a_pw varchar(15) not null,
    primary key(a_id)
)default CHARSET=utf8;

insert into admin(a_name, a_pw) values ('root','123456');
