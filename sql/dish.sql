SET FOREIGN_KEY_CHECKS=0;

drop table if exists dish;

create table dish(
    d_id int not null auto_increment,
    p_id int not null ,
    dicount double(3,2) ,
    price double(3,2) not null ,
    sale int8 not null ,
    d_likes int not null ,
    d_dislikes int not null ,
    primary key (d_id),
    foreign key (p_id) references provider(p_id)
)default charset=utf8;