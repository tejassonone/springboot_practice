create table user(
    userId int primary key,
    firstName varchar(120) not null,
    lastName varchar(120) not null,
    email varchar(120) not null,
    password varchar(120) not null,
    isAdmin boolean not null
);

create table personalInfo(
    id int primary key,
    countryCode varchar(5),
    mobileNo varchar(20),
    birthDate date,
    gender varchar(10),
    country varchar(120),
    state varchar(120),
    city varchar(120),
    whereDidYouHearAboutUs varchar(120),
    whatDoYouLookingFor varchar(120),
    createdAt timestamp,
    userId_FK int,
    foreign key (userId_FK) references user(userId)
);

create table Service(
    serviceId int primary key,
    serviceName varchar(120) not null,
    serviceDescription varchar(255) not null,
    createdAt timestamp not null,
    updatedAt timestamp not null,
    amount int not null
);

create table booking(
    bookingId int primary key,
    createdAt timestamp not null,
    status varchar(120) not null,
    userId_FK int,
    serviceId_FK int,
    foreign key (userId_FK) references user(userId),
    foreign key (serviceId_FK) references Service(serviceId)
);

create table Review(
    reviewId int primary key,
    reviewerName varchar(120) not null,
    reviewDescription varchar(255) not null,
    rating int not null,
    createdAt timestamp not null,
    serviceId_FK int,
    userId_FK int,
    foreign key (userId_FK) references user(userId),
    foreign key (serviceId_FK) references Service(serviceId)
);




