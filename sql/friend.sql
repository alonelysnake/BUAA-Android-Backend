SET FOREIGN_KEY_CHECKS=0;

drop table if exists friend;

create table friend(
    u_id varchar(15) not null ,
    f_id varchar(15) not null ,
    primary key (u_id,f_id)
)default charset=utf8;