select * from word;

select id from member;

select word_no, word, word_mean, insert_date from word;

insert into word(word_no, word, word_mean, insert_date, delete_yn, category)
values('ELF'||(ELF.nextval), '단어1','테스트중',sysdate,'N','CT1_CG3');

commit;