select * from member;

UPDATE word
SET insert_date = CURRENT_TIMESTAMP
WHERE insert_date IS NULL;

SELECT * FROM word WHERE word LIKE '%ho%' AND delete_yn = 'n';
SELECT * FROM word WHERE word_mean LIKE '%�׽�Ʈ%' AND delete_yn = 'n';

UPDATE WORD
SET DELETE_YN = UPPER(DELETE_YN);

commit;

SELECT word, word_mean,insert_date FROM word WHERE category LIKE 'CT1%' ORDER BY insert_date DESC;

select word_no, category from word order by insert_date desc;

select group_detail_no, group_detail_name from group_detail where group_no like 'CG';

select category,word_no, word, word_mean, insert_date from word order by insert_date desc;

select case when category like 'CT1%' then '����ó�����' 
when category like 'CT2%' then 'SQLD' end as ī�װ�,word_no as "��ȣ", word as "�ܾ�", word_mean as "��", insert_date as "�����" from word order by insert_date desc;








