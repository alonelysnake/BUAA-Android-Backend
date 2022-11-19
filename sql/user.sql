SET FOREIGN_KEY_CHECKS=0;

drop table if exists user;

create table user(
    u_id int not null auto_increment,
    u_name varchar(10) unique,
    u_pw varchar(15) not null,
    primary key (u_id)
)default CHARSET=utf8;

insert into user(u_name, u_pw) values ('wyy','123456');