select * from member;

UPDATE word
SET insert_date = CURRENT_TIMESTAMP
WHERE insert_date IS NULL;

SELECT * FROM word WHERE word LIKE '%ho%' AND delete_yn = 'n';
SELECT * FROM word WHERE word_mean LIKE '%Å×½ºÆ®%' AND delete_yn = 'n';

UPDATE WORD
SET DELETE_YN = UPPER(DELETE_YN);

commit;