SET FOREIGN_KEY_CHECKS=0;

drop table if exists provider;

create table provider(
    p_id int not null auto_increment,
    p_name varchar(10) not null,
    p_pw varchar(15) not null,
    scores int not null ,
    scorers int not null ,
    d_id int,
    foreign key (d_id) references district(d_id),
    primary key (p_id)
)default charset=utf8;

