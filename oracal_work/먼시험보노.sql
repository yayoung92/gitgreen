select * from word;

select id from member;

select word_no, word, word_mean, insert_date from word;

insert into word(word_no, word, word_mean, insert_date, delete_yn, category)
values('ELF'||(ELF.nextval), '�ܾ�1','�׽�Ʈ��',sysdate,'N','CT1_CG3');

commit;

SELECT CASE WHEN category like 'CT1%' THEN '����ó�����'
WHEN category like 'CT2%' THEN 'SQLD' ELSE category END AS "ī�װ�",
word_no as "��ȣ", word as "�ܾ�", word_mean as "��", insert_date as  "�����"
FROM word WHERE category like 'CT1%' or category like 'CT2%';

FROM word WHERE category IN ('CT1', 'CT2');