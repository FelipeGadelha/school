  
create table MATTER(
	ID int AUTO_INCREMENT primary key not null,
	NAME varchar(200) not null,
	HOUR int not null,
	CODE varchar(200) not null,
	FREQUENCY int not null
);

CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1 INCREMENT BY 1;