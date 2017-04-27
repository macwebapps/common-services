
create table user_role (
        user_role_id integer not null auto_increment,
        role varchar(255),
        user_id integer not null,
        primary key (user_role_id)
    );


INSERT INTO user_role (user_role_id, user_id, role) VALUES (1, 2, 'ADMIN');
INSERT INTO user_role (user_role_id, user_id, role) VALUES (2, 2, 'PREMIUM_MEMBER');
INSERT INTO user_role (user_role_id, user_id, role) VALUES (3, 1, 'MEMBER');
