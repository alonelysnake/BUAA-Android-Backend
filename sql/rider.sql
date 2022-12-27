SET FOREIGN_KEY_CHECKS=0;

drop table if exists rider;

create table rider(
     r_id varchar(15) not null,
     r_name varchar(10) unique,
     contact varchar(15),
     r_pw varchar(15) not null,
     real_name varchar(20),
     school varchar(50),
     rider_state boolean default false,

     primary key (r_id)
)default CHARSET=utf8;