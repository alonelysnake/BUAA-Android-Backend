SET FOREIGN_KEY_CHECKS=0;

drop table if exists feedback;

create table feedback(
    fb_id int not null auto_increment,
    a_id int,
    u_id int not null ,
    fb_content varchar(3000) not null ,
    primary key (fb_id)
#     foreign key (a_id) references admin(a_id),
#     foreign key (u_id) references user(u_id)
)default charset=utf8;