SET FOREIGN_KEY_CHECKS=0;

drop table if exists friend;

create table friend(
    u_id int not null ,
    f_id int not null ,
    primary key (u_id,f_id)
)default charset=utf8;