SET FOREIGN_KEY_CHECKS=0;

drop table if exists indent;

create table indent(
    o_id int not null auto_increment,
    o_time datetime not null ,
    cost double(8,2) not null ,
    state enum('待支付','已接单','配送中','已完成','已取消') not null,
    addr varchar(50) not null ,
    u_id int not null ,
    rider int,
    p_id int not null ,
    primary key (o_id),
    foreign key (u_id) references user(id),
    foreign key (rider) references user(id),
    foreign key (p_id) references provider(p_id)
)default charset=utf8;