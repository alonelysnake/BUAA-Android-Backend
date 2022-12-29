
create table dish(
    d_id int not null auto_increment,
    p_id int not null ,
    name varchar(512) not null ,
    curPrice double(10,2) not null ,
    price double(10,2) not null ,
    sale int8 not null ,
    d_likes int not null ,
    d_dislikes int not null ,
    imgUrl varchar(1024) not null,
    isHot boolean not null ,
    isTop boolean not null ,
    ingredient varchar(1024),
    isOver boolean not null ,
    pinyin varchar(512) not null ,
    primary key (d_id)
#     foreign key (p_id) references provider(p_id)
)default charset=utf8;