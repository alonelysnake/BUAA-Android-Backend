SET FOREIGN_KEY_CHECKS=0;

drop table if exists comment;

create table comment(
    c_id int not null auto_increment,
    c_content varchar(3000) not null ,
    c_time datetime not null ,
    recommend bool not null ,
    u_id int not null ,
    d_id int not null ,
    primary key (c_id),
    foreign key (u_id) references user(u_id),
    foreign key (d_id) references dish(d_id)
)default charset=utf8;