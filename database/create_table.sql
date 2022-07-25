use website_bao_chi;

create table role(
                     id bigint not null primary key auto_increment,
                     name varchar(150) not null,
                     code varchar(255) not null,
                     modifieddate timestamp null,
                     modifiedby varchar(255) null,
                     createddate timestamp null,
                     createdby varchar(255) null
);


create table user(
                     id bigint not null primary key auto_increment,
                     name varchar(150) not null,
                     password varchar(255) not null,
                     fullname varchar(255) not null,
                     roleid bigint not null,
                     status int not null,
                     modifieddate timestamp null,
                     modifiedby varchar(255) null,
                     createddate timestamp null,
                     createdby varchar(255) null
);
ALTER TABLE user add constraint fk_userrole_user foreign key (roleid) references role(id);


create table news(
                     id bigint not null primary key auto_increment,
                     title varchar(255) null,
                     thumbnail varchar(255) null,
                     shortdescription text not null,
                     content text null,
                     categoryid bigint not null,
                     modifieddate timestamp null,
                     modifiedby varchar(255) null,
                     createddate timestamp null,
                     createdby varchar(255) null
);

create table category(
                         id bigint not null primary key auto_increment,
                         name varchar(150) not null,
                         code varchar(255) not null,
                         modifieddate timestamp null,
                         modifiedby varchar(255) null,
                         createddate timestamp null,
                         createdby varchar(255) null
);
ALTER TABLE news add constraint fk_news_category foreign key (categoryid) references category(id);

create table comment(
                        id bigint not null primary key auto_increment,
                        content text not null,
                        user_id bigint not null,
                        news_id bigint not null,
                        modifieddate timestamp null,
                        modifiedby varchar(255) null,
                        createddate timestamp null,
                        createdby varchar(255) null
);
ALTER TABLE comment add constraint fk_comment_user foreign key(user_id) references user(id);
ALTER table comment add constraint fk_comment_news foreign key(news_id) references news(id);