select * from word;

select id from member;

select word_no, word, word_mean, insert_date from word;

insert into word(word_no, word, word_mean, insert_date, delete_yn, category)
values('ELF'||(ELF.nextval), '단어1','테스트중',sysdate,'N','CT1_CG3');

commit;

SELECT CASE WHEN category like 'CT1%' THEN '정보처리기사'
WHEN category like 'CT2%' THEN 'SQLD' ELSE category END AS "카테고리",
word_no as "번호", word as "단어", word_mean as "뜻", insert_date as  "등록일"
FROM word WHERE category like 'CT1%' or category like 'CT2%';

FROM word WHERE category IN ('CT1', 'CT2');