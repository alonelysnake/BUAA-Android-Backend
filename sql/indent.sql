SET FOREIGN_KEY_CHECKS=0;

drop table if exists indent;

create table indent(
    o_id int not null auto_increment,
    o_time datetime not null ,
    send_time datetime not null,
    cost double(8,2) not null ,
    state enum('NOT_PAY','PAID','NOT_ACCEPT','ACCEPTED','DELIVERING','FINISHED','CANCELED') not null,
    addr varchar(50) not null ,
    o_comment varchar(100),
    u_id varchar(15) not null ,
    rider varchar(15),
    p_id varchar(15) not null ,
    d_id int,
    primary key (o_id)
#     foreign key (u_id) references user(u_id),
#     foreign key (rider) references rider(r_id),
#     foreign key (p_id) references provider(p_id)
)default charset=utf8;