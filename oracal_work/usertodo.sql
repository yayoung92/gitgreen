ALTER TABLE users
ADD CONSTRAINT aaa PRIMARY KEY (idx);

ALTER TABLE todo
ADD CONSTRAINT ccc
FOREIGN KEY (users_idx)
REFERENCES �ٸ����̺��̸� (idx);

create SEQUENCE usersIdx;

commit;

insert into users (idx) values (usersIdx.nextval);