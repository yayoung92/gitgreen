ALTER USER HR ACCOUNT UNLOCK IDENTIFIED BY 1234;

create user usertodo identified by 1234;
grant connect, resource to usertodo;
commit;