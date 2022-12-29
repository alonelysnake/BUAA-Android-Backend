SET FOREIGN_KEY_CHECKS=0;

drop table if exists message;

create table message(
    m_id int not null auto_increment,
    s_id int not null ,
    r_id int not null ,
    m_time datetime not null ,
    m_content varchar(3000) not null ,
    primary key (m_id)
#     foreign key (s_id) references user(u_id),
#     foreign key (r_id) references user(u_id)
)default charset=utf8;