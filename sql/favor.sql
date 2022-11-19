SET FOREIGN_KEY_CHECKS=0;

drop table if exists favor;

create table favor(
    u_id int not null ,
    d_id int not null ,
    primary key (u_id,d_id)
)default charset=utf8;
