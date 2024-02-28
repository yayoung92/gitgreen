ALTER TABLE users
ADD CONSTRAINT aaa PRIMARY KEY (idx);

ALTER TABLE todo
ADD CONSTRAINT ccc
FOREIGN KEY (users_idx)
REFERENCES 다른테이블이름 (idx);

create SEQUENCE usersIdx;

commit;

insert into users (idx) values (usersIdx.nextval);