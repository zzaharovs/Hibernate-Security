insert into users (username, password)
values ('adminss', 'adminpass');
insert into users (username, password)
values ('user', 'userpass');
insert into roles (role_name)
values ('ADMIN');
insert into roles (role_name)
values ('USER');
insert into permissions (permission_name, role_role_name)
values ('CREATE', 'ADMIN');
insert into permissions (permission_name, role_role_name)
values ('DELETE', 'ADMIN');
insert into permissions (permission_name, role_role_name)
values ('WRITE', 'ADMIN');
insert into permissions (permission_name, role_role_name)
values ('READ', 'ADMIN');
insert into permissions (permission_name, role_role_name)
values ('READ', 'USER');
insert into user_roles (custom_user_username, role_role_name)
values ('admin', 'ADMIN');
insert into user_roles (custom_user_username, role_role_name)
values ('user', 'USER');
insert into PERSONS (name, surname, age, phone_number, city_of_living)
values ('Боб', 'Дилан', '13', '312312', 'NEW YORK');
insert into PERSONS (name, surname, age, phone_number, city_of_living)
values ('Петр', 'Степанов', '27', '3123123', 'SPB');
insert into PERSONS (name, surname, age, phone_number, city_of_living)
values ('Билл', 'Миллиган', '28', '3123', 'LA');
insert into PERSONS (name, surname, age, phone_number, city_of_living)
values ('Уилл', 'Тернер', '99', '312313', null);
insert into PERSONS (name, surname, age, phone_number, city_of_living)
values ('Егор', 'Прилепин', '13', '323123', 'MOSCOW');
insert into PERSONS (name, surname, age, phone_number, city_of_living)
values ('Алиса', 'Касторкина', '45', '33123', 'SPB');
insert into PERSONS (name, surname, age, phone_number, city_of_living)
values ('Илон', 'Маск', '13', '31123', 'LA');
insert into PERSONS (name, surname, age, phone_number, city_of_living)
values ('Станислав', 'Карпов', '88', '313123', 'MOSCOW');