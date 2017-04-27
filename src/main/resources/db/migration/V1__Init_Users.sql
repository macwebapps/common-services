
create table user (
        user_id integer not null auto_increment,
        enabled bit,
        password varchar(255) not null,
        user_name varchar(64) not null,
        primary key (user_id)
    );

INSERT INTO user(user_id, user_name, password, enabled) VALUES (1, 'user','user', true);
INSERT INTO user(user_id, user_name, password, enabled) VALUES (2, 'admin','admin', true);
