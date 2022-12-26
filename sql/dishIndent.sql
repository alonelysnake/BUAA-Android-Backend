SET FOREIGN_KEY_CHECKS=0;

drop table if exists dishIndent;

create table dishIndent(
    o_id int not null ,
    d_id int not null ,
    sum int not null,
    primary key (o_id,d_id)
)default charset=utf8;